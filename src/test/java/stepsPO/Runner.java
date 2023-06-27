package stepsPO;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = { "src/test/resources/featuresPO" },           //Onde est�o os cen�rios em Gherkin
        glue = { "stepsPO" },                                     //Onde est�o as defini��es de passos
        dryRun = false,                                         //Detalhes da execu��o (logs) junto com o monochrome, podendo ter at� 4 combina��es
        monochrome = true,
        plugin = {
                    "pretty",                                   //Formata��o visual do Cucumber
                    "html:target/reports/extentreports",        //Saida HTML do relat�rio simples
                    "json:target/reports/extentreports.json",    //Saida json com os dados
                    "com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/reports/dashboard.html"
        }
)

public class Runner extends AbstractTestNGCucumberTests { //Equivale ao @RunWith do JUnit
    // Configura��o de modelo de relat�rio ou de outra caracter�stica
}
