# :film_projector: Cinema shop :ticket:

`A simple web application that supports authentication, authorization and basic CRUD operations.`

---

### Features
- Signing in as a user;
- Viewing movies and available sessions;
- Adding tickets to the shopping cart;
- Completing an order.
- Also, you can sign in as an administrator and view, modify or delete any users, movie sessions, shopping carts and orders.

---

### Project structure

The Cinema shop application is based N-tier architecture. It has 3 layers:
1. Controllers, which handle the requests, call service methods and send the responses;
2. Services, which have all the business logic and call DAO methods;
3. DAO (Data Access Objects), which make CRUD operations with the database.

The Cinema shop project is based on Spring framework, so any Service or DAO classes are Spring beans, and all the Controller classes are Spring RestControllers.
Also, the application uses DTO projection and validation at communication with the client.

The user passwords are stored in database hashed with BCrypt algorithm. 

DAO layer classes use Hibernate framework make CRUD operations by mapping entities with ORM.

**Here is a scheme of project entity relations:**

![pic](Cinema_Uml.png)

---

### Developed with:

- Java 11
- Spring Core, MVC, Security v5
- Hibernate v5
- MySQL v8
- Apache Tomcat v9

---
### How to run this project locally

1. Clone this repository
2. Create a MySQL scheme locally
3. Set your scheme url, username, password and driver in src/main/resources/db.properties
4. Set up a Tomcat local server configuration
5. Run the application with Tomcat

The app has no actual UI, so you can use this API to test it out:

`POST /register` - register a user with a USER role. DTO fields:
String email,
String password,
String repeatPassword.
Returns the same user, but with no password and with generated id from database.
get all cinema halls.

`POST /cinema-halls` - create a cinema hall. DTO fields:
int capacity,
String description. Returns the same cinema hall with generated id from database.
Requires ADMIN role.

`GET /cinema-halls` - get all cinema halls. Requires USER or ADMIN role.

`POST /movies` - create a movie. DTO fields:
String title,
String description. Returns the same movie with generated id from database.
Requires ADMIN role.

`GET /movies` - get all movies. get all cinema halls. Requires USER or ADMIN role.

`GET /movie-sessions/available?movieId&date` - get all movie sessions for movie by id that 
will be on certain day. Requires USER or ADMIN role.

`POST /movie-sessions` - create a movie session. DTO fields:
Long movieId,
Long cinemaHallId,
LocalDateTime showTime.
showTime can be passed as a string in following format: "yyyy-MM-ddTHH:mm:ss.SSS".
Requires ADMIN role.

`PUT /movie-sessions/{id}` - update a movie session by id from path variable.
DTO fields are the same as for POST request. Requires ADMIN role.

`DELETE /movie-sessions/{id}` - delete a movie session by id from path variable.
DTO fields are the same as for POST request. Requires ADMIN role.

`GET /shopping-carts/by-user` - get an authenticated user's shopping cart. Requires USER role.

`PUT /shopping-carts/movie-sessions?movieSessionId` - put a ticket for a movie session by id to 
authenticated user's shopping cart. Requires USER role.

`GET /orders` - get order history for certain authenticated user. Requires USER role.

`POST /orders/complete` - complete an order from authenticated user's shopping cart.
Requires USER role.

`GET /users/by-email?email` - get a user by email. Requires ADMIN role.
