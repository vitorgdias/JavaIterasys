package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home {
    //Classe de Mapeamento possui 3 se��es
    //1 - Mapeamento de elementos (atributos)
    //2- Construtor entre os Elementos e os Passos
    //3- Fun��es e M�todos Mapeados

    //1 - Mapeamento
    WebDriver driver;

    @FindBy(id = "searchtext")
    WebElement caixaDePesquisa;
    //Similar ao findElement

    @FindBy(id = "btn_form_search")
    WebElement botaoProcurar;

    //2 - Construtor
    public Home(WebDriver driver) {
        this.driver = driver;
    }
    //3- Fun��es e M�todos
    public void pesquisarPorCurso(String curso){
        caixaDePesquisa.click();
        caixaDePesquisa.clear();
        caixaDePesquisa.sendKeys(curso);
    }
    public void clicarNaLupa(){
        botaoProcurar.click();
    }

}
