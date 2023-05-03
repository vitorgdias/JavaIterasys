package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Evidencias {
    public void print(WebDriver driver, String nomePrint) throws IOException { //Chama o Selenium
        File foto = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); //Add a 'câmera' no Selenium e clica p/ tirar a foto, gravando um arquivo
        FileUtils.copyFile(foto, new File("target/prints/" + nomePrint +".png")); //Salva as print na pasta de prints (salvando no disco)
    }
}
