# 🏦 Sai Official Bank – Full-Stack Banking Application (Spring Boot)

A production-style **banking system** built with **Java 21 + Spring Boot** featuring secure authentication, role-based access, account management, transactions, and an admin dashboard. Designed as a **portfolio project** to demonstrate real-world backend engineering practices.

---

## Tech Stack

- **Backend:** Java 21, Spring Boot 3.3  
- **Security:** Spring Security (Login + Roles)  
- **Database:** MySQL (JPA / Hibernate)  
- **ORM:** Spring Data JPA  
- **Build Tool:** Maven  
- **Server:** Embedded Tomcat  
- **Optional:** Docker, Postman  

---

## Features

### Authentication & Roles
- Login system using Spring Security  
- Role-based access:
  - `ROLE_USER`
  - `ROLE_ADMIN`

### 🏦 Banking Features
- Create bank accounts  
- View all accounts  
- Transfer money between accounts  
- Transaction history  
- Persistent data (MySQL)

### Admin Panel (`/admin`)
- View all users  
- Lock / unlock user accounts  
- View all transactions  
- Admin-only secured endpoints  

### Best Practices
- Layered architecture (Controller → Service → Repository)  
- DTO-based requests  
- Exception handling  
- Database persistence  
- Secure endpoints  

---

## Project Structure

banking-system/
├── src/main/java/com/example/banking
│ ├── controller/
│ ├── service/
│ ├── repository/
│ ├── model/
│ ├── dto/
│ ├── exception/
│ ├── config/
│ └── BankingSystemApplication.java
├── src/main/resources/
│ ├── application.yml
│ └── data.sql
├── pom.xml
└── README.md
