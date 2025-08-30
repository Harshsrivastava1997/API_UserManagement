package Day4;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ParsingResponseBodyPArt1 {

    @Test
     public void parsingResponseBody()
    {
        given().
                contentType("appliaction/json").
                baseUri("https://reqres.in").
                headers("x-api-key","reqres-free-v1").
                pathParams("pathvalue","users").
                queryParam("page",2).

        when().

               get("/api/{pathvalue}").

                then().
                       statusCode(200).
                        body("data[3].first_name",equalTo("Byron")).
                        body("data[3].last_name",equalTo("Fields"));

    }
}
