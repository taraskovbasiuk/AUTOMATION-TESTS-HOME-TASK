package org.example;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class checkUser {
    public static void main(String[] args) {
       RestAssured.baseURI = "https://petstore.swagger.io/v2";

        // Send a POST request to create the user
        given()

                .when()
                .get("/user/TKTESTUSER35")

                .then()
                .statusCode(200)
                .body("id", equalTo(9999))
                .body("username", equalTo("TKTESTUSER35"))
                .body("firstName", equalTo("Test"))
                .body("lastName", equalTo("User"))
                .body("email", equalTo("testuser@example.com"))
                .body("password",equalTo("123456789"))
                .body("phone", equalTo("063451303030"))
                .body("userStatus", equalTo(0));
    }
}