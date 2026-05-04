package base;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static io.restassured.RestAssured.given;

public class BaseTest {

    protected RequestSpecification request;

    /**
     * Sets up the base URI for RestAssured before all tests are run.
     */
    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    /**
     * Initializes the RequestSpecification before each test, setting the Content-Type header to application/json.
     * Also logs the current thread name for debugging purposes.
     */
    @BeforeEach
    void beforeEach() {
        request = given()
                .header("Content-Type", "application/json");

        System.out.println("Thread: " + Thread.currentThread().getName());
    }
}
