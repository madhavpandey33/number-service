# number-service
number service is developed in Spring boot application which enables one to perform multiple numerical operation through a thymeleaf app.

# Table of contents
* [Supported Feature](#supported-feature)
* [Technologies Used](#technologies-used)
* [Methodology Used](#methodology-used)
* [Test Coverage Specification](#test-coverage-specification)
* [Packaging Layout](#packaging-layout)
* [Pre-requisites](#pre-requisites)
* [Build Deploy](#build-deploy)
* [References](#references)


## Supported Feature
- Integer to Roman numeral conversion, allowed limit 1 - 3999

## Technologies Used:
* Java 
* Spring Boot
* Maven
* Thymeleaf
* JUnit
* Logstash-Logback
* Jococo
* Swagger
* Promethus
* Docker


## Methodology Used
### Engineering Methodology:
This project is built around an idea of incremental-linear development wherein the entire project was divided into small chunks which facilitates  easy development with a clear target to acheive. This approach also helps in future advancement or any change requirement along the way.

Following are the steps taken to develop this project:
* Used [`Spring Initializr`](https://start.spring.io/) to create a base project with least possible dependency for the service to run
* Activated actuators to enable easy monitoring and interaction for this service
* Wrote controller class with appropriate endpoint
* Added service layer to handle the business logic and connected it with controller to have an end to end functionality working
* Integrated Swagger plugin for easy API documentation
* Developed Thymeleaf app and itegrated with exisiting service
* Integrated Jococo coverage checks for this project

### Testing Methodology:

This project tried to follow `TDD - Test Driven Development` approach wherein the tests are written first. These tests are then run to validate the test harness working and it also confirms the need to add new code to support the tests.

After writing the new code, the tests are again run against the new code to validate if it meets the business logic. If it doesn't,then code is refactored and tests are ran again. And the cycle continue untill all the test pass.

## Test Coverage Specification

* Coverage check type: Instruction
* Coverage check treshold: 95%

## Packaging Layout

Below is the layout for this project:
```
/number-service/
├── src
│   └── main/java/com/adobe/numberservice
│       └── NumberServiceApplication.java
│       └── config
│           └── SwaggerConfig.java
│       └── controller                               (Holds all the controller classses)
│           └── NumberServiceController.java
│       └── exception                                (Holds all the custom exception classses)
│           └── CustomNumberToRomanException.java
│           └── EmptyInputException.java
│           └── OutOfRomanLimitException.java
│       └── serv
│           └── RomanService.java
│           └── impl
│               └── RomanServiceImpl.java
│       └── utils
│           └── Constants.java                       (Holds all the constants used in the project)
│   └── test/java/com/adobe/numberservice            (Holds all the tests)
│       └── NumberServiceApplicationTests.java
│       └── controller
│           └── NumberServiceApplicationWebLayerTests.java
│           └── NumberServiceController_UT.java
│       └── serv
│           └── RomanService_UT.java
│   └── resources
│        └── static
│            └── css
│                └── style.css  
│            └── images
│                └── bg-01.svg
│                └── icon-01.svg
│                └── loader.gif
│            └── scripts
│                └── script.js
│       └── templates
│           └── error.html
│           └── index.html
│       └── application.properties
│       └── logback-spring.xml
├── .gitignore
├── Dockerfile
└── pom.xml
```

## Pre-requisites:
* Java v1.8
* Docker should be installed in case of docker deployment

## Build Deploy

### Running Locally:
* Clone this project using below command
<pre>git clone https://github.com/madhavpandey33/number-service.git</pre>
* Import project in eclipse or any other editor, go to the  class `NumberServiceApplication.java` and run as java application

Server status can be verified from the console logs.

Sever should start on default port - `8081`. 
Management endpoint will be available at `8082`

Note: You can always change the port in `application.properties`. 

### Running on Docker:
* From your project directory run <pre> mvn clean install </pre>
* Build docker image by running command <pre> docker build -t "number-service:1.0" . </pre>
* Run docker container by executing this command <pre> docker run -p 8080:8081 -p 8082:8082 --name number-service -d number-service:1.0  </pre>

Following are the available endpoints:
* Application basepath: `http://localhost:8080/v1/`

![alt text](/images/landing-page.png)

* Management endpoint: `http://localhost:8082/actuator`

```
{
  "_links": {
    "self": {
      "href": "http://localhost:8082/actuators",
      "templated": false
    },
    "health-component": {
      "href": "http://localhost:8082/actuators/health/{component}",
      "templated": true
    },
    "health-component-instance": {
      "href": "http://localhost:8082/actuators/health/{component}/{instance}",
      "templated": true
    },
    "health": {
      "href": "http://localhost:8082/actuators/health",
      "templated": false
    },
    "env": {
      "href": "http://localhost:8082/actuators/env",
      "templated": false
    },
    "env-toMatch": {
      "href": "http://localhost:8082/actuators/env/{toMatch}",
      "templated": true
    },
    "info": {
      "href": "http://localhost:8082/actuators/info",
      "templated": false
    },
    "prometheus": {
      "href": "http://localhost:8082/actuators/prometheus",
      "templated": false
    },
    "metrics-requiredMetricName": {
      "href": "http://localhost:8082/actuators/metrics/{requiredMetricName}",
      "templated": true
    },
    "metrics": {
      "href": "http://localhost:8082/actuators/metrics",
      "templated": false
    }
  }
}
```
The `/health` endpoint allows the dev-ops check the health status of the application.
The `/prometheus` endpoint provides the dev-ops with system monitoring and alerting capabilities. Furthermore, it provides a multi-dimensional data model with time series data identified by metric name and key/value pairs.

Prometheus can be integrated with GRAFANA to provide real time querying feature on prometheus data. 


* Swagger documentation: `http://localhost:8080/swagger-ui.html`

![alt text](/images/swagger-landing-page.png) Click on the individual end points to explore more and test them.

## References
Follwing are the used references for this project:

* Documentation: [Roman Numberals](https://en.wikipedia.org/wiki/Roman_numerals), [TDD](https://en.wikipedia.org/wiki/Test-driven_development)
* Image: [Background Image](https://www.pexels.com/photo/lots-of-numbers-1314543/)
* Quote: [Fun fact quote](https://in.pinterest.com/pin/435934438906562711/)