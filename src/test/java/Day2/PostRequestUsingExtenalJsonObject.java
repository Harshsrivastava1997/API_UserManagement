package Day2;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostRequestUsingExtenalJsonObject {
    @Test
    void postRequestUsingExternalJson() throws FileNotFoundException {
        File file = new File(".//data.json");
        FileReader fr = new FileReader(file);
        JSONTokener jt = new JSONTokener(fr);
        JSONObject obj = new JSONObject(jt);

        given().
                body(obj.toString())
                .baseUri("https://reqres.in/")
                .header("x-api-key","reqres-free-v1")
                .contentType("application/json")
                .when()
                .post("/api/users/")
                .then()
                .statusCode(201)
                .body("email",equalTo("akash@google.com"))
                .body("name",equalTo("Akash"))
                .body("courses[0]",equalTo("Maven"))
                .body("courses[1]",equalTo("CI/CD"))
                .header("Content-Type","application/json; charset=utf-8")
                .log().all();

    }
}
