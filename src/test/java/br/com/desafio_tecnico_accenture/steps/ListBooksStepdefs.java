package br.com.desafio_tecnico_accenture.steps;

import br.com.desafio_tecnico_accenture.service.bookstore.ListBooksService;
import br.com.desafio_tecnico_accenture.util.ReportUtil;
import br.com.desafio_tecnico_accenture.util.TestContext;
import br.com.desafio_tecnico_accenture.validation.BooksValidation;
import io.cucumber.java.pt.Dado;
import io.restassured.response.Response;

public class ListBooksStepdefs {
    private final TestContext ctx = TestContext.get();

    @Dado("visualizo a lista de livros disponível")
    public void obterListaLivros(){
        Response r = new ListBooksService().exec();
        BooksValidation.listOk(r);
        ctx.set("booksList", r);
        ReportUtil.setResponseReport("booksList",r);

    }

}