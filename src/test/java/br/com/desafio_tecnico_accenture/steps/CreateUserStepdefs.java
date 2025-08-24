package br.com.desafio_tecnico_accenture.steps;

import br.com.desafio_tecnico_accenture.service.account.AuthorizeUserService;
import br.com.desafio_tecnico_accenture.service.account.CreateUserService;
import br.com.desafio_tecnico_accenture.service.account.GenerateTokenService;
import br.com.desafio_tecnico_accenture.util.EnvConfig;
import br.com.desafio_tecnico_accenture.util.ReportUtil;
import br.com.desafio_tecnico_accenture.util.TestContext;
import br.com.desafio_tecnico_accenture.validation.AccountValidation;
import br.com.desafio_tecnico_accenture.validation.TokenValidation;
import io.cucumber.java.pt.Dado;
import io.restassured.response.Response;

public class CreateUserStepdefs {

    private final TestContext ctx = TestContext.get();

    @Dado("que crio uma nova conta de usuário valido para autenticação")
    public void createUserAndAuthorize() {
        // Create user
        Response rCreate = new CreateUserService().exec(EnvConfig.user(), EnvConfig.password());
        ReportUtil.setResponseReport("CreateUserService",rCreate);
        AccountValidation.created(rCreate);
        String userId = rCreate.jsonPath().getString("userID");
        ctx.set("userId", userId);

        // Generate token
        Response responseToken = new GenerateTokenService().exec(EnvConfig.user(), EnvConfig.password());
        ReportUtil.setResponseReport("GenerateTokenService",responseToken);
        TokenValidation.success(responseToken);
        String token = responseToken.jsonPath().getString("token");
        ctx.set("token", token);

        // Authorize user
        Response rAuth = new AuthorizeUserService().exec(token, EnvConfig.user(), EnvConfig.password());
        ReportUtil.setResponseReport("AuthorizeUserService",rAuth);
        AccountValidation.authorized(rAuth);
        Boolean rAuthorizeUser = rAuth.jsonPath().getBoolean("");
        ctx.set("authorizeUser",rAuthorizeUser);

    }


}
