// 1 - Pacote
package webTests;
// 2 - Bibliotecas

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

// 3 - Classes
public class seleniumSimples {
    // 3.1 - Atributos
    WebDriver driver;       // Declarar o objetodo Selenium WebDriver
    // 3.2 - Métodos e funções
    @BeforeMethod //Se utilizar Test ao invés de Method, o programa reutiliza a mesma janela já aberta.
    public void iniciar(){
        // A - Início
        System.setProperty("webdriver.chrome.driver","drivers/chrome/112/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1768, 992));
        driver.manage().timeouts().implicitlyWait(600, TimeUnit.MILLISECONDS);
    }
    @AfterMethod
    public void finalizar(){
        // C - Encerrar o processo
        driver.quit(); //Encerra o objeto do Selenium
    }
    @Test(priority = 1)
    public void consultarRO(){
        // B - Realizar o teste
        driver.get("https://hype.games/br"); //Abre o site que foi informado
        driver.findElement(By.id("searchContainerSection")).click();                        //Clica no campo de pesquisa
        driver.findElement(By.id("searchContainerSection")).clear();                        //Limpa o campo
        driver.findElement(By.id("searchContainerSection")).sendKeys("ragnarok");//Escreve "ragnarok" no campo
        driver.findElement(By.id("submit")).click();
        driver.findElement(By.cssSelector("div.w-100.cart")).click();

        //assertEquals(driver.findElement(By.cssSelector("span.item-price__current")).getText(),"R$ 19.90");
        //assertEquals(driver.findElement(By.cssSelector("info")).getText(),"Ragnarök - Pacote de 11.000 ROPS");
        //driver.findElement(By.cssSelector("a.next")).click();
    }
    @Test(priority = 2,dependsOnMethods = {"consultarRO"})
    public void consultarPW(){
        // B - Realizar o teste
        driver.get("https://hype.games/br");
        driver.findElement(By.id("search-input")).click();
        driver.findElement(By.id("search-input")).clear();
        driver.findElement(By.id("search-input")).sendKeys("perfect world");
        driver.findElement(By.id("global-search__btn")).click();
        driver.findElement(By.cssSelector("div.w-100.cart")).click();

        //assertEquals(driver.findElement(By.cssSelector("span.item-price__current")).getText(),"R$ 219.90");
        //assertEquals(driver.findElement(By.cssSelector("a.info-box.h3")).getText(),"Perfect World – Pacote de 46.200 GOLD – Melhor Oferta");
        //driver.findElement(By.cssSelector("a.next")).click();
    }
}
