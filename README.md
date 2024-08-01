# MicroTask

MicroTask es una aplicación de gestión de tareas basada en microservicios utilizando Spring Boot. El proyecto está compuesto por dos servicios principales: `user-service` y `task-service`.

## Contenido

- [Requisitos Previos](#requisitos-previos)
- [Instalación](#instalación)
- [Configuración](#configuración)
- [Ejecución](#ejecución)
- [Endpoints](#endpoints)
- [Estructura del Proyecto](#estructura-del-proyecto)


## Requisitos Previos

- Java 17
- Maven
- PostgreSQL
- Postman (opcional, para pruebas)

## Instalación

1. Clonar el repositorio:

   ```bash
   git clone https://github.com/anderson420/MicroTask.git
   cd MicroTask
2.Configurar las bases de datos en PostgreSQL:
   CREATE DATABASE microuser;
   CREATE DATABASE microtask;
3.Configurar las credenciales de PostgreSQL en los archivos application.properties de ambos servicios.

## Configuración:
1. user-service
   Ubicación: user-service/src/main/resources/application.properties
      server.port=8080
      server.servlet.context-path=/micro-user
      spring.application.name=microuser
      spring.datasource.url=jdbc:postgresql://localhost:5432/microuser
      spring.datasource.username=postgres
      spring.datasource.password=admin
      spring.datasource.driver-class-name=org.postgresql.Driver
      spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
      spring.jpa.hibernate.ddl-auto=update
      spring.jpa.show-sql=true
2.task-service
   Ubicación: task-service/src/main/resources/application.properties
      server.port=8081
      server.servlet.context-path=/micro-task
      spring.application.name=microtask
      spring.datasource.url=jdbc:postgresql://localhost:5432/microtask
      spring.datasource.username=postgres
      spring.datasource.password=admin
      spring.datasource.driver-class-name=org.postgresql.Driver
      spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
      spring.jpa.hibernate.ddl-auto=update
      spring.jpa.show-sql=true
      feign.hystrix.enabled=true
#Ejecución:
1.microuser
   1. Navegar al directorio user-service:
      cd microuser
   2. Compilar y ejecutar el servicio:
      mvn clean install
      mvn spring-boot:run
1.microtask
   1. Navegar al directorio user-service:
      cd microtask
   2. Compilar y ejecutar el servicio:
      mvn clean install
      mvn spring-boot:run
#Endpoints:
   user-service
      Crear Usuario
      POST /micro-user/user
         {
           "name": "John Doe",
           "email": "john.doe@example.com"
         }
      Obtener Usuario por ID
      GET /micro-user/users/{id}


   task-service
      Crear Tarea
      POST /micro-task/task
         {
           "title": "Sample Task",
           "description": "This is a sample task",
           "status": "PENDING",
           "userId": 1
         }
      
      Obtener Tarea por ID
      GET /micro-task/tasks/{id}
      
      Obtener Todas las Tareas con Detalles de Usuario
      GET /micro-task/tasks/with-users
#Estructura del Proyecto:
      MicroTask
      ├── microuser
      │   ├── src
      │   │   ├── main
      │   │   │   ├── java
      │   │   │   │   └── com.example.userservice
      │   │   │   │       ├── controller
      │   │   │   │       ├── model
      │   │   │   │       ├── repository
      │   │   │   │       └── service
      │   │   ├── resources
      │   │   │   └── application.properties
      │   ├── test
      │   │   └── java
      │   └── pom.xml
      ├── microtask
      │   ├── src
      │   │   ├── main
      │   │   │   ├── java
      │   │   │   │   └── com.example.taskservice
      │   │   │   │       ├── controller
      │   │   │   │       ├── model
      │   │   │   │       ├── repository
      │   │   │   │       ├── service
      │   │   │   │       └── integration
      │   │   ├── resources
      │   │   │   └── application.properties
      │   ├── test
      │   │   └── java
      │   └── pom.xml
      ├── README.md
      └── .gitignore

      





