package br.com.desafio_tecnico_accenture.steps;

import br.com.desafio_tecnico_accenture.service.bookstore.GetUserDetailsService;
import br.com.desafio_tecnico_accenture.util.ReportUtil;
import br.com.desafio_tecnico_accenture.util.TestContext;
import br.com.desafio_tecnico_accenture.validation.BooksValidation;
import io.cucumber.java.pt.Entao;
import io.restassured.response.Response;
import java.util.List;

public class UserDetailsStepdefs {
    private final TestContext ctx = TestContext.get();

    @Entao("a minha conta exibe os livros selecionados")
    public void validarLivrosNaConta(){
        String userId = ctx.getAs("userId");
        List<String> expected = ctx.getAs("expectedIsbns");
        Response r = new GetUserDetailsService().exec(userId);
        BooksValidation.userHasBooks(r, expected);
        ReportUtil.setResponseReport("GetUserDetails",r);

    }
}