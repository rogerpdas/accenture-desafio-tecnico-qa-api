package br.com.desafio_tecnico_accenture.service.bookstore;

import br.com.desafio_tecnico_accenture.util.EnvConfig;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class ListBooksService {
    public Response exec(){
        return given()
                .baseUri(EnvConfig.baseUrl())
                .header("accept","application/json")
                .when()
                .get("/BookStore/v1/Books");
    }
}