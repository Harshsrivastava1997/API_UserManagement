package Day1;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteRequest {

    @Test

    void deletereques()
    {
         given().
                baseUri("https://reqres.in/").
                header("x-api-key", "reqres-free-v1").
                 when().
                      delete("api/users/2").
                 then().statusCode(204).
                 log().all();

    }
}
