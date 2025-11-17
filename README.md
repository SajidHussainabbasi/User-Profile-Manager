#  User Profile Manager

## 🧩 Description
A simple **Spring Boot REST API** for managing basic user profiles.  
Each user profile includes: `id`, `name`, and `email`.  
The API ensures that **user profiles have valid names and emails**, and that **emails are unique**.

---

## ⚙️ Features
- **GET /api/users** → Retrieve all user profiles
- **POST /api/users** → Add a new user profile
- **GET /api/users/{id}** → Retrieve a user profile by ID
- **PUT /api/users/{id}** → Update an existing user profile
- **DELETE /api/users/{id}** → Delete a user profile

---

## 💡 Concepts Used
- **Spring Boot** for building RESTful APIs
- **Spring Data JPA** for ORM and database operations
- **PostgreSQL** database support
- **Validation** using annotations like `@Valid`, `@NotBlank`, `@Email`
- **Service-layer Business Logic** (no logic in Controller)
- **DTO (Data Transfer Object)** pattern for request/response separation (`CreateUserDTO`, `UserResponseDTO`)
- **Mapper Layer** (`UserMapper`) for entity ↔ DTO mapping
- **Exception Handling** with `EmailAlreadyExistsException` and a global `GlobalExceptionHandler`
- **Layered Architecture** → `Controller → Service → Repository → Mapper → Model → DTO → Exception`
- **POST Operation Flow** → `DTO → Validation → Mapper → Entity → Repository → Database`

---

## 🧠 Learning Focus
- Writing **custom validation** and exception handling in Spring Boot
- Structuring backend services with DTOs and mappers
- Ensuring **unique constraints** in database operations
- Using **MapStruct** for clean entity ↔ DTO mapping
- Maintaining clean, maintainable, and testable code

---

## 🧑‍💻 Developed By
**Name:** Sajid Hussain  
**Project:** User Profile Manager  
**Language:** ☕ Java  
**Date:** 17 November 2025
