# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.6.6/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.6.6/maven-plugin/reference/html/#build-image)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.6.6/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.6.6/reference/htmlsingle/#boot-features-developing-web-applications)

### Guides

The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

### About Project
* Client:      Fleet Studio
* Name:        County Suggestions
* Technology:  Java 8, Spring boot, Hibernate/JPA, H2

This API endpoint would be used for type-ahead suggestions for US counties. It should be able to return a set of 
matching counties based on a user provided fragment of a county name and/or state.

# Project tree
Only important files
* [openapi](./openapi.iml)
  - [src](./src)
      * [main](./src/main)
        * [java](./src/main/java)
          * [com.jsd.openapi](./src/main/java/com)
            * [advice](./src/main/java/com/jsd/openapi/advice)
              * [CountyExceptionHandler.java](./src/main/java/com/jsd/openapi/advice/CountyExceptionHandler.java) 
              Summary: This file is intended for data validation during insertion in to the database by the client server.
            * [controller](./src/main/java/com/jsd/openapi/controller)
              * [CountyController.java](./src/main/java/com/jsd/openapi/controller/CountyController.java)
                Summary: The CountyController.java handle the all request(s) from the client server and interact with the service layer and grab the information(s) from service layer and delivered to the client server.
            * [exception](./src/main/java/com/jsd/openapi/exception)
              * [ResultNotFoundException.java](./src/main/java/com/jsd/openapi/exception/ResultNotFoundException.java)
                Summary: This file is a custom exception and supportive file of <b><u>CountyExceptionHandler.java</u></b> and is intended for when clients request grab nothing results from the database.
            * [model](./src/main/java/com/jsd/openapi/model)
              * [County.java](./src/main/java/com/jsd/openapi/model/County.java)
                Summary: The County.java, consist table name, and their properties like fips, name, ... .
            * [repository](./src/main/java/com/jsd/openapi/repository)
              * [CountyRepository.java](./src/main/java/com/jsd/openapi/repository/CountyRepository.java)
                Summary: The CountyRepository.java is responsible to interact with the database and manipulation the data into the database and is also responsible for grab the information form database and sends to the service layer. In other word the CountyRepository.java is a mediator between service layer and the database.
            * [service](./src/main/java/com/jsd/openapi/service)
              * [CountyService.java](./src/main/java/com/jsd/openapi/service/CountyService.java)
                Summary: In this java file, written all the business logic and is responsible for interact with the DAO Layer(Data Access Layer) and collect the data from DAO layer and sends to the controller.
        * [test](./src/test)
          * [java](./src/test/java)
            * [com.jsd.openapi](./src/test/java/com)
              * [CountyServiceTest.java](./src/test/java/com/jsd/openapi/CountyServiceTest.java)
                Summary: All business logics test(s) written in this file.
              * [OpenapiApplicationTests.java](./src/test/java/com/jsd/openapi/OpenapiApplicationTests.java)
                Summary: database manipulation test(s) written in this file.

        * [resources](./src/main/resources)
          * [data](./src/main/resources/data)
            * [data.json](./src/main/resources/data/data.json)
              Summary: This is a simple data sample which is provided by the fleet studio.
          * [application.yml](./src/main/resources/application.yml)
            Summary: The application.yml file consist the all information related to the configuration related to the machine like server port, application name, dialect, ... .
          * [banner.txt](./src/main/resources/banner.txt)
  - [pom.xml](./pom.xml)
    Summary: This file consist all dependencies/external-libraries information.
    

### Setup and system requirement
* [OS](): Linux/Windows based server/computer
* [Java 8 JDK](https://www.oracle.com/in/java/technologies/javase/javase8-archive-downloads.html):
   Install the JDK 8 on your machine.
* [Maven](https://maven.apache.org/download.cgi):
   Install the maven on your machine
  
* On your local machine:
  * [Download project source code zip](https://github.com/JitendraSoftDev/county-suggenstions)
  * [Open CMD](): 
    * On Windows machine - Windows key + R and write cmd.exe and press enter. 
    * On Linux machine - open terminal
  * [Change the directory to the project folder](): cd "your path/county-suggestions" and press enter.
  * [Create target file](): mvn install and press enter. After completion, a directory will exist target and openapi-3.0.0.jar
  * [Run the jar file on your local machine](): java -jar openapi-3.0.0.jar and press enter and minimize your cmd.exe/terminal
  * [Open your browser OR Postman](): 
    * http://localhost:3000/cowlitz, wa
    * http://localhost:3000/cowl
    * http://localhost:3000/wa
  
  * [Add more data into database]():
    * [Open postman]():
      * select POST url - http://localhost:3000/suggest/save
      * select body tab > raw > choose Json
        -
         [
         
            {
              "fips": 10052,
              "name": "Name",
              "state": "State"
            },
            {
              "fips": 10053,
              "name": "Name2",
              "state": "State2"
            }
            
          ]
          
  ####  Also see on Heroku server
This is only for testing Or learning purpose. Please don't miss-use this resource.
   - https://jsdopenapi.herokuapp.com/suggest/cowlitz,%20wa
   - https://jsdopenapi.herokuapp.com/suggest/cowl
   - https://jsdopenapi.herokuapp.com/suggest/wa




      
  
    
