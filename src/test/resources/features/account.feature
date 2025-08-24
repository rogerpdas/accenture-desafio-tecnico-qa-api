# language: pt
Funcionalidade: Fluxo E2E na API Desafio Accecenture QA (Conta + Livros)

  @regressivo
  Cenario: Listar livros, vincular os dois primeiros e validar no detalhe
    Dado que crio uma nova conta de usuário valido para autenticação
    E visualizo a lista de livros disponível
    Quando vinculo os livros selecionados à minha conta
    Entao a minha conta exibe os livros selecionados
