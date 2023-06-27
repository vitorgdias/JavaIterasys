package stepsPO;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = { "src/test/resources/featuresPO" },           //Onde estão os cenários em Gherkin
        glue = { "stepsPO" },                                     //Onde estão as definições de passos
        dryRun = false,                                         //Detalhes da execução (logs) junto com o monochrome, podendo ter até 4 combinações
        monochrome = true,
        plugin = {
                    "pretty",                                   //Formatação visual do Cucumber
                    "html:target/reports/extentreports",        //Saida HTML do relatório simples
                    "json:target/reports/extentreports.json",    //Saida json com os dados
                    "com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/reports/dashboard.html"
        }
)

public class Runner extends AbstractTestNGCucumberTests { //Equivale ao @RunWith do JUnit
    // Configuração de modelo de relatório ou de outra característica
}
