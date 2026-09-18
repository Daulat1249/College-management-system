# College Management System API

A RESTful backend API built with Java and Spring Boot that handles complex relational mappings for a university system. This project demonstrates advanced database design, entity lifecycle management, and relational mapping using Spring Data JPA and PostgreSQL.

## 🛠️ Tech Stack
* **Language:** Java
* **Framework:** Spring Boot 
* **Database:** PostgreSQL
* **ORM:** Hibernate / Spring Data JPA
* **Tools:** Lombok, Postman, DBeaver

## 🗄️ Database Architecture
This API handles the following relational mappings and automatically generates the necessary join tables and foreign key constraints:
* **One-to-One:** `Student` ↔ `AdmissionRecord` 
* **One-to-Many:** `Professor` ↔ `Subject`
* **Many-to-Many:** `Professor` ↔ `Student`
* **Many-to-Many:** `Student` ↔ `Subject`

## 🚀 API Endpoints
The system exposes relational assignment endpoints to dynamically link records:
* `PUT /api/college/subjects/{subjectId}/professors/{professorId}` - Assigns a subject to a professor.
* `POST /api/college/students/{studentId}/admissions` - Creates and links an admission record.
* `PUT /api/college/professors/{professorId}/students/{studentId}` - Enrolls a student under a professor.
* `PUT /api/college/students/{studentId}/subjects/{subjectId}` - Enrolls a student in a specific subject.

## ⚙️ Setup Instructions
1. Clone the repository.
2. Update `application.properties` with your PostgreSQL credentials.
3. Ensure a database named `college_DB` exists.
4. Run the application. Hibernate will automatically generate the schema via `ddl-auto=create`.
