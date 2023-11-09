package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CreatingListOfUsers {

    public static void main(String[] args) {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        String UserList = "[\n" +
        "  {\n" +
                "    \"id\": 1,\n" +
                "    \"username\": \"testuser1\",\n" +
                "    \"firstName\": \"Test\",\n" +
                "    \"lastName\": \"User1\",\n" +
                "    \"email\": \"testuser1@example.com\",\n" +
                "    \"password\": \"testpassword\",\n" +
                "    \"phone\": \"1234567890\",\n" +
                "    \"userStatus\": 0\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 2,\n" +
                "    \"username\": \"testuser2\",\n" +
                "    \"firstName\": \"Test\",\n" +
                "    \"lastName\": \"User2\",\n" +
                "    \"email\": \"testuser2@example.com\",\n" +
                "    \"password\": \"testpassword\",\n" +
                "    \"phone\": \"1234567890\",\n" +
                "    \"userStatus\": 0\n" +
                "  }\n" +
                "]";

        // Send a POST request to create the user
        given()
                .contentType(ContentType.JSON)
                .body(UserList)

                .when()
                .post("/user/createWithList")

                .then()
                .statusCode(200)
                .body("message", equalTo("ok"));

    }
}
