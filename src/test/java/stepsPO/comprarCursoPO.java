package stepsPO;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class comprarCursoPO {
    @Given("^que acesso o site da Iterasys PO$")
    public void queAcessoOSiteDaIterasysPO() {
        System.out.println("Passo 1");
    }

    @When("^clico em cursos PO$")
    public void clicoEmCursosPO() {
        System.out.println("Passo 2");
    }

    @And("^pesquiso por \"([^\"]*)\" PO$")
    public void pesquisoPorPO(String arg0) {
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
    public void confirmoONomeComoEOPrecoDePO(String arg0, String arg1) {
        System.out.println("Passo 6");

    }
}
