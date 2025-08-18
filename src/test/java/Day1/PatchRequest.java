package Day1;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class PatchRequest {

    @Test
        void patchreq()
    {
        HashMap value = new HashMap();
        value.put("job", "Automation Engineer");

        given()
                .baseUri("https://reqres.in/")
                .header("x-api-key","reqres-free-v1")
                .contentType("application/json")
                .body(value)
                .when()
                .patch("api/users/2")
                .then().
                statusCode(200).
                log().all() ;
    }
}
