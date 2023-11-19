# Seat Exam Assignment - Backend
This project is a web application created in Spring Boot which allow client to send
a request that will send a newsletter to a specified email address. This allows users in my frontend application https://github.com/FuuKowatty/Blog register their emails.

## Some of the endpoints

| Endpoint      | Method   | Request              | Response | Function                |
|---------------|----------|----------------------|---------|-------------------------|
| `/send-email` | `POST`   | JSON BODY(recipient) | STRING  | send email to recipient |
    


## Technologies

* Code: Java 17, Spring Boot 3, Thymeleaf, Java Mail Sender
* Other: Maven

## Solved Problems
During the development of this project I had to face of a bunch of problems. These are a few of them.

* Build code that is maximal encapsulated
* Validation requests with controller advice
* Send to recipient's email newsletter. 
* Stick to SOLID rules

## Pre requirements
1. Ensure that you have installed java onn your computer by
```shell
java --version
```
2. Ensure that you have installed docker onn your computer by
```shell
docker --version
```
3. Open docker service or docker-desktop
```shell
sudo service docker start 
```

## How to build the project on your own
1. Clone this repository
```shell
git clone https://github.com/FuuKowatty/blog-newsletter-backend.git
```
2. Go to the folder with cloned repository
3. Run the application
```shell
.\mvnw spring-boot:run
```

After these steps your application will open on localhost:8080.
