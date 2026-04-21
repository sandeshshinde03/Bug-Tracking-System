# 🐞 Bug Tracking System

## 📌 Project Overview
The **Bug Tracking System** is a full-stack web application designed to manage and track software bugs efficiently across different projects. It helps teams report, assign, monitor, and resolve issues in a structured way.

This system improves **software quality, team collaboration, and project transparency**.

---

## 🎯 Key Features

- 👤 **User Roles & Authentication**
  - Admin, Developer, Tester
  - Secure login using Spring Security

- 🐛 **Bug Management**
  - Create, update, delete bugs
  - Assign bugs to developers
  - Track bug status (Open → In Progress → Resolved)

- 📊 **Dashboard**
  - View bug statistics
  - Monitor project progress

- 💬 **Comments System**
  - Users can add comments on bugs for better communication

- 🔍 **Search & Filter**
  - Filter bugs by status, priority, or assigned user

---

## 🏗️ Tech Stack

### Backend:
- Java
- Spring Boot
- Spring Security
- Hibernate (JPA)

### Frontend:
- Thymeleaf
- Bootstrap 5

### Database:
- MySQL

### Tools:
- Maven
- Git & GitHub

---

## 🧠 System Architecture

The application follows **MVC Architecture**:

- **Controller Layer** → Handles incoming requests  
- **Service Layer** → Contains business logic  
- **Repository Layer** → Handles database operations  
- **Entity Layer** → Represents database tables  

---

## 🔄 Bug Lifecycle

1. Tester reports a bug  
2. Admin assigns the bug to a Developer  
3. Developer updates status:
   - Open  
   - In Progress  
   - Resolved  
4. Tester verifies and closes the bug  

---

## 🗄️ Database Design

The application uses **MySQL** with relational mapping implemented using **Hibernate (JPA)**. 
---

### 📌 Entities Overview

#### 🔹 User
- id (Primary Key)
- name
- email (Unique)
- password
- role (ADMIN / DEVELOPER / TESTER)

---

#### 🔹 Project
- id (Primary Key)
- name
- description
- createdDate

---

#### 🔹 Bug
- id (Primary Key)
- title
- description
- priority (LOW, MEDIUM, HIGH, CRITICAL)
- status (OPEN, IN_PROGRESS, RESOLVED, CLOSED)
- createdDate
- project_id (Foreign Key)
- reporter_id (Foreign Key → User)
- developer_id (Foreign Key → User)

---

#### 🔹 Comment
- id (Primary Key)
- message
- createdDate
- bug_id (Foreign Key)
- user_id (Foreign Key)

---

### 🔗 Relationships

- One **Project** → Many **Bugs**  
- One **User (Reporter)** → Many **Reported Bugs**  
- One **User (Developer)** → Many **Assigned Bugs**  
- One **Bug** → Many **Comments**  
- One **User** → Many **Comments**

---

### 🧠 ORM Mapping (JPA)

- `@OneToMany` → Project → Bugs  
- `@ManyToOne` → Bug → Project  
- `@ManyToOne` → Bug → User (Reporter & Developer)  
- `@OneToMany` → Bug → Comments  
- `@ManyToOne` → Comment → Bug  
- `@ManyToOne` → Comment → User  

---

## 📁 Project Structure

```
bugtracker/
│── src/main/java/com/bugtracker
│   ├── controller
│   ├── service
│   ├── serviceImpl
│   ├── repository
│   ├── entity
│   ├── config
│
│── src/main/resources/
│   ├── templates/
│   │   ├── admin/
│   │   ├── developer/
│   │   ├── tester/
│   ├── static/
│   │   ├── css/
│   │   ├── images/
│
│── application.properties
│── pom.xml
```
