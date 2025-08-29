package Day3;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class HeadersInformation {

    @Test
     public void headersInfo()
    {
         given().
                 when()
                       .get("https://www.google.com")

                 .then()
                        .header("Content-Type","text/html; charset=ISO-8859-1")
                         .header("Content-Encoding","gzip")
                         .header("Server","gws")
                          .log().all();


    }
}
