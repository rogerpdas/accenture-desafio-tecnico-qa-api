package br.com.desafio_tecnico_accenture.validation;

import io.restassured.response.Response;
import org.junit.Assert;
import java.util.List;

public class BooksValidation {

    public static void listOk(Response r){
        Assert.assertEquals("Listagem deve retornar 200",200, r.statusCode());
        List<?> books = r.jsonPath().getList("books");
        Assert.assertNotNull("Campo books nulo",books);
        Assert.assertTrue("Esperado pelo menos 2 livros",books.size() >= 2);
    }
    public static void added201(Response r){
        Assert.assertEquals("Adicionar livros deve retornar 201",201, r.statusCode());
    }
    public static void userHasBooks(Response r, List<String> expected){
        Assert.assertEquals("Detalhe do usuário deve retornar 200",200, r.statusCode());
        List<String> got = r.jsonPath().getList("books.isbn");
        Assert.assertTrue("Nem todos os ISBN esperados estão na conta",got.containsAll(expected));
    }
    public static void deleted204(Response r){
        Assert.assertEquals("Remoção de livros deve retornar 204",204, r.statusCode());
    }

}