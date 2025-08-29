package Day3;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CapturingHeaders {
    @Test
     public void captureHeaders()
    {
        Response res = given().
                when()
                .get("https://www.google.com");

        //Capturing single header info

        String header = res.getHeader("Content-Type");
        System.out.println("The value of Content-type header is : "+header);

        //Capturing all headers information
        System.out.println("***********ALL HEADERS************");

        Headers my_headers= res.getHeaders();

        for(Header h: my_headers)
        {
            System.out.println(h.getName()+ " "+h.getValue());
        }
    }
}
