# sprouts-spring-rest-react-demo

## Prerequisites

 1.  Apache Maven [[Download](https://maven.apache.org/download.cgi)]
 2.  Java 8 [[Download](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)]
 3.  RestClient [[Postman](https://www.getpostman.com/apps)] or [[cURL]()]
 4.  MySQL [[Download]](https://www.mysql.com/downloads/)
 5.  Node.js and npm [[Download](https://nodejs.org/en/download/)]  

## Build

`mvn clean install`

## Run 
#### Application:

`mvn spring-boot:run`

#### Frontend Dev Server:

```
cd sprouts-frontend 
npm run start
```

## Database

Database is backed by MySQL v8.

#### Create database

```
mysql -uroot -p
create database onevill;
```

#### Flyway Migration Scripts

Create new Flyway migration scripts under `/src/main/resources/db/scripts` 

## Rest API Postman Collection

Postman collection for all REST APIs can be found in `/src/main/resources`  