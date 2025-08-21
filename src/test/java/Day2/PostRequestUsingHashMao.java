package Day2;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostRequestUsingHashMao {

    @Test

    public void postRequest()
    {
        HashMap hm = new HashMap();
        hm.put("name","Harsh");
        hm.put("job", "leader");
        String Coursearr[]={"RestAssured","Java"};
        hm.put("courses",Coursearr);

        given().header("x-api-key", "reqres-free-v1").
                contentType("application/json").
                body(hm).
                baseUri("https://reqres.in/").
                when().
                post("/api/users").
                then().

                statusCode(201)
                .body("name",equalTo("Harsh"))
                .body("job",equalTo("leader"))
                .body("courses[0]",equalTo("RestAssured"))
                .body("courses[1]",equalTo("Java"))
                .header("Content-Type","application/json; charset=utf-8");
    }
}
