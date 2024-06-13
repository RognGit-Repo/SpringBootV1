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



 */