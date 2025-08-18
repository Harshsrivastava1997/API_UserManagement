package Day1;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class GetRequestMultipleUsers {
    @Test
    public void getRequestMultiple()
    {
        given().
                baseUri("https://reqres.in/")
                . when().
                get("api/users?page=2").
                then().
                assertThat().statusCode(200);

    }
}
