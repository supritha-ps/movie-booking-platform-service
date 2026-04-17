# 🎬 Movie Booking Platform

## 📌 Overview

This project implements a simplified **Movie Ticket Booking Platform** that supports:
- Browsing shows for a selected movie and city
- Booking tickets with seat selection
- Handling concurrency to prevent double booking

The solution focuses on **clean architecture, transactional integrity, and scalability considerations**.

---

## 🚀 Features Implemented

### ✅ Read Scenario
- Browse theatres and shows by movie and city  
  `GET /movies/{movieId}/shows?city=Bangalore`

### ✅ Write Scenario
- Book tickets by selecting show and seats  
  `POST /bookings`

### ✅ Additional Features
- Seat locking to prevent concurrent booking conflicts
- Global exception handling
- Idempotent data initialization (`data.sql`)
- Swagger API documentation

---

## 🏗️ High-Level Design

The application follows a **layered architecture**:

Controller → Service → Repository → Database

- **Controller Layer**: Handles HTTP requests
- **Service Layer**: Contains business logic and transaction handling
- **Repository Layer**: Handles database interactions via JPA
- **Database**: PostgreSQL (or H2 for local testing)

---

## 🧱 Data Model

Key entities:

- **Movie** → Movie details
- **Theatre** → Theatre and city info
- **Show** → Movie show timings
- **ShowSeat** → Seat availability per show
- **Booking** → Booking details

---

## 🔄 Booking Flow

1. User selects show and seats
2. Seats are fetched with **pessimistic locking**
3. Availability is validated
4. Seats are temporarily locked
5. Booking is created
6. Payment is simulated
7. Seats are marked as **BOOKED**

---

## ⚠️ Concurrency Handling

To prevent **double booking**, the system uses:

- **Pessimistic Locking** (`@Lock(PESSIMISTIC_WRITE)`)
- Transactional boundary using `@Transactional`

This ensures:
- Only one user can book a seat at a time
- Data consistency is maintained

---

## ⚙️ Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Swagger (Springdoc OpenAPI)

---

## 📡 API Endpoints

### 🎬 Get Shows