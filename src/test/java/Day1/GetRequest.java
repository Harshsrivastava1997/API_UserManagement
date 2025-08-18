package Day1;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest {

    @Test
    public void getrequest(){

        given()
                .baseUri("https://reqres.in/")
                .when()
                       .get("api/users/2")
                .then().assertThat().
                                     statusCode(200)
                                     .body("data.id",equalTo((2)));


    }
}
