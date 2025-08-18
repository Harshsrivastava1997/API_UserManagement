package Day1;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PostRegisterUnsuccessfull {

    @Test

    void registerunsuccess()
    {
        HashMap val = new HashMap();
        val.put("email", "sydney@fife");

        given().
                contentType("application/json").
                header("x-api-key","reqres-free-v1").
                baseUri("https://reqres.in/").
                body(val).
        when().
               post("api/register").
                then().
                      statusCode(400).
                                        log().all();

    }
}
