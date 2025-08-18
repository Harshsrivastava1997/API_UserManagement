package Day1;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostCreateUSer {

    @Test
    void createUSer()
    {
        HashMap data = new HashMap();
        data.put("name" ,"Harsh" );
        data.put("job","Automation Engineer");
        given().
                header("x-api-key", "reqres-free-v1").
                                                           contentType("application/json").
                body(data).
                           baseUri("https://reqres.in/").
                when().
                        post("api/users").
                then().
                       assertThat()
                .statusCode(201)
                                   .log().all();

    }
}
