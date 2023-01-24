package apiTest;

import org.testng.annotations.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
//import static org.hamcrest.Matchers.not;
public class Pet {
    String uri = "https://petstore.swagger.io/v2/pet";
    int petId = 1008;
    // Funções de apoio
    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }
    @Test (priority = 0)
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
                .post(uri)//Comando + end point
        .then()
                .log().all() //Registrar tudo da volta
                .statusCode(200) //Valida o Código do Estado nativo
                //.body("code",is(200)) //Valida o Código do Estado no json
                .body("id", is (petId)) // Valida o id
                .body("name", is ("Snoopas")) // Valida o nome
                .body("category.name", is("dog")) // Valida se é cachorro
                //.body("tags.name",not(contains("não vermifugado"))) // Valida se contem a palavra chave
                //.body("tags.name",contains("vermifugado ok")) // Valida se contem a palavra chave
                .body("tags.id[0]", is(3))
                .body("tags.name[0]", stringContainsInOrder("primeira semana")) // Valida se contem a palavra, frase ou parte da palavra (o ID no pet.json não influencia)
                .body("tags.id[1]", is(4))
                .body("tags.name[1]", stringContainsInOrder("segunda semana")) //O tags.name precisa do bloco entre chaves, pois é um array (o ID no pet.json não influencia)
        ;
    }
    @Test (priority = 1, dependsOnMethods = {"incluirPet"}) //Usar o depends faz com que o método só execute após o outro. Caso queira rodar o método sozinho, precisa retirar o depends.
    public void consultarPet() {
        //String petId = "1008"; //id do animal
        given()
                .contentType("application/json")
                .log().all()
        .when()
                .get(uri + "/" + petId)
        .then()
                .log().all()
                .statusCode(200)
                .body("name", is("Snoopas"))
                .body("status", is("available"))
        ;
    }
    @Test (priority = 2, dependsOnMethods = {"consultarPet"})
    public void alterarPet() throws IOException{
        String jsonBody = lerJson("src/test/resources/data/newpet.json");
        given()
                .contentType("application/json")
                .log().all()
                .body(jsonBody)
        .when()
                .put(uri)
        .then()
                .log().all()
                .statusCode(200)
                .body("status", is ("sold"))
        ;
    }
    @Test (priority = 3, dependsOnMethods = {"alterarPet"})
    public void deletarPet(){
        given()
                .contentType("application/json")
                .log().all()
        .when()
                .delete(uri + "/" + petId)
        .then()
                .log().all()
                .statusCode(200)
                .body("code", is (200))
                .body("type", is ("unknown"))
                .body("message", is(Integer.toString(petId)))
        ;
    }
}
