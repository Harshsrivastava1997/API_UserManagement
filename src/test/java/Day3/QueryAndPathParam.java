package Day3;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class QueryAndPathParam {
    @Test
    public void pathAndQueryParam() {
        given()
                .pathParam("mypath", "users")
                .queryParam("id", 5)
                .queryParam("page", 2)
                .contentType("application/json")
                .header("x-api-key", "reqres-free-v1")
                .baseUri("https://reqres.in")

                .when()
                .get("/api/{mypath}")


                .then()
                .statusCode(200)
                .log().all();
    }
}

