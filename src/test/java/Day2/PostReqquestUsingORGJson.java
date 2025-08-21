package Day2;

import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostReqquestUsingORGJson {
    @Test
     void postRequest()
    {
        JSONObject data = new JSONObject();
        data.put("name","Akash");
        data.put("email","akash@google.com");
        String Coursearr[]={"SDET","Maven","CI/CD"}; // Array of String for multiple cousres
        data.put("courses",Coursearr);

        //Actual code start from here

         given().
                 body(data.toString())
                 .baseUri("https://reqres.in/")
                 .header("x-api-key","reqres-free-v1")
                 .contentType("application/json")
                 .when()
                 .post("/api/users/")
                 .then()
                 .statusCode(201)
                 .body("email",equalTo("akash@google.com"))
                 .body("name",equalTo("Akash"))
                 .body("courses[1]",equalTo("Maven"))
                 .body("courses[2]",equalTo("CI/CD"))
                 .header("Content-Type","application/json; charset=utf-8")
                 .log().all();
    }
}
