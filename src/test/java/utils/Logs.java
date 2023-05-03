package utils;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Logs {
    String dataHora;
    public void iniciarCSV(String dataHora) throws IOException {
        //Cria o arquivo de log no início da execução do teste
        String[] cabecalho = {"data e hora", "caso de teste", "mensagem"};
        this.dataHora = dataHora;
        Writer escritor = Files.newBufferedWriter(Paths.get("target/logs/log - " + dataHora + ".csv"));
        CSVWriter escritorCSV = new CSVWriter(escritor);
        escritorCSV.writeNext(cabecalho);

        escritor.flush();
        escritor.close();
    }
    public void registrarCSV(String casoDeTest, String mensagem) throws IOException {
        //Grava cada linha no log
        String dataHoraLog = new SimpleDateFormat("[yyyy/MM/dd] HH:mm:ss.SSS").format(Calendar.getInstance().getTime());
        String[] linhas = new String[]{dataHoraLog,casoDeTest,mensagem};
        FileWriter escritor = new FileWriter("target/logs/log - " + dataHora + ".csv", true);
        CSVWriter escritorCSV = new CSVWriter(escritor);

        escritorCSV.writeNext(linhas);
        escritor.flush();
        escritor.close();
    }
}
