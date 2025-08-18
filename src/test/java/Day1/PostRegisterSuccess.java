package Day1;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PostRegisterSuccess {

    @Test
    void Register()
    {
        HashMap value = new HashMap();
        value.put("email", "eve.holt@reqres.in");
        value.put("password", "pistol");

       given().
               contentType("application/json").
                               header("x-api-key","reqres-free-v1").
               body(value).
                          baseUri("https://reqres.in/").
               when().
                      post("api/register").
               then().
                      statusCode(200)
               .log().all();
    }
}
