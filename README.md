# Plant Care Tracker 🌿

Simple application for tracking plant care and room organization.

## 🚀 Deployment

The application is deployed on Render using Docker.

**Live Links:**
- 🌐 **API Root**: [https://plant-care-tracker-yng2.onrender.com/api/](https://plant-care-tracker-yng2.onrender.com/api/)
- 📖 **API Documentation (Swagger)**: [https://plant-care-tracker-yng2.onrender.com/swagger-ui/index.html](https://plant-care-tracker-yng2.onrender.com/swagger-ui/index.html)
- 🛢️ **H2 Database Console**: [https://plant-care-tracker-yng2.onrender.com/h2-console/login.jsp](https://plant-care-tracker-yng2.onrender.com/h2-console/login.jsp)

## 🛠 Local Setup

### Prerequisites
- Java 25+
- Maven

### Running with Maven
```bash
./mvnw spring-boot:run
```

### Running with Docker
1. Build the image:
   ```bash
   docker build -t plant-care-tracker .
   ```
2. Run the container:
   ```bash
   docker run -p 8080:8080 plant-care-tracker
   ```
