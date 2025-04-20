
# E-Commerce Backend Application

This is a Java Spring Boot backend application for an e-commerce platform, designed to handle core e-commerce functionalities such as product management, user authentication, order processing, and payment integration. The application uses PostgreSQL as the database and is containerized with Docker for easy deployment and scalability.

## Table of Contents
- [Features](#features)
- [Technologies](#technologies)
- [Prerequisites](#prerequisites)
- [Setup and Installation](#setup-and-installation)
  - [Using Docker](#using-docker)
  - [Manual Setup](#manual-setup)
- [Configuration](#configuration)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Database Schema](#database-schema)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)

## Features
- **User Management**: Register, login, and manage user profiles with JWT-based authentication.
- **Product Management**: Create, update, delete, and retrieve products with category support.
- **Order Processing**: Create and manage orders, including order history and status tracking.
- **Payment Integration**: Support for payment processing (e.g., Stripe integration, if applicable).
- **RESTful API**: Well-documented endpoints for frontend integration.
- **Dockerized Deployment**: Containerized application and database for consistent environments.
- **PostgreSQL Database**: Robust relational database for storing e-commerce data.

## Technologies
- **Java**: 17
- **Spring Boot**: 3.x
- **Spring Data JPA**: For database operations
- **Spring Security**: For authentication and authorization
- **PostgreSQL**: 16.x
- **Docker**: For containerization
- **Maven**: For dependency management
- **JWT**: For secure authentication
- **Lombok**: To reduce boilerplate code
- **Swagger/OpenAPI**: For API documentation (if integrated)

## Prerequisites
- **Java 17** or higher
- **Docker** and **Docker Compose** installed
- **Maven** (if running without Docker)
- **PostgreSQL** (if running without Docker)
- A code editor like IntelliJ IDEA or VS Code

## Setup and Installation

### Using Docker
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/LeandroMileski/ecommerce.git
   cd ecommerce
   ```

2. **Configure Environment Variables**:
   Create a `.env` file in the project root with the following content:
   ```env
   POSTGRES_DB   POSTGRES_USER=your_postgres_user
   POSTGRES_PASSWORD=your_postgres_password
   POSTGRES_DB=ecommerce_db
   SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/ecommerce_db
   SPRING_DATASOURCE_USERNAME=your_postgres_user
   SPRING_DATASOURCE_PASSWORD=your_postgres_password
   JWT_SECRET=your_jwt_secret_key
   ```

3. **Build and Run with Docker Compose**:
   ```bash
   docker-compose up --build
   ```
   This will start the PostgreSQL database and the Spring Boot application.

### Manual Setup
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/LeandroMileski/ecommerce.git
   cd ecommerce
   ```

2. **Install PostgreSQL**:
   - Install PostgreSQL locally or use a cloud provider.
   - Create a database named `ecommerce_db`.

3. **Configure Application Properties**:
   Update `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/ecommerce_db
   spring.datasource.username=your_postgres_user
   spring.datasource.password=your_postgres_password
   spring.jpa.hibernate.ddl-auto=update
   jwt.secret=your_jwt_secret_key
   ```

4. **Build the Application**:
   ```bash
   mvn clean install
   ```

## Configuration
- **Database**: The application uses PostgreSQL with JPA for ORM. The schema is automatically created/updated on startup (`spring.jpa.hibernate.ddl-auto=update`).
- **Security**: JWT is used for authentication. Configure the `jwt.secret` in the `.env` or `application.properties` file.
- **Logging**: Configured to log to console and file (optional, configure in `application.properties`).

## Running the Application
- **With Docker**:
  ```bash
  docker-compose up
  ```
  The application will be available at `http://localhost:8080`.

- **Without Docker**:
  ```bash
  mvn spring-boot:run
  ```
  The application will be available at `http://localhost:8080`.

## API Endpoints
The API is RESTful and supports the following key endpoints (example, adjust based on actual implementation):
- **Users**:
  - `POST /api/auth/register` - Register a new user
  - `POST /api/auth/login` - Login and receive JWT
  - `GET /api/users/{id}` - Get user details (authenticated)
- **Products**:
  - `GET /api/products` - List all products
  - `POST /api/products` - Create a product (admin)
  - `PUT /api/products/{id}` - Update a product (admin)
  - `DELETE /api/products/{id}` - Delete a product (admin)
- **Orders**:
  - `POST /api/orders` - Create an order (authenticated)
  - `GET /api/orders/{id}` - Get order details (authenticated)
- **Categories**:
  - `GET /api/categories` - List all categories
  - `POST /api/categories` - Create a category (admin)

Use Swagger (if integrated) at `http://localhost:8080/swagger-ui.html` for detailed API documentation.

## Database Schema
The database includes the following main tables (simplified):
- **users**: Stores user information (id, username, email, password, role).
- **products**: Stores product details (id, name, description, price, category_id).
- **categories**: Stores product categories (id, name).
- **orders**: Stores order information (id, user_id, total, status).
- **order_items**: Stores order item details (id, order_id, product_id, quantity).

Relationships:
- One user can have many orders.
- One product belongs to one category.
- One order can have many order items.

## Testing
- **Unit Tests**: Use JUnit and Mockito for unit testing service and controller layers.
- **Integration Tests**: Use TestRestTemplate or MockMvc for API testing.
- Run tests:
  ```bash
  mvn test
  ```

## Contributing
1. Fork the repository.
2. Create a feature branch (`git checkout -b feature/your-feature`).
3. Commit your changes (`git commit -m 'Add your feature'`).
4. Push to the branch (`git push origin feature/your-feature`).
5. Open a Pull Request.

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
