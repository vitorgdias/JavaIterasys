package apiTest;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.contains;
//import static org.hamcrest.Matchers.not;


public class Pet {
    // Funções de apoio
    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }
    @Test
    public void incluirPet() throws IOException { // Create - Post
            String jsonBody = lerJson("src/test/resources/Data/pet.json");
        //Padrão
        //Given = Dado
        //.When = Quando
        //.Then = Então
        given()
                .contentType("application/json") //Tipo do conteúdo
                // "text/xml" para web services sincronos - ex: Correios, email
                // "application/json" para web services assincronos - ex: Ifood, e-mail
                .log().all()                     //Registrar tudo do envio
                .body(jsonBody)
        .when()
                .post("https://petstore.swagger.io/v2/pet")//Comando + end point
        .then()
                .log().all() //Registrar tudo da volta
                .statusCode(200) //Valida o Código do Estado nativo
                //.body("code",is(200)) //Valida o Código do Estado no json
                .body("id", is (1008)) // Valida o id
                .body("name", is ("Snoopas")) // Valida o nome
                .body("category.name", is("dog")) // Valida se é cachorro
                //.body("tags.name",not(contains("não vermifugado"))) // Valida se contem a palavra chave
                .body("tags.name",contains("vermifugado ok")) // Valida se contem a palavra chave
        ;
    }

    @Test
    public void consultarPet() {
        String petId = "1008"; //id do animal

        given()
                .contentType("application/json")
                .log().all()
        .when()
                .get("https://petstore.swagger.io/v2/pet/" + petId)
        .then()
                .log().all()
                .statusCode(200)
                .body("name", is("Snoopas"))
                .body("status", is("available"))
        ;


    }
}
