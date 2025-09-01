package Day4;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;

public class ParsingJsonBody2 {
    @Test
    public void JsonBody2() {
        Response res = given().
                contentType("application/json").
                header("x-api-key", "reqres-free-v1").
                baseUri("https://reqres.in").
                pathParams("pathvalue", "unknown").

                when().
                get("api/{pathvalue}");

        //Cretaing JSONObject to capture response in sTring format

        JSONObject jo = new JSONObject(res.asString());

        //Traversing through loops
        int Sum_year=0;
        for(int i=0;i<jo.getJSONArray("data").length();i++)
        {
            String yearel=jo.getJSONArray("data").getJSONObject(i).get("year").toString();

            //Now we will check sum of all years in the response
            Sum_year= Sum_year+(Integer.parseInt(yearel)); // converting String yearel to integer then finding the sum of them

        }
        System.out.println("The sum of year availabe in response is : " +Sum_year);
}
}
