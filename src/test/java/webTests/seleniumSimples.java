// 1 - Pacote
package webTests;
// 2 - Bibliotecas

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

// 3 - Classes
public class seleniumSimples {
    // 3.1 - Atributos
    WebDriver driver;       // Declarar o objetodo Selenium WebDriver
    // 3.2 - Métodos e funções
    @Test
    public void consultarSite(){
        // A - Início
        System.setProperty("webdriver.chrome.driver","drivers/chrome/109/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1768, 992));
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);

        // B - Realizar o teste
        driver.get("https://hype.games/br"); //Abre o site que foi informado
        driver.findElement(By.id("search-input")).click();                        //Clica no campo de pesquisa
        driver.findElement(By.id("search-input")).clear();                        //Limpa o campo
        driver.findElement(By.id("search-input")).sendKeys("ragnarok");//Escreve "ragnarok" no campo
        driver.findElement(By.id("global-search__btn")).click();
        driver.findElement(By.cssSelector("div.w-100.cart")).click();

        assertEquals(driver.findElement(By.cssSelector("span.item-price__current")).getText(),"R$ 19.90");
        assertEquals(driver.findElement(By.cssSelector("info")).getText(),"Ragnarök - Pacote de 11.000 ROPS");
        //driver.findElement(By.cssSelector("a.next")).click();


        //driver.quit(); //Encerra o objeto do Selenium
    }
}
