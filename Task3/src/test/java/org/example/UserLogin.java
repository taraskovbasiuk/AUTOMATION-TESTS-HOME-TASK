package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UserLogin {
    public static void main(String[] args) {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        String UserName = "TKTESTUSER36";
        String Password = "2345";
        String UserNamePassKey = "/user/login?username=" + UserName + "&password=" + Password;
        System.out.println(UserNamePassKey);
        // Send a POST request to create the user
        given()

                .when()
                .get(UserNamePassKey)

                .then()
                .statusCode(200);
    }
}
