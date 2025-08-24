package br.com.desafio_tecnico_accenture.service.bookstore;

import br.com.desafio_tecnico_accenture.util.BasicAuthUtil;
import br.com.desafio_tecnico_accenture.util.EnvConfig;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class GetUserDetailsService {
    public Response exec(String userId){
        return given()
                .baseUri(EnvConfig.baseUrl())
                .header("accept","application/json")
                .header("authorization", BasicAuthUtil.header())
                .when()
                .get("/Account/v1/User/" + userId);
    }
}