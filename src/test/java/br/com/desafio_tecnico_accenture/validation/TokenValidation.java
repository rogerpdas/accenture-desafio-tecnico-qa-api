package br.com.desafio_tecnico_accenture.validation;

import io.restassured.response.Response;
import org.junit.Assert;

public class TokenValidation {
    public static void success(Response r){
        Assert.assertEquals("Geração de token deve retornar 200",200, r.statusCode());
        Assert.assertEquals(r.jsonPath().getString("status"),"Success");
        Assert.assertNotNull(r.jsonPath().getString("token"));
    }
}