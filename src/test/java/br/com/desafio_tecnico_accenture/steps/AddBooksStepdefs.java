package br.com.desafio_tecnico_accenture.steps;

import br.com.desafio_tecnico_accenture.service.bookstore.AddBooksUserService;


import br.com.desafio_tecnico_accenture.util.ReportUtil;
import br.com.desafio_tecnico_accenture.util.TestContext;
import br.com.desafio_tecnico_accenture.validation.BooksValidation;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;

public class AddBooksStepdefs {
    private final TestContext ctx = TestContext.get();

    @Quando("vinculo os livros selecionados à minha conta")
    public void vincularDoisLivros(){
        Response list = ctx.getAs("booksList");
        String isbn1 = list.jsonPath().getString("books[0].isbn");
        String isbn2 = list.jsonPath().getString("books[1].isbn");
        ctx.set("expectedIsbns", java.util.List.of(isbn1, isbn2));

        String userId = ctx.getAs("userId");
        Response r = new AddBooksUserService().exec(userId, new String[]{isbn1, isbn2});
        BooksValidation.added201(r);
        ReportUtil.setResponseReport("addBooksUser",r);
    }

}
