# Full Stack Book Rental System (In Progress)

A full stack book rental system built using Spring Boot, Vue.js, and PostgreSQL.

## Table of Contents

- [Technologies](#technologies)
- [Database Schema](#database-schema)
- [Getting Started](#getting-started)
  - [Bootstrap the database with Docker](#bootstrap-the-database-with-docker)
  - [Remove the database from Docker](#remove-the-database-from-docker)
- [Backend Development](#backend-development)
  - [Current State](#current-state)
- [Frontend Development](#frontend-development)
  - [Current State](#current-state-1)

## Technologies

### Backend
- Spring Boot 3
- Spring Security
- JWT

### Frontend
- Vue.js
- Vite

## Database Schema

![Book Lending Schema](./book-lending-schema.png)

## Getting Started

### Bootstrap the database with Docker
```
make bootstrap-db
```

### Remove the database from Docker
```
make down
```

## Backend Development
### Current State
- User registration
  - via POST request to localhost:8080/api/users
  - password is hashed
- User authentication with JWT token
- Login
  - via POST request to localhost:8080/api/auth/login
  - Checks username (phone_number) and password

## Frontend Development
### Current State
- Log-in and register page
- Redirects to simple HTML page if log-in or register is successful
- Run the frontend (make sure backend and database on Docker are running)
```
cd frontend/vue
npm run dev
```

## Note
Due to time constraints and being new to Spring Security, the project is still in progress.