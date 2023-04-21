# Spring Boot Full Stack Book Rental System (in progress)

A full stack book rental system built using Spring Boot, Vue.js, and PostgreSQL.

## Table of Contents

- [Technologies](#technologies)
- [Database Schema](#database-schema)
- [Getting Started](#getting-started)
    - [Bootstrap the database with Docker](#bootstrap-the-database-with-docker)
    - [Remove the database from Docker](#remove-the-database-from-docker)

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