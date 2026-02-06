# Clinic Appointment Booking System 

## Project Overview

A simple **Clinic Appointment Booking System** built with **Java Spring Boot**, **Thymeleaf**, **MySQL**, **HTML/CSS**, and **JavaScript**. The system allows clinics to manage **patients**, **doctors**, and **appointments** efficiently while preventing double bookings and tracking appointment statuses.

## Features

### Patients Management

* Register new patients
* View all patients
* Edit patient details
* Delete patients

### Doctors Management

* Add new doctors
* View all doctors
* Edit doctor details
* Delete doctors

### Appointments Management

* Book new appointments
* View all appointments
* Edit appointment details
* Cancel appointments
* Track appointment status:

  * **BOOKED** (Blue)
  * **COMPLETED** (Green)
  * **CANCELLED** (Red)

## Tech Stack

* **Backend:** Java 21, Spring Boot, Spring Data JPA (Hibernate)
* **Frontend:** Thymeleaf, HTML5, CSS3, JavaScript
* **Database:** MySQL
* **Build Tool:** Maven

## Project Structure

```
ClinicSystem/
│── src/main/java/com/clinic
│     ├── controller
│     ├── service
│     ├── repository
│     ├── model
│     
│── src/main/resources
│     ├── templates/       # Thymeleaf HTML files
│     ├── static/css        # CSS files
│     ├── static/js         # JS files
│     └── application.yml   # Configuration file
│── screenshots/           # screenshots 
│── pom.xml
│── README.docx
│── .gitignore
```

## Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/clinic-system.git
cd clinic-system
```

### 2. Configure MySQL Database

```sql
CREATE DATABASE clinic_db;
```

### 3. Update `application.yml`

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/clinic_db
    username: root
    password: @Sino2025
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
  thymeleaf:
    cache: false

server:
  port: 8080
```

### 4. Run the Application

```bash
mvn spring-boot:run
```

Visit in browser: `http://localhost:8080`

## Screenshots

* Dashboard: `screenshots/dashboard.png`
* Patients Page: `screenshots/patients.png`
* Appointments Page: `screenshots/appointments.png`

## Future Improvements

* Add user authentication (Admin / Staff login)
* Search and filter appointments
* Appointment reminders via email or SMS
* Export reports (PDF/Excel)
* Dashboard analytics and charts

## What I Learned

* Spring Boot MVC architecture and project structure
* CRUD operations using Spring Data JPA
* One-to-Many and Many-to-One entity relationships
* Thymeleaf for dynamic HTML templates
* Frontend styling and responsive UI
* Handling date and time in Java

## Author

Sinovuyo Mlanjeni : 
Aspiring Junior Java Developer 🇿🇦

## License

This project is for **educational purposes**.
