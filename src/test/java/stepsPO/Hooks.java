package stepsPO;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Carrinho;
import pages.Home;
import pages.Resultado;

public class Hooks {
    Home home;
    Resultado resultado;
    Carrinho carrinho;
    WebDriver driver;
    WebDriverWait wait;
    @Before
    public void iniciarPO(){
            System.setProperty("webdriver.chrome.driver","drivers/chrome/114/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver,60); //Espera até 60 segundos
            home = new Home(driver);
            resultado = new Resultado(driver);
            carrinho = new Carrinho(driver);
        System.out.println("Passo 0");
    }
    @After
    public void finalizarPO(){
        driver.quit();
        System.out.println("Passo Z");
    }
}
