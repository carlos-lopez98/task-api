# 🧠 Task Buddy API

A personal review project for reinforcing Spring Boot fundamentals, JPA relationships, and clean API design using DTOs and mappers.

---

## 🚀 Features

- Full CRUD support for Users and Tasks
- One-to-Many relationship: One User → Many Tasks
- DTO mapping with custom mappers
- PostgreSQL integration with environment variable config
- Seeded sample data for quick local testing

---

## 📁 Tech Stack
- Java 17
- Spring Boot 3.x
- PostgreSQL
- JPA + Hibernate
- Lombok
- RESTful API with DTOs

---

## 🛠️ Setup

1. **Clone the repo**
   ```bash
   git clone https://github.com/yourusername/task-buddy-api.git
   cd task-buddy-api
   ```
2. **Configure Environment Variables
```bash
export DB_URL=jdbc:postgresql://localhost:5432/yourdatbasename
export DB_USERNAME=your_db_user
export DB_PASSWORD=your_db_password
source ~/.bashrc  # or source ~/.zshrc
```
3. **Run the App**
```bash
./mvnw spring-boot:run
```
Database will auto-seed sample data
A bash `data.sql` file is provided in  `src/main/resources`. On app startup, it will prepopulate the database with 3 users and 4 tasks for testing.

---
## 🧪 Testing (Curl)
**Get All Users**
```bash
curl http://localhost:8080/api/users
```
**Get user by ID**
```bash
curl http://localhost:8080/api/users/1
```
**Get user by email**
```bash
curl "http://localhost:8080/api/users/search?email=carlos@example.com"
```
**Get all Tasks**
```bash
curl http://localhost:8080/api/tasks
```
**Create new Task**
```bash
curl -X POST http://localhost:8080/api/tasks \
  -H "Content-Type: application/json" \
  -d '{
    "title": "New Task",
    "description": "Try this API out",
    "userId": 1
  }'
```
**Get User by Task Id**
```bash
curl http://localhost:8080/api/tasks/user/1
```

---

## 📥 Fork & Clone

To clone the repository:

```bash
git clone https://github.com/carlos-lopez98/task-api.git
cd task-buddy-api
```
