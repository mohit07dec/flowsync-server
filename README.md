# FlowSync Server

## Overview
- RESTful API for client-server communication
- User authentication and authorization
- Database integration with JPA and Hibernate

## Requirements
- Java 11 or higher
- Maven 3.6.0 or higher
- A database (e.g., MySQL, PostgreSQL)

## Getting Started

### Installation
1. **Clone the repository:**
   ```bash
   git clone https://github.com/yourusername/flowsync-server.git
   cd flowsync-server
   ```

2. **Build the project:**
   ```bash
   mvn clean install
   ```

3. **Configure the database:**
   Update the `application.properties` file in the `src/main/resources` directory with your database details.

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/yourdbname
   spring.datasource.username=yourusername
   spring.datasource.password=yourpassword
   ```

4. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```


## Development

### Testing
Tests are written using JUnit and can be run with the following command:
```bash
mvn test
```

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
