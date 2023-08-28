package org.praktikum.api;

import io.restassured.response.Response;
import org.praktikum.BaseUrl;

import static io.restassured.RestAssured.given;

public class AuthorizationUser extends BaseUrl {
    public String accessToken;

    public Response authorizationValidliUserData() {
        AuthorizationUserData json = new AuthorizationUserData("TestTestov@test.ru", "Qwerty");
        Response user = given()
                .header("Content-type", "application/json")
                .baseUri(baseUrl)
                .body(json)
                .post("/api/auth/login");
        accessToken = user.body().as(ResponseBodyRegAndLogin.class).getAccessToken();
        return user;
    }
}
