

###EUREKA service discovery
- Add Eureka server dependency to the project
- Configure Eureka server in the application properties
- Create a Eureka server class with `@EnableEurekaServer`
- Register the API Gateway as a Eureka client by adding `@EnableEurekaClient` to the main application class
- Ensure that the API Gateway can discover other services registered with Eureka
- Test the service discovery by running multiple services and checking if the API Gateway can route requests to them
- Consider adding a fallback mechanism for services that are not available
- Document the Eureka server setup and how to register services with it
  - Ensure that the Eureka server is secured and only allows trusted services to register
  - Consider using a configuration server to manage Eureka server properties