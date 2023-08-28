package org.praktikum.api;

import io.restassured.response.Response;
import org.praktikum.BaseUrl;

import static io.restassured.RestAssured.given;

public class DeleteUser extends BaseUrl {
    public Response deleteUser(String token) {
        return given()
                .header("Authorization", token)
                .baseUri(baseUrl)
                .delete("/api/auth/user");
    }
}
