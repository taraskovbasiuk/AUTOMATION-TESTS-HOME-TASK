package org.example;
import io.restassured.RestAssured;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;

public class LogOutUser {
    public static void main(String[] args) {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        // Send a POST request to create the user
        given()

                .when()
                .get("user/logout")

                .then()
                .statusCode(200)
                .body("message", equalTo("ok"));
    }
}