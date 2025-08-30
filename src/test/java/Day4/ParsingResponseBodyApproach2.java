package Day4;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ParsingResponseBodyApproach2 {

    @Test
        public void parsingResponse()
    {
      Response res=  given().
                contentType("appliaction/json").
                baseUri("https://reqres.in").
                headers("x-api-key","reqres-free-v1").
                pathParams("pathvalue","users").
                queryParam("page",2).

                when().

                get("/api/{pathvalue}");

      Assert.assertEquals(res.getStatusCode(),200);
      Assert.assertEquals(res.getHeader("Content-Type"),"application/json; charset=utf-8");

    String name =  res.jsonPath().get("data[3].first_name").toString();
    Assert.assertEquals(name,"Byron");

    }
}
