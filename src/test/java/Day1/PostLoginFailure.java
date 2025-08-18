package Day1;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PostLoginFailure {

    @Test
       void loginFailure()
    {
        HashMap dataval = new HashMap();
        dataval.put("email", "peter@klaven");

        given().
                baseUri("https://reqres.in").
                contentType("application/json").
                header("x-api-key","reqres-free-v1").
                body(dataval).
        when().
               post("api/login").
        then().
        statusCode(400).log().all();


    }
}
