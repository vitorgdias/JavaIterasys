package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
    //Classe de Mapeamento possui 3 se��es
    //1 - Mapeamento de elementos (atributos)
    //2- Construtor entre os Elementos e os Passos
    //3- Fun��es e M�todos Mapeados

    //1 - Mapeamento
    WebDriver driver;

    @FindBy(id = "16237702146520")
    WebElement caixaDePesquisa;
    //Similar ao findElement

    @FindBy(xpath = "\"/html/body/div[1]/div/div/div[1]/main/div/section/div/div/div/div/div/div[2]/div/div/div/input\"")
    WebElement botaoProcurar;

    //2 - Construtor
    public Home(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    //3- Fun��es e M�todos
    public void pesquisarPorCurso(){
        caixaDePesquisa.click();
    }
    public void clicarNaLupa(String curso){
        botaoProcurar.click();
        botaoProcurar.sendKeys(curso);
    }

}
