package org.example;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class NewPet {

    public static void main(String[] args) {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        String PetData = "{\"id\":1001,\n" +
                "\"category\":{\n" +
                "\"id\":1,\n" +
                "\"name\":\"Cats\"\n" +
                "},\n" +
                "\"name\":\"Spicy\",\n" +
                "\"photoUrls\":[" +
                "\"https://cutt.ly/owTqWTlM\"\n" +
                "],\n" +
                "\"tags\":[\n" +
                "{\n" +
                "\"id\":1,\n" +
                "\"name\":\"wild\"\n" +
                "}\n" +
                "],\n" +
                "\"status\":\"available\"\n" +
                "}";


            /*    "{\n" +
                "  \"id\": 1001,\n" +
                "  \"category\": {\n" +
                "  \"id\": 10,\n" +
                "  \"name\": \"Cats\",\n" +
                "  },\n" +
                "  \"name\": \"Spicy\",\n" +
                "  \"photoUrls\": [\n" +
                "  \"https://cutt.ly/owTqWTlM\"\n" +
                "  \"],\"\n" +
                "  \"tags\": [\n" +
                "  {\n" +
                "  \"id\": 1,\n" +
                 " \"name\": \"wild\",\n" +
                "  }\n" +
                "  ],\n" +
                "  \"status\": \"available\",\n" +
                "}";*/

        // Send a POST request to create the user
        given()
                .contentType(ContentType.JSON)
                .body(PetData)

                .when()
                .post("/pet")

                .then()
                .statusCode(200)
                .body("name", equalTo("Spicy"))
                .body("status", equalTo("available"))
                .body("category.name", equalTo("Cats"))
                .body("tags[0].name", equalTo("wild"));
    }
}
