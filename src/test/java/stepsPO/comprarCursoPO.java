package stepsPO;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.Carrinho;
import pages.Home;
import pages.Resultado;
import static org.testng.Assert.assertEquals;


public class comprarCursoPO {
    WebDriver driver;
    Home home;
    Resultado resultado;
    Carrinho carrinho;
    @Given("^que acesso o site da Iterasys PO$")
    public void queAcessoOSiteDaIterasysPO() {
        driver.get("https://www.iterasys.com.br");
        System.out.println("Passo 1");
    }

    @When("^clico em cursos PO$")
    public void clicoEmCursosPO() {
        driver.findElement(By.id("16237702146520")).click();
        System.out.println("Passo 2");
    }

    @And("^pesquiso por \"([^\"]*)\" PO$")
    public void pesquisoPorPO(String curso) {
        home.clicarNaLupa(curso);
        System.out.println("Passo 3");
    }

    @Then("^visualizo a lista de resultados para \"([^\"]*)\" PO$")
    public void visualizoAListaDeResultadosParaPO(String arg0){
        System.out.println("Passo 4");
        }

    @When("^clico em matricule-se PO$")
    public void clicoEmMatriculeSePO() {
        System.out.println("Passo 5");
    }

    @Then("^confirmo o nome como \"([^\"]*)\" e o preco de \"([^\"]*)\" PO$")
    public void confirmoONomeComoEOPrecoDePO(String curso, String preco) {
        assertEquals(curso, carrinho.lerNomeCurso());
        assertEquals(preco, carrinho.lerPrecoCurso());
        System.out.println("Passo 6");

    }
}
