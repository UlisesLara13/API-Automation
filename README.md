# 📘 REST API Test Automation - Users API

This project implements an automated testing framework for a public REST API using Rest Assured, JUnit 5, and parallel execution.

The API under test:
👉 https://jsonplaceholder.typicode.com/users

### Requirements

TC-1 Verify HTTP Status Code
Send a GET request to /users
Validate:
Status code is 200 OK

TC-2 Verify Response Header
Send a GET request to /users
Validate:
Content-Type header exists
Value is:
application/json; charset=utf-8

TC-3 Verify Response Body
Send a GET request to /users
Validate:
Response contains 10 users

### Bonus Tasks (CRUD Operations)
Create User (POST)
Endpoint: /users
Validate:
Status code 201
Response body contains sent data

Read User (GET)
Endpoint: /users?id=1
Validate:
Status code 200
User data is correct

Update User (PUT)
Endpoint: /users/1
Validate:
Status code 200
Updated fields are correct

Delete User (DELETE)
Endpoint: /users/1
Validate:
Status code 200

##🏗️ Project Structure

```
Automation-API/
├── src/
│   └── test/
│       ├── java/
│       │   ├── base/
│       │   │   └── BaseTest.java          # Common setup & configuration
│       │   └── tests/
│       │       └── UsersApiTest.java      # API test cases
│       └── resources/
│           └── junit-platform.properties  # Parallel execution config
├── pom.xml                                # Maven dependencies
└── README.md    
```

# HOW TO RUN:

mvn clean test

# 👨‍💻 Author

**Student:** Ulises Lara  
**Program:** EPAM Java Automation Specialization
**Project:** [Module 10] API Automatione 
**Date:** May 2026

