package br.com.desafio_tecnico_accenture.steps;

import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Entao;

public class GenerateTokenStepdefs {
    @Quando("o token do usuário é gerado")
    public void tokenGerado(){ /* feito nos Hooks */ }

    @Entao("o usuário está autorizado na API")
    public void usuarioAutorizado(){ /* validado nos Hooks */ }
}
