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


 */