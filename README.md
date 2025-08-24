# API Cucumber Test — DemoQA

Projeto de testes E2E de API usando **Java 17**, **JUnit 4**, **Cucumber 7**, **RestAssured**.

## Como rodar
1. Crie um arquivo `.env` na raiz:
   ```env
   BASE_URL=https://demoqa.com
   USERNAME=RogerioSilva
   PASSWORD=Rogerio@2025
   ```
2. Execute:
   ```bash
   mvn clean test
   ```
3. Report Cucumber:
   ```bash
   Acesse o repositorio (target/html-reports/cucumber.html)
   ```

## Fluxo coberto
- Criar usuário
- Gerar token
- Autorizar usuário
- Listar livros
- Vincular **dois primeiros livros** ao usuário
- Validar detalhe do usuário com os dois livros
- Remover livros e excluir conta (limpeza automática nos Hooks)
