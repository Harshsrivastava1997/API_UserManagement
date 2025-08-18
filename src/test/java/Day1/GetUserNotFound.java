package Day1;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetUserNotFound {
    public static void main(String[] args) {
        RestAssured.baseURI = "https://reqres.in";

        given()
                .header("x-api-key", "reqres-free-v1")
                .when()
                .get("/api/users/23")
                .then()
                .assertThat()
                .statusCode(404);
        System.out.println("Test was Successfull");


    }
}
