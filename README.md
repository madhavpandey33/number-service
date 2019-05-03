# number-service
number service gives capabilities to perform multiple numerical operation over HTTP endpoint

## Pre-requisites:
* Java v1.8
* Docker should be installed in case you want to use docker deployment


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