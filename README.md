# Movie Booking Platform

## Features Implemented
- Browse shows by city
- Book tickets with seat locking

## Tech Stack
- Java
- Spring Boot
- JPA (Hibernate)
- H2 DB

## Key Design Decisions
- Used pessimistic locking to prevent double booking
- Transactional booking flow
- Modular design for future microservices

## Assumptions
- Payment is mocked
- Single region deployment

## Future Enhancements
- Redis for caching
- Kafka for async events
- Payment gateway integration