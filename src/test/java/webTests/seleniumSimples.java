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
        driver.manage().window().setSize(new Dimension(1768, 992)); //Poderia ser usado o window().maximize para deixar em tela maximizada
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
    }
    @AfterMethod
    public void finalizar(){
        // C - Encerrar o processo
        driver.quit(); //Encerra o objeto do Selenium
    }
    @Test(priority = 1)
    public void consultarPython(){
        // B - Realizar o teste
        driver.get("https://iterasys.com.br/pt"); //Abre o site que foi informado
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
        driver.findElement(By.id("16237702146520")).click(); //Clica no campo de Cursos
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/main/div/section/div/div/div/div/div/div[2]/div/div/div/input")).click(); // Clica no campo de pesquisa
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/main/div/section/div/div/div/div/div/div[2]/div/div/div/input")).clear();                        //Limpa o campo
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/main/div/section/div/div/div/div/div/div[2]/div/div/div/input")).sendKeys("Python"); //Escreve "Python" no campo
        assertEquals(driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/main/div/section/div/div/div/div/main/a/main/div/div[2]/p")).getText(),"R$ 27,90");
    }
    @Test(priority = 2,dependsOnMethods = {"consultarPython"})
    public void consultarJava(){
        // B - Realizar o teste
        driver.get("https://iterasys.com.br/pt");
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
        driver.findElement(By.id("16237702146520")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/main/div/section/div/div/div/div/div/div[2]/div/div/div/input")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/main/div/section/div/div/div/div/div/div[2]/div/div/div/input")).clear();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/main/div/section/div/div/div/div/div/div[2]/div/div/div/input")).sendKeys("Introdução ao Java");
        assertEquals(driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/main/div/section/div/div/div/div/main/a/main/div/div[2]/p")).getText(),"R$ 27,90");
    }
}

