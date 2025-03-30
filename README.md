# Quiz App - Backend (Microservices Architecture)

## Project Overview
This project is a Quiz Application backend built using Spring Boot and follows a microservices architecture. The backend consists of four main services:

1. **Question Service** - Handles question creation, retrieval, and user score calculation.
2. **Quiz Service** - Manages quiz creation, retrieval, and scoring.
3. **API Gateway** - Acts as a single entry point for all client requests.
4. **Service Registry** - Handles service discovery and registration.

## Folder Structure
```
Quiz_App-Backend-Using-Spring-Micro-Services/
│── question_service/
│── quiz_service/
│── api-gateway/
│── service-registry/
│── README.md
```

## Description

### 1. Question Service
- Provides functionality to create questions based on category and number of questions.
- Returns question IDs upon creation.
- Retrieves questions based on question IDs.
- Computes and returns the user’s score based on responses received via a wrapper class.

### 2. Quiz Service
- Allows creating a quiz with a set of questions.
- Retrieves quiz details based on quiz ID.
- Calculates and returns the quiz score.

### 3. API Gateway
- Acts as the entry point to the application.
- Routes incoming requests to the appropriate microservice.
- Handles authentication, logging, and load balancing.

### 4. Service Registry
- Implements service discovery using **Edureka client/server**.
- Registers all microservices dynamically.
- Helps in load balancing and failure recovery.
- Ensures seamless inter-service communication.

## Tech Stack
- **Spring Boot** (for building microservices)
- **Edureka Client/Server** (for service registry and discovery)
- **Feign** (for inter-service communication)
- **API Gateway** (for routing and security)
- **Java**

## Installation & Setup

```sh
# Clone the repository
git clone https://github.com/Sreenu031/Quiz_App-Backend-Using-Spring-Micro-Services.git

# Navigate to the project directory
cd Quiz_App-Backend-Using-Spring-Micro-Services

# Start the services in the following order:
# Run service-registry
cd service-registry
mvn spring-boot:run

# Run question-service
cd ../question-service
mvn spring-boot:run

# Run quiz-service
cd ../quiz-service
mvn spring-boot:run

# Run api-gateway
cd ../api-gateway
mvn spring-boot:run
```

## API Endpoints
You can test the APIs using Postman or any REST client.

Example to retrieve quiz questions based on ID:
```sh
GET http://localhost:8765/quiz-service/quiz/get/1
```

## Contributing
Feel free to fork the repository and submit pull requests for any improvements or bug fixes.



