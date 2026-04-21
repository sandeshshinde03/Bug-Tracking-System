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
