package br.com.desafio_tecnico_accenture.validation;

import io.restassured.response.Response;
import org.junit.Assert;


public class AccountValidation {
    public static void created(Response r){

        Assert.assertEquals("Esperado 201 na criação do usuário",201, r.statusCode());

        Assert.assertNotNull("userID não retornado", r.jsonPath().getString("userID"));
    }
    public static void authorized(Response r){
        Assert.assertEquals("Autorização deve retornar 200",200, r.statusCode());
    }
    public static void deleted204(Response r){
        Assert.assertEquals("Exclusão deve retornar 204",204, r.statusCode());
    }
}