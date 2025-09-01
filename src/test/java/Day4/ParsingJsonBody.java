package Day4;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ParsingJsonBody {
    boolean flag = false;

    @Test
    public void parsingJsonBody() {
        Response res = given().
                contentType("application/json").
                header("x-api-key", "reqres-free-v1").
                baseUri("https://reqres.in").
                pathParams("pathvalue", "unknown").

                when().
                get("api/{pathvalue}");

        //Creating JsonObject to parse response body

        JSONObject jo = new JSONObject(res.asString()); //Returns the body of the response as a String

        for (int i = 0; i < jo.getJSONArray("data").length(); i++)
        {
            String nameele = jo.getJSONArray("data").getJSONObject(i).get("name").toString();
            if(nameele.equals("tigerlily"))
            {
                flag=true;
                break;
            }

        }
        Assert.assertEquals(flag,true);
    }
    }

