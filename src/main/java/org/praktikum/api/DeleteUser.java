package org.praktikum.api;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DeleteUser {
    public Response deleteUser(String token) {
        return given()
                .header("Authorization", token)
                .baseUri("https://stellarburgers.nomoreparties.site")
                .delete("/api/auth/user");
    }
}
