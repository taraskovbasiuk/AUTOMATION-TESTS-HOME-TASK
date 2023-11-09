package org.example;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;


class CreateUser{
    public static void main(String[] args) {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        String userData = "{\n" +
                "  \"id\": 9999,\n" +
                "  \"username\": \"TKTESTUSER36\",\n" +
                "  \"firstName\": \"Test\",\n" +
                "  \"lastName\": \"User\",\n" +
                "  \"email\": \"testuser@example.com\",\n" +
                "  \"password\": \"2345\",\n" +
                "  \"phone\": \"063451303030\",\n" +
                "  \"userStatus\": 0\n" +
                "}";

        // Send a POST request to create the user
        given()
                .contentType(ContentType.JSON)
                .body(userData)

                .when()
                .post("/user")

                .then()
                .statusCode(200);

    }
}