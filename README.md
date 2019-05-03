# number-service
number service gives capabilities to perform multiple numerical operation over HTTP endpoint

## Pre-requisites:
* Java v1.8


## Running Locally:
* Clone this project
* Go to the  class `NumberServiceApplication.java` and run as java application

You should be able to verify the server status from the console logs. Sever should start on default port - `8080`. And management endpoint will be available at `8082`

* Application basepath: `http://localhost:8080/v1`
* Management endpoint: [`http://localhost:8082/actuator`](http://localhost:8082/actuator)
* Swagger documentation: [`http://localhost:8080/swagger-ui.html`](http://localhost:8080/swagger-ui.html)

Note: You can always change the port in `application.properties`. 