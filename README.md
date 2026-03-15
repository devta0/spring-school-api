# Spring School API

A basic Spring Boot application with CRUD APIs for **Students** and **Teachers**.

## Tech Stack
- Java 21
- Spring Boot 3.3.x
- Spring Web
- Spring Data JPA
- H2 (in-memory)
- Maven

## Run Locally
```bash
mvn clean test
mvn spring-boot:run
```

Server: `http://localhost:8080`

## APIs

### Student APIs
- `GET /api/students`
- `GET /api/students/{id}`
- `POST /api/students`
- `PUT /api/students/{id}`
- `DELETE /api/students/{id}`

Sample payload:
```json
{
  "name": "Alice",
  "age": 16,
  "grade": "10th"
}
```

### Teacher APIs
- `GET /api/teachers`
- `GET /api/teachers/{id}`
- `POST /api/teachers`
- `PUT /api/teachers/{id}`
- `DELETE /api/teachers/{id}`

Sample payload:
```json
{
  "name": "Mr. Sharma",
  "subject": "Mathematics",
  "experienceYears": 8
}
```

## Validation & Error Handling
- Bean validation for request fields
- Global exception handler for:
  - not found (`404`)
  - request validation (`400`)
  - generic server errors (`500`)

## H2 Console
- URL: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:schooldb`
- User: `sa`
- Password: *(empty)*
