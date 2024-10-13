## Car Rental Booking Application

## Description
This is a full-stack application for booking car rentals. The project is designed with a **Java Spring Boot** backend and an **Angular** frontend, allowing users to search for cars based on various criteria, manage bookings, and handle authentication through both classic login and OAuth2 with Google. It also includes messaging features to notify users about bookings and cancellations.

## Features
1. **Car Catalog**
   - Display a list of available cars.
   - Show detailed information about each car, including type, price, and location.

2. **Search Functionality**
   - Search for cars by different criteria:
     - **Type** (e.g., sedan, SUV, minibus, etc.)
     - **Price** (price per day or total cost)
     - **Location** (cars available in specific areas)

3. **Interactive Map**
   - Display available cars on a map, making it easy for users to visually locate rental options.

4. **Booking Management**
   - Users can make **reservations** for available cars.
   - View booking details and history.

5. **Cancellation Management**
   - Users can **cancel reservations** if necessary.
   - View and manage past bookings and cancellations.

6. **Messaging System**
   - Notify users about reservations and cancellations through a messaging system.
   - Email notifications sent using **JavaMailSender** for key events (bookings and cancellations).

7. **User Authentication**
   - **Classic authentication** (username/password) for user login and account management.
   - **OAuth2 authentication** via **Google** for an easy and secure login experience.

8. **Security Features**
   - **Spring Security** integrated with **OAuth2** and **OpenID Connect**.
   - Secure login flows, both with traditional credentials and third-party OAuth2 providers.

## Tech Stack

### Backend
- **Java 17**
- **Spring Boot 3**
  - **Spring Data JPA**: For managing database interactions.
  - **Spring Security**: For handling user authentication and authorization.
  - **Spring Actuator**: For monitoring the health and metrics of the services.
  - **JavaMailSender**: For sending email notifications.
  - **Hibernate**: For ORM (Object Relational Mapping).
  - **Bean Validation**: 
    - **@Valid** and **@Validated** annotations for automatic validation of the data.
    - Custom validators for specific use cases.
- **PostgreSQL**: The database for managing users, cars, and bookings.

### Frontend
- **Angular 14**: A responsive front-end built with Angular for smooth client interactions.
- **TypeScript**: Core language used in the Angular frontend.
- **Google OAuth2**: For user authentication with Google accounts.
- **JavaScript & HTML/CSS**: For user interface design and functionality.

## Getting Started

### Clone the repository:

```bash
git clone https://github.com/thomascapgras/rentAcarRepo.git
cd rentAcarRepo
```
### Backend Setup :
Navigate to the backend directory.
Configure your PostgreSQL database connection in the application.properties file.
Start the Spring Boot application:
```bash
./mvnw spring-boot:run
```
