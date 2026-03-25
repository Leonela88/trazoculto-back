# Trazoculto - Editorial Management System

Digital solution for managing the editorial workflow, connecting authors, editors, and publishing projects in a centralized platform.

## Table of Contents
1. [General Info](#general-info)
2. [Technologies](#technologies)
3. [Features](#features)
4. [Installation](#installation)

## General Info
***
**Trazoculto** is a management system designed for a specialized publishing house. It streamlines the workflow between authors and editor, allowing for efficient project tracking, client registration, and manuscript status management.

**Project Status**: `MVP (Minimum Viable Product) - In Development`  
The application currently supports core operations for managing the editorial pipeline and client database.

## Technologies
***
* **[Java](https://www.oracle.com/java/)**: Version 17+ (Core Language)
* **[Spring Boot](https://spring.io/projects/spring-boot)**: 3.x (Main Framework)
* **[Spring Data JPA](https://spring.io/projects/spring-data-jpa)**: For ORM and database communication.
* **[Lombok](https://projectlombok.org/)**: To reduce boilerplate code (Getters, Setters, Constructors).
* **[MapStruct](https://mapstruct.org/)**: For efficient and type-safe mapping between Entities and DTOs.
* **[Spring Beans](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans)**: Dependency injection 
* **[H2 Database](https://www.h2database.com/)**: In-memory database used for development and testing.
* **[Spring Security](https://spring.io/projects/spring-security)**: Handling Basic Auth and CORS.


## Features
***
###  Project Management (CRUD)
* **Create**: Register new editorial projects with specific metadata.
* **Read**: List all active projects using optimized DTOs (Short Response) for better performance.
* **Update**: Modify project details and track status changes.
* **Delete**: Remove obsolete or cancelled projects from the system.

###  Client Administration
* **Registration**: Securely add new authors and collaborators to the database.
* **Relationship**: Link clients directly to their respective editorial projects.

###  Security & Integration
* **Basic Authentication**: Secured endpoints requiring valid credentials for data access.
* **CORS Policy**: Configured to allow secure communication between the Vite frontend and Spring Boot backend.
* **Global Interceptors**: Centralized error handling and automatic token attachment for all API requests.

## Installation
***
To run this project locally, follow these steps:

### Backend Setup
```bash
# Clone the repository
$ git clone [https://github.com/Leonela88/trazoculto-back.git](https://github.com/Leonela88/trazoculto-back.git)

# Navigate to the project folder
$ cd trazoculto-back

# Run the Spring Boot application
$ ./mvnw spring-boot:run
