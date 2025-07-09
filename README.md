# 📚 Library Management System – Microservices Architecture

This project is a **Library Management System** designed and developed using the **Microservices architecture** pattern. It allows different services like user management, book inventory, borrowing system, and an API gateway to work independently but collaboratively to deliver a scalable, modular, and maintainable application.

---

## 🧾 Overview

The Library Management System enables users to:
- **Register and manage user accounts**
- **Browse, add, and remove books**
- **Borrow and return books**
- Seamlessly interact with services through an API Gateway

This system is suitable for schools, colleges, and public libraries, allowing multiple services to scale independently based on demand.

---

## 🏗️ Architecture

The application is split into multiple microservices, each responsible for a specific functionality:

| Service             | Description                                                                 |
|---------------------|-----------------------------------------------------------------------------|
| 📘 `User-Service`   | Handles user registration, login, and user data                             |
| 📚 `Book-Service`   | Manages books: add, update, delete, search                                  |
| 🔁 `Library-Service`| Controls the borrowing and return of books                                  |
| 🌐 `API Gateway`    | Acts as a single-entry point for all client requests                        |
| 🛰️ `Service Registry (Eureka)` | Handles service discovery and load balancing between microservices |

Each service runs independently and communicates via **REST APIs**, allowing flexible scaling and modular updates.

---

## 🛠️ Tech Stack

- **Java 17**
- **Spring Boot 3.4**
- **Spring Cloud Netflix Eureka (Service Registry)**
- **Spring Web / REST APIs**
- **Spring Boot Actuator (for monitoring)**
- **Maven (Build Tool)**
- **IntelliJ IDEA / VS Code**
- **Git & GitHub (Version Control)**

---

## 🚀 How to Run the Project

### Prerequisites
- Java 17+
- Maven 3.8+
- Git

### Step-by-Step
```bash
# Clone the repository
git clone https://github.com/your-username/MicroServices.git
cd MicroServices

# Run the service registry first
cd service-registry
mvn spring-boot:run

# Then start each service in separate terminals
cd ../User-Service
mvn spring-boot:run

cd ../Book-Service
mvn spring-boot:run

cd ../Library-Service
mvn spring-boot:run

cd ../APIGateway
mvn spring-boot:run
🧠 Why Microservices?
✨ Scalability: Each service can scale independently

🛠️ Maintainability: Bugs and updates are isolated to specific services

🔒 Resilience: One failing service won’t crash the entire system

🔄 Continuous Deployment Friendly

📌 Future Improvements
Add JWT-based Authentication

Integrate MongoDB or PostgreSQL for persistent storage

Dockerize each service

Add Swagger UI for API documentation

Implement CI/CD using GitHub Actions

🤝 Contributing
Want to contribute or raise issues? Feel free to fork this repo and raise a pull request or create an issue. Contributions are welcome!

📄 License
This project is for educational and demonstration purposes only.
