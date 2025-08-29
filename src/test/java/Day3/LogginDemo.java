package Day3;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LogginDemo {

    @Test
    public void logginDemo()
    {
        given().
                baseUri("https://reqres.in").
                header("x-api-key","reqres-free-v1").
                when().
                get("/api/users/2").
                then().
                log().body(); // will print only response body

               // log.cookies(); // will print only cookies
              // log.headers(): // will print only headers
             // log.ifError();// will print only if there is error in response
            // log.all(); // will print everything.
    }
}
