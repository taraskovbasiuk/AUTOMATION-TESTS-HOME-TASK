package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UpdNameStatus {

    public static void main(String[] args) {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        String updPetImg = "{\"id\":1001,\n" +
                "\"category\":{\n" +
                "\"id\":1,\n" +
                "\"name\":\"Cats\"\n" +
                "},\n" +
                "\"name\":\"Kitty\",\n" + //updated name
                "\"photoUrls\":[" +
                "\"https://cutt.ly/xwTeb4fe\"\n" +
                "],\n" +
                "\"tags\":[\n" +
                "{\n" +
                "\"id\":1,\n" +
                "\"name\":\"wild\"\n" +
                "}\n" +
                "],\n" +
                "\"status\":\"reserved\"\n" + //updated Status
                "}";


        given()
                .contentType(ContentType.JSON)
                .body(updPetImg)
                .when()
                .put("/pet")

                .then()
                .statusCode(200)
                .body("name", equalTo("Kitty"))
                .body("status", equalTo("reserved")); /*check one more time put apdates all params??*/
    }
}
