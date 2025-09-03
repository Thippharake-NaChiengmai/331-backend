# Lab07 - Introduction to Spring Boot

A Spring Boot REST API application for managing events and organizers. This lab demonstrates the fundamentals of Spring Boot development including REST controllers, service layers, and data access objects.

## Overview

This Spring Boot application provides RESTful APIs for an event management system with:
- Event and organizer CRUD operations
- Pagination support
- 3-layer architecture (Controller → Service → DAO)
- In-memory data storage with sample data

## Technology Stack

- **Java 21** + **Spring Boot 3.5.5** + **Maven** + **Lombok**

## Architecture

**3-Layer Pattern:**
- **Controller**: REST endpoints (`EventController`, `OrganizerController`)
- **Service**: Business logic (`EventServiceImpl`, `OrganizerServiceImpl`)  
- **DAO**: Data access with in-memory storage (`EventDaoImpl`, `OrganizerDaoImpl`)

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/event?_limit={size}&_page={page}` | Get events with pagination |
| GET | `/events/{id}` | Get single event by ID |
| GET | `/organizers?_limit={size}&_page={page}` | Get organizers with pagination |
| GET | `/organizers/{id}` | Get single organizer by ID |

**Base URL:** `http://localhost:8080`

## Data Models

```json
// Event
{
  "id": 123,
  "category": "animal welfare",
  "title": "Cat Adoption Day",
  "description": "Find your new feline friend",
  "location": "Meow Town",
  "date": "January 28, 2022",
  "time": "12:00",
  "petAllowed": true,
  "organizer": { "id": 1, "organization": "Kat Laydee Foundation", "address": "123 Cat Street" }
}

// Organizer
{
  "id": 1,
  "organization": "Kat Laydee Foundation",
  "address": "123 Cat Street, Meow Town"
}
```

## Getting Started

**Prerequisites:** Java 21 + Maven

```bash
# Run the application
mvn spring-boot:run

# Test endpoint
curl http://localhost:8080/event
```

## Sample Data

**Events (9 total):** Cat/Dog Adoption, Community Gardening, Beach/Highway Cleanup, Food Drive, Educational events

**Organizers (7 total):** Various foundations and organizations

## Features

- ✅ In-memory data storage with sample events and organizers
- ✅ Pagination support (`_limit` and `_page` parameters)
- ✅ CORS enabled for frontend integration (`localhost:5173`)
- ✅ RESTful API design with proper HTTP status codes
- ✅ 3-layer architecture demonstrating Spring Boot best practices
