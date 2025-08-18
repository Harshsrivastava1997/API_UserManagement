package Day1;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PostLoginSuccess {

    @Test

    void loginsuccess()
    {
        HashMap data1 = new HashMap();
        data1.put("email", "eve.holt@reqres.in");
        data1.put("password", "cityslicka");

        given().
                contentType("application/json").
                baseUri("https://reqres.in/").
                header("x-api-key","reqres-free-v1").
                body(data1).
        when().
                post("api/login").
        then().
               statusCode(200).
                log().all();

    }
}
