# 🌿 ShambaSmart Microservices Platform

**ShambaSmart** is a scalable microservices-based platform designed for smart agriculture solutions. The system enables farmers, suppliers, service providers, and administrators to interact through a modular, service-oriented architecture.

---

## 📌 Project Highlights

* 🔗 Microservices Architecture (Spring Boot, Spring Cloud)
* 📦 Modular and Extensible Design
* 🔧 Docker & Docker Compose for Containerized Deployment
* 🚀 API Gateway with Centralized Routing and Security
* 🚁 Service Discovery with Eureka
* 💳 Payment Integration with M-Pesa (Mobile Money)
* 📊 PostgreSQL for Persistent Data Storage
* 💡 Designed for Scalability, Maintainability, and Real-World Production Readiness

---

## 🧱 Microservices Overview

| Microservice             | Description                                |
| ------------------------ | ------------------------------------------ |
| **Farmer Service**       | Manage farmer profiles and data            |
| **Input Service**        | Manage agricultural inputs inventory       |
| **Extension Service**    | Provide agricultural extension services    |
| **Order Service**        | Handle orders for inputs and services      |
| **Payment Service**      | Manage payment transactions                |
| **Notification Service** | Send notifications to users                |
| **Auth Service**         | Manage authentication and authorization    |
| **API Gateway**          | Unified entry point and routing management |
| **Eureka Server**        | Service discovery and registration         |

---

## 🔧 Technology Stack

* **Java 17**
* **Spring Boot 3.x**
* **Spring Cloud 2023.x**
* **Spring Cloud Gateway**
* **Eureka Discovery Server**
* **PostgreSQL**
* **Docker & Docker Compose**
* **Kafka** *(Planned for asynchronous messaging)*

---

## 📂 Repository Structure

```bash
shambasmart-microservices/
│
├── eureka-server/         # Eureka Service Discovery
├── api-gateway/           # API Gateway
├── farmer-service/        # Farmer Management
├── input-service/         # Inputs Inventory
├── extension-service/     # Extension Services
├── order-service/         # Orders Handling
├── payment-service/       # Payment Management
├── notification-service/  # Notifications
├── auth-service/          # Authentication & Authorization
├── common/                # Shared Libraries & DTOs
├── docker-compose.yml     # Multi-container Orchestration
└── parent-pom.xml         # Centralized Maven Configuration
```

---

## 🚀 Getting Started

### Clone the Repository

```bash
git clone https://github.com/Sighmore/shambasmart-microservices.git
cd shambasmart-microservices
```

### Build the Entire Project

```bash
mvn clean install
```

### Run Individual Microservices

```bash
cd <service-folder>
mvn spring-boot:run
```

### Run the Complete System with Docker Compose

```bash
docker-compose up --build
```

---

## 🎯 Roadmap

* ✅ Core Microservices
* ✅ Service Discovery (Eureka)
* ✅ API Gateway
* ✅ Dockerized Deployment
* 🚧 Kafka Integration (Messaging)
* 🚧 Centralized Configuration Server
* 🚧 Full CI/CD Integration
* 🚧 Monitoring & Observability (Prometheus + Grafana)

---

## 🤝 Contribution Guidelines

We welcome contributions from the community. Please feel free to submit issues, feature requests, or pull requests.

---

## 📄 License

This project is open-source and available under the [MIT License](LICENSE).

---

> *Crafted with ❤️ for modern agriculture by **Simon Kuria**.*
