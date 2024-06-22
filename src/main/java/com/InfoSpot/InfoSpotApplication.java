package com.InfoSpot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InfoSpotApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfoSpotApplication.class, args);
	}

}


/*
1. Initialize app using Spring Bot
	Versions:
		Java:22
		Spring 3.3.1
		<version>3.3.1-SNAPSHOT</version>


		MAVEN
		Initial dependencies

			Spring Web
			JPA


		Pom
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

	2. Add the following dependencies
		lombok
			-reduce boilerplate example getters and setters
		jdbc
			-Note to use JDBC template and application.properties with autoconfiguration

			<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-jdbc</artifactId>
		</dependency>

		<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
			<version>42.3.5</version> <!-- Use the latest version -->
		</dependency>

		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>

	3. Setup application.properties
	spring.datasource.url=jdbc:postgresql://localhost:5432/main
spring.datasource.username=postgres
spring.datasource.password=@Rogn5432
spring.datasource.driver-class-name=org.postgresql.Driver


4. try if the controller works, also use annotation @RestController to lessen explicit mapping of components

	define the test() method

5.Create the Product Entity, use lombok annotations to reduce writing manually the getters and setters

6. Create and use the JPARepository to leverage the built in functions to access the database

	Add the application properties
		# Set the Hibernate dialect for PostgreSQL
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

spring.jpa.hibernate.ddl-auto=update

logging.level.org.hibernate.SQL=DEBUG


7. Create one implementation to the productRepository and call the class ProductService

8. As a sample use dependency injection of ProductService in the constructor to have and instance of prouctservice, thus
creating the product table on the postgreDatabase

9. Create a seed method in the ProductService, where it puts one entry the the table. Then use the method in the controller
to seed the database once an endpoint is reached


10.Pratice the one to one, one to many and many to many relationship of tables and how to create entities which uses the
JPA auto creation of table. Highglight the many to many relationship set-up where an intermediate table is created

One to One

import javax.persistence.*;

@Entity
public class ParentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Other fields

    // Define the relationship to the child entity
    @OneToOne(mappedBy = "parent", cascade = CascadeType.ALL)
    private ChildEntity child;

    // Constructors, getters, and setters
}



ChatGPT
To create an entity with a foreign key relationship using JPA in a Spring application, you typically follow these steps:

Define Entity Classes: Create the entity classes representing your tables. One entity should represent the primary table, and the other should represent the referenced table with the foreign key.

Define Relationships: Use JPA annotations to define the relationships between the entities.

Ensure Proper Mapping: Ensure that the mappings are correct between the primary and referenced entities.

Here's a simple example:

Primary Entity (Parent Entity):
java
Copy code
import javax.persistence.*;

@Entity
public class ParentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Other fields

    // Define the relationship to the child entity
    @OneToOne(mappedBy = "parent", cascade = CascadeType.ALL)
    private ChildEntity child;

    // Constructors, getters, and setters
}



import javax.persistence.*;

@Entity
public class ChildEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Other fields

    // Define the relationship to the parent entity
    @OneToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    private ParentEntity parent;

    // Constructors, getters, and setters
}


One to Many
import javax.persistence.*;
import java.util.List;

@Entity
public class ParentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Other fields

    // Define the one-to-many relationship to the child entity
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<ChildEntity> children;

    // Constructors, getters, and setters
}
import javax.persistence.*;

@Entity
public class ChildEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Other fields

    // Define the many-to-one relationship to the parent entity
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private ParentEntity parent;

    // Constructors, getters, and setters
}

Many to Many
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class EntityA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Other fields

    // Define the many-to-many relationship with EntityB
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "entitya_entityb",
            joinColumns = @JoinColumn(name = "entitya_id"),
            inverseJoinColumns = @JoinColumn(name = "entityb_id"))
    private Set<EntityB> entityBs = new HashSet<>();

    // Constructors, getters, and setters
}
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class EntityB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Other fields

    // Define the many-to-many relationship with EntityA
    @ManyToMany(mappedBy = "entityBs")
    private Set<EntityA> entityAs = new HashSet<>();

    // Constructors, getters, and setters
}

11. Take note of the difference above. Mainly how annotations are used and the object type of the fields from single
variable (one relation) to array (many relationship). Also take not of the intermediate table created by the many to many
relationship.


12.Create the table and relations in the sample postgre dvd rental database.

13. Using chatgpt generate all the entity for the entity model with JPA annotations since the dvd rental database is
very common chatgpt will know the context

14. Testing the entities if it would create automatically in the new database called info-soft,

	there is no intermediate entities example film_actor since it can be created automatically

	Problem: The intermediate entities are not created


	Use this
	Parent Entity
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "entitya_entityb",
            joinColumns = @JoinColumn(name = "entitya_id"),
            inverseJoinColumns = @JoinColumn(name = "entityb_id"))
    private Set<EntityB> entityBs = new HashSet<>();

    Connected Entity
    @ManyToMany(mappedBy = "entityBs")
    private Set<EntityA> entityAs = new HashSet<>();


15. Look at the special fields of staff and store, they both have foreignkey of each other.

	staff -> store_id
	store -> manager_staff_id


	but the manager_staff_id is a staff but a manager property of store

	We can also remove that manager_staff_id and put bool isManager property in the staff

	However I think the reason why it was coded that way is that there is no need to traverse the
	staff with matching store_id just to find whose the manager



16. Since from original there is last_update column in each table we will also do that so that we can trace or filter
	the data based on the date it was modified

	Do not forget the annotation
	@EntityListeners({ MyEntityListener.class })

	to listen to events and run the callback functions

	In Each table add
	Intermediate Tables definitions
	// Additional column definition
               joinColumns = {
                   @JoinColumn(name = "last_update")
               }

    Main Tables
    @Column(name = "last_modified")
    private LocalDateTime lastModified;

    // Constructors, getters, setters

    @PrePersist
    protected void onCreate() {
        lastModified = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        lastModified = LocalDateTime.now();
    }

    There is still bugs in this part since it produces a null value upon creation


17. Modifications on the table columns to match the original dvd_rental database and for the purpose of knowing the different
	configurations of each column in tables

	All
	id generation type =nextval('actor_actor_id_seq'::regclass)
	use

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "actor_id_generator")
    @SequenceGenerator(name = "actor_id_generator", sequenceName = "actor_actor_id_seq", allocationSize = 1)
    private Long actorId; / private int actorId;


	not_nullable columns
	@Column(nullable = false) // Specify NOT NULL constraint

	Actor
	actor_id [int, not_nullable=true]
	first_name [short /varcharr45, not_nullable=true]

	use
	@Size(max = 45) // Specify maximum length of 45 characters
    private String name;


    time to have  a now() postgre default value
    createdAt
    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;


    small_int/short
    private Short salary; // Using Short to map to smallint in PostgreSQL


	#Existing DB


18. From above we used GenerationType.SEQUENCE  which requires additional configuration than simply using
	GenerationType.IDENTITY

	In DB set the property Default to a method that gets the nextVal of the sequence

		Postgre
		table->properties->default
		type
		nextval('actor_actor_id_seq'::regclass)

19. In step 16, we added the last_update column, we also need to add the property to the defualt value

		Postgre
		table->properties->default
		type
		now()

20. Optional [not necessary for  now], using the below dependency lets us create a column that has validation such as the min
	or max size of String or the varChar(255) varChar(45) for intance



	<dependency>
    <groupId>org.hibernate.validator</groupId>
    <artifactId>hibernate-validator</artifactId>
    <version>6.2.0.Final</version> <!-- Replace with the latest version -->
</dependency>

	use
	@Size(max = 45) // Specify maximum length of 45 characters
    private String name;

21. Add the not_nullable properties



22.Authentication and Authorization

Adding authentication in springboot uses a class of WebSecurityConfigurerAdapter
It overrides the configure method where chain of authentication rules are used

***This means that there is no need to have a controller for all auth such as authUser for /login
This are already handled in the example below

http
            .authorizeRequests()
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/home")
                .permitAll()
                .and()
            .logout()
                .logoutSuccessUrl("/login?logout")
                .permitAll();



 */