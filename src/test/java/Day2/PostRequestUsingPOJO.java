package Day2;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostRequestUsingPOJO {

    @Test
    void postRequest()
    {
         Pojo_input_Class picc = new     Pojo_input_Class();
         picc.setname("Ashish");
         picc.setemail("Test@test.com");


        given().
                header("x-api-key", "reqres-free-v1").
                contentType("application/json").
                body(picc).
                baseUri("https://reqres.in/").
                when().
                post("/api/users").
                then().

                statusCode(201)
                .body("name",equalTo("Ashish"))
                .body("email",equalTo("Test@test.com"))


                .header("Content-Type","application/json; charset=utf-8");
    }
}
