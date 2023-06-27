package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Resultado {
    WebDriver driver;
    @FindBy(css="h3")
    WebElement indicadorDeCurso;

    @FindBy(xpath="/html/body/div[1]/div/div/div[1]/main/div/section/div/div/div/div/main/a/main")
    WebElement matriculese;

    public Resultado(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
