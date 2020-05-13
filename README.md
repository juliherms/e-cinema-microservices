
# E-Cinema Application

Example of an application in Spring Boot and Netflix OSS using fundamentals of best practices microservice architecture.

### Tools

- Java SE Development Kit
- Spring Tools IDE
- Maven
- Docker

### Methodologies and Patterns

- DDD
- TDD
- Clean Code
- Solid

## Built with:

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Maven](https://maven.apache.org/)

## Microservices Architecture

### Requeriments

- The project follows [**CloudNative**](https://www.cncf.io/) recommendations and The [**twelve-factor app**](https://12factor.net/) . 


### Challenges in microservices architecture

- Configuration Management
- Dynamic Scalling Up and Down
- Load Distribution
- Visibility and Monitoring
- Common Feature Implementation
- Fault Tolerance

## Solution

### Microserices

| Microservices                   | Description  |
|---------------------------------|------------|
| Service Discovery               | [Eureka server](eureka-server) |
| API Gateway                     | [Zuul reverse proxy](zuul-gateway/src/main/java/com/donateplus/zuul/ZuulGatewayApplication.java) and [Routing configuration](donateplusapi/src/main/resources/application.properties) |
| Authorization-Service           | Responsible to allow access to microservices  |
| Ticket-Service                  | Responsible to provide access to ticket  |
| Payment-Service                 | Responsible to process payments from ticket or products  |
| Product-Service                 | Responsible to provide products  |



## Hystrix

<img src="img/hystrixdashboad.png">


## Eureka

<img src="img/eureka.png">
