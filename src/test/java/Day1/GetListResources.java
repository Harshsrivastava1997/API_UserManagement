package Day1;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GetListResources {

    @Test

    public void listResource()
    {
        given().
                header("x-api-key", "reqres-free-v1")
                .baseUri("https://reqres.in/").
                when().
                get("api/unknown").then()
                .assertThat().statusCode(200)
                .body("page",equalTo(1))
                .body("per_page",equalTo(6))
                .body("total",equalTo(12))
                .body("total_pages",equalTo(2))
                .log().all();


    }
}
