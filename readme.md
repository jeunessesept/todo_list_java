# Todo List API

A simple REST API for managing tasks

## Features

- Retrieve all tasks
- Retrieve a task by its ID
- Create a new task
- Mark a task as completed
- Retrieve overdue tasks
- Validate task titles
- Return appropriate HTTP error responses

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/tasks` | Retrieve all tasks |
| GET | `/api/tasks/{id}` | Retrieve a task by ID |
| POST | `/api/tasks` | Create a new task |
| PUT | `/api/tasks/{id}/complete` | Mark a task as completed |
| GET | `/api/tasks/overdue` | Retrieve overdue tasks |

## Validation

The `title` field cannot be empty nor null.

If validation fails, the API returns a `400 Bad Request` response with a clear error message.

Example:

```text
Title cannot be blank
```

## Technologies

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Maven

## Project Initialization

The project was initially generated using Spring Initializr.

## Running the Application

Run the application from the project root:

```bash
./mvnw spring-boot:run
```

The API will be available at:

`http://localhost:8080`