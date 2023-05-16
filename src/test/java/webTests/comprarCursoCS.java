package webTests;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class comprarCursoCS {
    WebDriver driver;
    WebDriverWait wait;
    @Before
    public void iniciar(){
        System.setProperty("webdriver.chrome.driver","drivers/chrome/112/chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
        //Recomenda-se usar apenas um tipo de espera no código
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,60); //Espera até 60 segundos
        System.out.println("0 - Antes do Teste iniciar");
    }
    @After
    public void finalizar(){
        driver.quit();
        System.out.println("Z - Depois do Teste finalizar");
    }
    @Given("^que acesso o site da Iterasys$")
    public void queAcessoOSiteDaIterasys() {
        driver.get("https://www.iterasys.com.br");
        System.out.println("1 - Acessou o site");
    }

    @When("^clico em cursos$")
    public void clicoEmCursos() throws InterruptedException {
        driver.findElement(By.id("16237702146520")).click();
        System.out.println("2 - Clicou em cursos");
    }

    @And("^pesquiso por \"([^\"]*)\"$")
    public void pesquisoPor(String curso){
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/main/div/section/div/div/div/div/div/div[2]/div/div/div/input")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/main/div/section/div/div/div/div/div/div[2]/div/div/div/input")).clear();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/main/div/section/div/div/div/div/div/div[2]/div/div/div/input")).sendKeys(curso);
        //Caso queira escrever letra por letra, basta colocar .sendKeys(Keys.chord()), para simular o teclado
        System.out.println("3 - Digitou o nome do curso " + curso);
    }

    @And("^visualizo a lista de resultados para \"([^\"]*)\"$")
    public void visualizoAListaDeResultadosPara(String curso) throws InterruptedException {
        // Thread.sleep(900); Evitar usar isso, pois é uma pausa forçada da automação
        String textoEsperado = curso;
        WebElement h3texto = driver.findElement(By.cssSelector("h3"));
        // wait.until(ExpectedConditions.textToBe(By.cssSelector("h3"),textoEsperado)); Espera até o elemento ter o texto desejado
        wait.until(ExpectedConditions.textToBePresentInElement(h3texto,textoEsperado));
        System.out.println("4 - Exibiu a lista de resultados da pesquisa para o curso " + curso);
    }

    @And("^clico em matricule-se$")
    public void clicoEmMatriculeSe() {
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/main/div/section/div/div/div/div/main/a/main")).click();
        System.out.println("5 - Clicou em matricule-se");
    }

    @Then("^confirmo o nome como \"([^\"]*)\" e o preco de \"([^\"]*)\"$")
    public void confirmoONomeComoEOPrecoDe(String curso, String preco){
        String textoEsperado = curso;
        WebElement h3texto = driver.findElement(By.cssSelector("h3"));
        wait.until(ExpectedConditions.textToBePresentInElement(h3texto,textoEsperado));
        assertEquals(driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/main/div[1]/div/section/div/div[1]/div/div[1]/div/div[2]/div/div/div[1]/div[2]/div[1]/div[1]/p")).getText(),preco);
        assertEquals(driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/main/div[1]/div/section/div/div[1]/div/div[1]/div/div[1]/div/h1")).getText(),"Introdução ao " + curso);
        System.out.println("6 - Confirmou o nome como " + curso + " e preco do curso como " + preco);
    }

    @When("^clico na imagem do curso$")
    public void clicoNaImagemDoCurso() {
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/main/div/section/div/div/div/div/main/a[1]")).click();
    }

    @Then("^vejo a pagina com detalhes do curso$")
    public void vejoAPaginaComDetalhesDoCurso() {
        assertEquals(driver.getTitle(),"Início Rápido em Testes e QA | Udemy");
    }
}
