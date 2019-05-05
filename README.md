# number-service
number service is developed in Spring boot application which gives capabilities to perform multiple numerical operation through an thymeleaf app.

# Table of contents
* [Supported Feature](#supported-feature)
* [Technologies Used](#technologies-used)
* [Methodology Used](#methodology-used)
* [Packaging Layout](#packaging-layout)
* [Pre-requisites](#pre-requisites)
* [Build Deploy](#build-deploy)
* [References](#references)


## Supported Feature
- Integer to Roman conversion, limit 1 - 3999

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
This project is built around an idea of incremental-linear development wherein the entire project was divided into small chunks which facilitates  easy development with clear a target to acheive. This approach also helps in future advancement or any change requirement along the way.

Following are the steps taken to develop this project:
* Used [`Spring Initializr`](https://start.spring.io/) to create a base project with least possible dependecy for the service to run
* Activated actuators to enable easy monitoring and interaction for this service
* Wrote controller class with appropriate endpoint
* Added service layer to handle to business logic and connected it with controller to have end to end functionality working
* Integrated Swagger plugin for easy API documentation
* Developed Thymeleaf app and itegrated with exisiting service
* Integrated Jococo coverage checks for this project

### Testing Methodology:

This project tried to follow `TDD - Test Driven Development` approach wherein the tests are written first. These tests are then ran to validate the test harness working and it also confirmed the need to adding new code to support the tests. 

After writting the new code, the tests are again ran against the new code to validate if it meets the business logic. If it doesn't meet the business logic then code the refactored and tests are ran again.


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
│           └── ErrorController.java
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

## Running Locally:
* Clone this project
* Go to the  class `NumberServiceApplication.java` and run as java application

You should be able to verify the server status from the console logs. Sever should start on default port - `8080`. And management endpoint will be available at `8082`

* Application basepath: `http://localhost:8080/v1`  e.g. http://localhost:8080/v1/roman_number/2
* Management endpoint: [`http://localhost:8082/actuator`](http://localhost:8082/actuator)
* Swagger documentation: [`http://localhost:8080/swagger-ui.html`](http://localhost:8080/swagger-ui.html)

Note: You can always change the port in `application.properties`. 

## Running on Docker:
* From your project directory run <pre> mvn clean install </pre>
* Build docker image by running command <pre> docker build -t "number-service:1.0" . </pre>
* Run docker container by executing this command <pre> docker run -p 8080:8081 -p 8082:8082 --name number-service -d number-service:1.0  </pre>

* Application basepath: `http://localhost:8080/v1/roman_number/{integerInput}` e.g. http://localhost:8080/v1/roman_number/2
* Management endpoint: [`http://localhost:8082/actuator`](http://localhost:8082/actuator)
* Swagger documentation: [`http://localhost:8080/swagger-ui.html`](http://localhost:8080/swagger-ui.html)