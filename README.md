# PagesManager
Web application to upload images.
You only need to run the application, tables will be created by Spring and DataInitializer will add test data to the H2 database (user, roles, image categories).

Viewing images does not require authentication, uploading new pictures requires authentication.
- username - "user1"
- password "password"


The URLs:

- http://localhost:8080/images - All images;

- http://localhost:8080/images/add - add the new image;

- http://localhost:8080/images/2 - get the image by id=2;

Views were created with Thymeleaf.
Video how the application works: https://drive.google.com/file/d/1vQdg1E3-lV0pZne8E4V8I0bWx4u4Yxxw/view?usp=sharing

(Spring Boot, Spring Security Basic Authentication, Spring Data JPA, Spring MVC, Maven, H2, Thymeleaf, Lombock)
