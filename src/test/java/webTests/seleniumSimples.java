// 1 - Pacote
package webTests;
// 2 - Bibliotecas

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import utils.Evidencias; //Importa a classe que tira print
import utils.Logs;

// 3 - Classes
public class seleniumSimples {
    // 3.1 - Atributos
    WebDriver driver;       // Declarar o objetodo Selenium WebDriver
    Evidencias evidencias;  // Declara a classe a ser usada
    Logs logs; //Declara a classe
    static String dataHora = new SimpleDateFormat("yyyy-MM-dd HH-mm").format(Calendar.getInstance().getTime());
    //Acima, modela a data e hora de forma universal, pega as informações atuais do PC de data e hora, e transforma para String
    //É possível alterar o formato do mês para MMM (Jan) ou MMMM (Janeiro). Também é possível adicionar os segundos (ss)

    // 3.2 - Métodos e funções
    @BeforeClass
    public void antesDeTudo() throws IOException {
        //Executa apenas uma vez antes de tudo
        logs = new Logs(); //Instaciar o gerador de Logs
        logs.iniciarCSV(dataHora);
    }
    @BeforeMethod //Se utilizar Test ao invés de Method, o programa reutiliza a mesma janela já aberta.
    //Executar os comandas antes de cada teste.
    public void iniciar(){
        // A - Início
        System.setProperty("webdriver.chrome.driver","drivers/chrome/112/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1768, 992)); //Poderia ser usado o window().maximize para deixar em tela maximizada
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
        evidencias = new Evidencias(); //Instanciar a classe para reconhecer o objeto.
    }
    @AfterMethod
    public void finalizar(){
        // C - Encerrar o processo
        driver.quit(); //Encerra o objeto do Selenium
    }
    @Test(priority = 1)
    public void consultarPython() throws IOException, InterruptedException {
        String casoDeTeste = "Consultar curso Pyhon";
        logs.registrarCSV(casoDeTeste, "Iniciou o teste 1");
        // B - Realizar o teste
        driver.get("https://iterasys.com.br/pt"); //Abre o site que foi informado
        logs.registrarCSV(casoDeTeste, "Abriu o site");
        evidencias.print(driver, dataHora, casoDeTeste, "Passo 1 - Abriu o site"); //Essa parte tirará um print da etapa atual
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
        driver.findElement(By.id("16237702146520")).click(); //Clica no campo de Cursos
        logs.registrarCSV(casoDeTeste, "Clicou em Cursos");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/main/div/section/div/div/div/div/div/div[2]/div/div/div/input")).click(); // Clica no campo de pesquisa
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/main/div/section/div/div/div/div/div/div[2]/div/div/div/input")).clear();                        //Limpa o campo
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/main/div/section/div/div/div/div/div/div[2]/div/div/div/input")).sendKeys("Python"); //Escreve "Python" no campo
        logs.registrarCSV(casoDeTeste, "Pesquisou Python");
        evidencias.print(driver, dataHora, casoDeTeste, "Passo 2 - Digitou Python");
        Thread.sleep(300);
        assertEquals(driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/main/div/section/div/div/div/div/main/a/main/div/div[2]/p")).getText(),"R$ 27,90");
        logs.registrarCSV(casoDeTeste, "Conferiu o preço");
        evidencias.print(driver, dataHora, casoDeTeste, "Passo 3 - Verificou o preço");
        logs.registrarCSV(casoDeTeste, "Finalizou o primeiro teste");
    }

    @Test(priority = 2,dependsOnMethods = {"consultarPython"})
    public void consultarJava() throws IOException, InterruptedException {
        String casoDeTeste = "Consultar curso Java";
        logs.registrarCSV(casoDeTeste, "Iniciou o teste 2");
        // B - Realizar o teste
        driver.get("https://iterasys.com.br/pt");
        logs.registrarCSV(casoDeTeste, "Abriu o site");
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
        driver.findElement(By.id("16237702146520")).click();
        logs.registrarCSV(casoDeTeste, "Clicou em Cursos");
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/main/div/section/div/div/div/div/div/div[2]/div/div/div/input")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/main/div/section/div/div/div/div/div/div[2]/div/div/div/input")).clear();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/main/div/section/div/div/div/div/div/div[2]/div/div/div/input")).sendKeys("Introdução ao Java");
        logs.registrarCSV(casoDeTeste, "Pesquisou Introdução ao Java");
        evidencias.print(driver, dataHora, casoDeTeste,"Passo 4 - Digitou Introdução ao Java");
        Thread.sleep(300);
        assertEquals(driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/main/div/section/div/div/div/div/main/a/main/div/div[2]/p")).getText(),"R$ 27,90");
        logs.registrarCSV(casoDeTeste, "Conferiu o preço");
        evidencias.print(driver, dataHora, casoDeTeste, "Passo 5 - Verificou o preço");
        logs.registrarCSV(casoDeTeste, "Finalizou o segundo teste");
    }
}

