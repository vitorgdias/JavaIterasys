package apiTest;
import org.testng.annotations.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
public class Store {
    String uri = "https://petstore.swagger.io/v2/store";
    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }
    @Test
    public void incluirOrder() throws IOException { // Create - Post
        String jsonBody = lerJson("src/test/resources/Data/order.json");
        given()
                .contentType("application/json")
                .log().all()
                .body(jsonBody)
        .when()
                .post(uri + "/order")
        .then()
                .log().all()
                .statusCode(200)
                .body("petId", is (1008))
                .body("status", is ("placed"))
                .body("quantity",is(1))
                .body("complete",is(true))
        ;
    }

}
