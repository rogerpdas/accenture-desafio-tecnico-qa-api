package br.com.desafio_tecnico_accenture.steps;

import br.com.desafio_tecnico_accenture.service.account.*;
import br.com.desafio_tecnico_accenture.service.bookstore.*;
import br.com.desafio_tecnico_accenture.util.ReportUtil;
import br.com.desafio_tecnico_accenture.util.TestContext;
import br.com.desafio_tecnico_accenture.validation.AccountValidation;
import br.com.desafio_tecnico_accenture.validation.BooksValidation;
import io.cucumber.java.*;
import io.restassured.response.Response;
import io.cucumber.java.After;

public class Hooks {
    private final TestContext ctx = TestContext.get();

    @After
    public void afterScenario(Scenario scenario) {

            String userId = ctx.getAs("userId");
            if (userId != null) {
                Response r = new DeleteUserBooksService().exec(userId);
                BooksValidation.deleted204(r);
            }

            TestContext c = TestContext.get(); //authorizeUser
            Boolean authorizeUser = c.getAs("authorizeUser");
            userId = c.getAs("userId");
            if ((authorizeUser != null && authorizeUser)  && userId != null) {
                Response r = new DeleteUserService().exec(userId);
                AccountValidation.deleted204(r);
            }

        if (ReportUtil.getResponseReport("CreateUserService") != null){
            scenario.attach("Detalhe:"+ ReportUtil.getResponseReport("CreateUserService").asString(), "text/plain", "Response: CreateUserService");
        }

        if(ReportUtil.getResponseReport("GenerateTokenService") != null){
            scenario.attach("Detalhe:"+ ReportUtil.getResponseReport("GenerateTokenService").asString(), "text/plain", "Response: GenerateTokenService");
        }

        if(ReportUtil.getResponseReport("AuthorizeUserService") != null){
            scenario.attach("Detalhe:"+ ReportUtil.getResponseReport("AuthorizeUserService").asString(), "text/plain", "Response: AuthorizeUserService");
        }

        if(ReportUtil.getResponseReport("booksList") != null){
            scenario.attach("Detalhe:"+ ReportUtil.getResponseReport("booksList").asString(), "text/plain", "Response: BooksList");
        }

        if(ReportUtil.getResponseReport("addBooksUser") != null){
            scenario.attach("Detalhe:"+ ReportUtil.getResponseReport("addBooksUser").asString(), "text/plain", "Response: AddBooksUser");
        }

        if(ReportUtil.getResponseReport("GetUserDetails") != null){
            scenario.attach("Detalhe:"+ ReportUtil.getResponseReport("GetUserDetails").asString(), "text/plain", "Response: UserDetails");
        }
    }
}
