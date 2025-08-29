package Day3;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class Cookies {
       @Test
    public void getcokkiesInfo()
    {
        Response res = given().
        when()
                .get("https://www.google.com");

               //get all cookies info
                Map<String, String> cookies = res.getCookies();

                //print all cookies
                for(String key: cookies.keySet()) // keyset returns all keys from map
                {
                    System.out.println(key+" : "+cookies.get(key)); // key has key value and cookies.get will return vlaue of cookie
                }
    }
}
