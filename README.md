# Payment Service

The Payment Service is responsible for handling payment processing through various payment gateways, currently using Stripe with the potential to add support for other gateways like Razorpay in the future. It utilizes the Adapter Design Pattern to abstract payment gateway operations.

## API Endpoints

### POST /payment
- **Description**: Generates a payment link using the configured payment gateway.
- **Request Body**: Payment details required by the payment gateway (e.g., amount, currency).

## Project Structure

- `src/main/java/`
  - Contains the Java source code for the service.
  - Includes the `paymentgateway` folder with the `PaymentGateway` interface and its Stripe implementation.

- `src/main/resources/`
  - Contains configuration files such as `application.properties`.

## Dependencies

The project relies on the following dependencies:

- **Spring Boot Starter Data JPA**: For database interactions.
- **Spring Boot Starter Web**: For web functionalities.
- **Spring Boot DevTools**: For development-time tools.
- **MySQL Connector**: For MySQL database connectivity.
- **Spring Boot Configuration Processor**: For configuration properties.
- **Lombok**: For reducing boilerplate code.
- **Spring Boot Starter Test**: For testing purposes.
- **Stripe Java SDK**: For integrating with Stripe payment gateway.
- **Razorpay Java SDK** (Optional): For future support of Razorpay payment gateway.

## Configuration

The `application.properties` file includes configurations for database connections and payment gateway keys:

```properties
spring.application.name=PaymentService

spring.jpa.hibernate.ddl-auto=create
spring.datasource.url=jdbc:mysql://localhost:3306/PaymentService
spring.datasource.username=PaymentServiceUser
#spring.datasource.password=secret
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql=true

# Retrieve payment gateway keys from environment variables
#razorpay.key.id=${RAZORPAY_KEY_ID}
#razorpay.key.secret=${RAZORPAY_KEY_SECRET}
stripe.key.id=${STRIPE_KEY_ID}
```

## Additional Notes

- The Payment Service is designed to be stateless and scalable, suitable for high-traffic environments.
- Future enhancements may include support for additional payment gateways and expanded payment processing features.

## Related Services

- **[Product Service](https://github.com/AmanPr01/E-Commerce)**: Manages product information and operations.
- **[User Service](https://github.com/AmanPr01/UserService)**: Manages user authentication and authorization.
- **[Email Service](https://github.com/AmanPr01/EmailService)**: Handles asynchronous email notifications.
