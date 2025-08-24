package br.com.desafio_tecnico_accenture.service.bookstore;

import br.com.desafio_tecnico_accenture.util.BasicAuthUtil;
import br.com.desafio_tecnico_accenture.util.EnvConfig;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class AddBooksUserService {

    public Response exec(String userId, String[] isbns){
        StringBuilder sb = new StringBuilder("{\"userId\":\""+userId+"\",\"collectionOfIsbns\":[");
        for(int i=0;i<isbns.length;i++){
            sb.append("{\"isbn\":\"").append(isbns[i]).append("\"}");
            if(i<isbns.length-1) sb.append(',');
        }
        sb.append("]}");

        return given()
                .baseUri(EnvConfig.baseUrl())
                .header("accept","application/json")
                .header("Content-Type","application/json")
                .header("Authorization", BasicAuthUtil.header())
                .body(sb.toString())
                .when()
                .post("/BookStore/v1/Books");
    }


}
