package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DeletePet {

    public static void main(String[] args) {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        int petId = 1001;

        given()
                .contentType(ContentType.JSON)

                .when()
                //.delete("https://petstore.swagger.io/v2/pet/1001")
                .delete("/pet/" + petId)

                .then()
                .statusCode(200)
                .body("message", equalTo("1001"));

    }
}
