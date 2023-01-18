package apiTest;

import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Pet {
    @Test
    public void incluirPet(){
        //Padrão
        //Given = Dado
        //.When = Qaundo
        //.Then = Então
        given()
                .contentType("application/json0")
                .log().all()
                .when()
                .post("https://petstore.swagger.io/v2/pet")
                .then()
                .log().all()
        ;
    }
}
