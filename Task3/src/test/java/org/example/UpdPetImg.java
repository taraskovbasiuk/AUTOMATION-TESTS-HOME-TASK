package org.example;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

import java.io.File;

public class UpdPetImg {

    public static void main(String[] args) {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        String updPetImg = "{\"id\":1001,\n" +
                "\"category\":{\n" +
                "\"id\":1,\n" +
                "\"name\":\"Cats\"\n" +
                "},\n" +
                "\"name\":\"Spicy\",\n" +
                "\"photoUrls\":[" +
                "\"https://cutt.ly/xwTeb4fe\"\n" + //updated img
                "],\n" +
                "\"tags\":[\n" +
                "{\n" +
                "\"id\":1,\n" +
                "\"name\":\"wild\"\n" +
                "}\n" +
                "],\n" +
                "\"status\":\"available\"\n" +
                "}";


        given()
                .contentType(ContentType.JSON)
                .body(updPetImg)
                .when()
                .put("/pet")

                .then()
                .statusCode(200)
                .body("photoUrls", hasItem("https://cutt.ly/xwTeb4fe"));//check one more time
    }
}
