package Day1;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PutRequest {

    @Test

    void putreques()
    {
        HashMap data = new HashMap();
        data.put("name", "morpheus");
        data.put("job", "zion resident");


        given().
                baseUri("https://reqres.in/").
                header("x-api-key", "reqres-free-v1").
                contentType("application/json").
                body(data).
        when().
                put("api/users/2").
        then().
                statusCode(200)
                .log().all();
    }
}
