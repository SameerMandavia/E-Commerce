# E-Commerce Microservices Project

## Overview
This repository contains a modular, production-ready e-commerce backend built with Java 21 and Spring Boot 3.5.7, following a microservices architecture. Each service is independently deployable and scalable, with clear separation of concerns.

## Architecture
- **user-service**: Manages user registration, authentication, and profile data.
- **auth-service**: Handles authentication, JWT token issuance, and validation.
- **product-service**: Manages product catalog, inventory, and search.
- **order-service**: Handles order placement, tracking, and history.
- **gateway**: API gateway for routing, security, and aggregation.
- **config-server**: Centralized configuration management (planned).
- **common**: Shared code and DTOs (if needed).

![Architecture Diagram](docs/architecture.png) <!-- Add diagram if available -->

## Tech Stack
- **Java 21**, **Spring Boot 3.5.7**
- **Gradle 8.14** (multi-module)
- **JWT (jjwt)** for authentication
- **BCrypt** for password hashing
- **Docker Compose** for local orchestration
- **PostgreSQL** (planned for persistence)
- **Keycloak** (optional, for advanced auth)

## Getting Started
### Prerequisites
- Java 21+
- Gradle 8.14+
- Docker & Docker Compose

### Build & Run
```sh
# Build all services
./gradlew clean build

# Run locally (example for user-service)
cd services/user-service
./gradlew bootRun
```

### Docker Compose
```sh
docker-compose up
```
This will start Keycloak and PostgreSQL. You can add service containers as needed.

## Endpoints
### user-service
- `POST /api/users/register` — Register a new user
- `POST /api/users/authenticate` — Authenticate user credentials

### auth-service
- `POST /auth/login` — Authenticate and receive JWT token

### product-service, order-service, gateway
- Endpoints to be defined as implementation progresses

## Security
- JWT-based authentication (auth-service)
- Passwords hashed with BCrypt
- Planned: Resource server JWT validation, role-based access, Keycloak integration

## Development Guide
- Each service is a standalone Spring Boot app under `services/`
- Shared configs and Gradle wrapper included
- Use `.gitignore` to keep repo clean
- Unit tests included in each service

## CI/CD & Quality (Planned)
- GitHub Actions for build, test, code scan, Docker image publishing
- Code style and unit test checks

## Observability (Planned)
- Structured logging
- Metrics (Prometheus)
- Distributed tracing (OpenTelemetry)
- Health checks

## Contributing
1. Fork the repo and create a feature branch
2. Make changes and add tests
3. Submit a pull request

## License
Apache 2.0

## Maintainer
- Sameer Mandavia

---
For questions or support, open an issue or contact the maintainer.
