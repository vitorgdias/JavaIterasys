package apiTest;
import org.testng.annotations.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
public class User {
    String uri = "https://petstore.swagger.io/v2/user";
    int userId = 1108;
    String username = "vitorgd";
    String password = "123456";
    String token = "";
    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }
    @Test
    public void incluirUser() throws IOException { // Create - Post
        String jsonBody = lerJson("src/test/resources/Data/user.json");
    given()
            .contentType("application/json")
            .log().all()
            .body(jsonBody)
    .when()
            .post(uri)
    .then()
            .log().all()
            .statusCode(200)
            .body("code", is (200))
            .body("type", is ("unknown"))
            .body("message", is (Integer.toString(userId)))
    ;
    }
    @Test
    public void consultarUser(){
        given()
                .contentType("application/json")
                .log().all()
        .when()
                .get(uri + "/" + username)
        .then()
                .log().all()
                .statusCode(200)
                .body("id", is(userId))
                .body("username", is(username))
                .body("firstName", is ("Vitor"))
                .body("lastName", is("Dias"))
                .body("email", is ("vitor@email.com"))
                .body("password", is ("123456"))
                .body("phone", is("1234-5678"))
                .body("userStatus", is(0))
        ;
    }
    @Test
    public void alterarUser() throws IOException {
        String jsonBody = lerJson("src/test/resources/Data/newuser.json");
        given()
                .contentType("application/json")
                .log().all()
                .body(jsonBody)
        .when()
                .put(uri + "/" + username)
        .then()
                .log().all()
                .statusCode(200)
                .body("code", is(200))
                .body("type", is("unknown"))
                .body("message",is(Integer.toString(userId)))
        ;
    }
    @Test
    public void deletarUser(){
        given()
                .contentType("application/json")
                .log().all()
        .when()
                .delete(uri + "/" + username)
        .then()
                .log().all()
                .statusCode(200)
                .body("code", is (200))
                .body("type", is ("unknown"))
                .body("message", is(username))
        ;
    }
    @Test
    public void login(){
        String mensagem =
        given()
                .contentType("application/json")
                .log().all()
        .when()
                .get(uri + "/login?username=" + username + "&password=" + password)
        .then()
                .log().all()
                .statusCode(200)
                .body("code",is(200))
                .body("type",is("unknown"))
        .extract()
                .path("message")
        ;
        System.out.println("Mensagem exibida: " + mensagem);
        token = mensagem.substring(23);
        System.out.printf("Token: " + token);
    }
}
