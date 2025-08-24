import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        monochrome = true,
        features = "classpath:features",
        glue = {"br.com.desafio_tecnico_accenture.steps"},
        plugin = {
                "pretty",
                "html:target/html-reports/cucumber.html",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },
        tags = "@regressivo"
)

public class TestRunner { }

