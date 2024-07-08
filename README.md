
# SIMPlex - Back-End

SIMplex: A streamlined and intuitive SIM activation portal. Built with React and TypeScript for frontend, and Spring Boot for backend, leveraging REST APIs and Microservices architecture. Simplifying SIM card activation with ease and efficiency.

### Front Repository Link 🔗
[![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white)](#)
[GitHub - SIMplex frontend](https://github.com/i-haq786/SIMplex-backend.git)

## Installation

Follow these steps to get the SIMplex backend up and running on your local machine:

### Prerequisites

- Java Development Kit (JDK 11 or higher)
- Java 17
- Maven (v3.x or higher)
- PostgreSQL (for database)

### Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/i-haq786/SIMplex-backend.git
   cd SimPortal-Backend
   ```

2. Open IntelliJ or any IDE 
3. Install the JDK if you haven't already.
4. If the microservices are not appearing as modules, follow this documentation: 
    
    [IntelliJ - Documentation](https://www.jetbrains.com/help/idea/creating-and-managing-modules.html)
    
5. Go to application.properties of both the services and update your database username/password. Also check the port number.

    ```
    spring.datasource.url=jdbc:postgresql://localhost:5433/db_2
    spring.datasource.username=postgres
    spring.datasource.password=root
    spring.datasource.driver-class-name=org.postgresql.Driver
    ```

6. Either change name or create a database in PGADMIN 4 with the same name as in 
    ```
    application.properties
    ```
7. If not already set or you wish to customize-
Set the port number for customer-service as:
    
    server.port=1002
    

Set the port number for sim-service as:

    server.port=1001
    
8. Start the Sim-service.
6. Then start the Customer-Service.

   
   

## Features

- 🚀 **Microservices Architecture**: Modular backend services for scalability.
- 🌐 **REST APIs**: Interface for communication with frontend and other services.
- 🛠️ **Spring Boot**: Java-based framework for enterprise-level applications.
- 🗄️ **PostgreSQL**: Database management system for data storage.

## Technologies Used

[![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)](#)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-336791?style=for-the-badge&logo=postgresql&logoColor=white)](#)

## API Reference

| API Endpoint                                                                                      | Method |
|---------------------------------------------------------------------------------------------------|--------|
| `http://localhost:1002/api/Customer`                                                              | GET    |
| `http://localhost:1001/api/simDetails/validateSim/serviceNumber/${serviceNumber}/simNumber/${simNumber}` | GET    |
| `http://localhost:1002/api/Customer/us04`                                                         | POST   |
| `http://localhost:1002/api/Customer/verify`                                                       | POST   |

This table lists the API endpoints along with their respective HTTP methods, making it easier to understand the endpoints available in this project. 

## Testing

- ✔️ **JUnit Testing**: Unit testing framework for Java.

### Notes:

- Customize the sections (Installation, Features, Technologies Used, etc.) as per your project's specifics.
- Include links to relevant documentation or resources where necessary.

## Feedback

If you have any feedback, please reach out to me at:

[![gmail](https://img.shields.io/badge/gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white)](mailto:your-email@gmail.com)

---

