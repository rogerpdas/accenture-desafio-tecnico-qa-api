package br.com.desafio_tecnico_accenture.service.account;

import br.com.desafio_tecnico_accenture.util.EnvConfig;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class AuthorizeUserService {
    public Response exec(String token, String user, String pass){
        String body = String.format("{\"userName\":\"%s\",\"password\":\"%s\"}", user, pass);
        return given()
                .baseUri(EnvConfig.baseUrl())
                .header("accept","application/json")
                .header("Authorization", token)
                .header("Content-Type","application/json")
                .body(body)
                .when()
                .post("/Account/v1/Authorized");
    }
}
