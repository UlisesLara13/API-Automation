package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.hamcrest.Matchers.equalTo;

@Execution(ExecutionMode.CONCURRENT)
public class UsersApiTest extends BaseTest {

    /**
    Verifies that the GET /users endpoint returns a 200 status code.
     */
    @Test
    void verifyStatusCodeIs200() {

        request
                .when()
                .get("/users")
                .then()
                .log().status()
                .statusCode(200);
    }

    /**
     * Verifies that the GET /users endpoint returns the correct Content-Type header.
     */
    @Test
    void verifyContentTypeHeader() {

        request
                .when()
                .get("/users")
                .then()
                .log().headers()
                .header("Content-Type", equalTo("application/json; charset=utf-8"));
    }

    /**
     * Verifies that the GET /users endpoint returns a list of 10 users.
     */
    @Test
    void verifyUserCountIs10() {

        request
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .body("size()", equalTo(10));
    }

    /**
     * Verify the POST endpoint creates a new user and returns the correct response body.
     */
    @Test
    void createUser() {

        String body = """
        {
          "name": "Ulises",
          "username": "uli",
          "email": "uli@test.com"
        }
        """;

        request
                .log().body()
                .body(body)
                .when()
                .post("/users")
                .then()
                .log().body()
                .statusCode(201)
                .body("name", equalTo("Ulises"))
                .body("username", equalTo("uli"))
                .body("email", equalTo("uli@test.com"));
    }

    /**
     * Verify the GET /users endpoint returns the correct user details when queried by ID.
     */
    @Test
    void getUser() {

        request
                .queryParam("id", 1)
                .when()
                .get("/users")
                .then()
                .log().body()
                .statusCode(200)
                .body("[0].id", equalTo(1))
                .body("[0].name", equalTo("Leanne Graham"))
                .body("[0].username", equalTo("Bret"))
                .body("[0].email", equalTo("Sincere@april.biz"));
    }

    /**
     * Verify the PUT /users/{id} endpoint updates user details and returns the correct response body.
     */
    @Test
    void updateUser() {

        String body = """
        {
          "id": 1,
          "name": "Pedro",
          "username": "pedro123",
          "email": "pedro@test.com"
        }
        """;

        request
                .log().body()
                .body(body)
                .when()
                .put("/users/1")
                .then()
                .log().body()
                .statusCode(200)
                .body("name", equalTo("Pedro"))
                .body("username", equalTo("pedro123"))
                .body("email", equalTo("pedro@test.com"));
    }

    /**
     * Verify the DELETE /users/{id} endpoint deletes a user and returns a 200 status code.
     */
    @Test
    void deleteUser() {

        request
                .when()
                .delete("/users/1")
                .then()
                .log().body()
                .statusCode(200);
    }
}