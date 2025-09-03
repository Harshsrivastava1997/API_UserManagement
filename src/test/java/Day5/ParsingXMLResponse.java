package Day5;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ParsingXMLResponse {

    //This is basic does not recommend to use in production because index may change

    @Test
       public void parsingXMLResponse()
    {
        given().
                baseUri("https://www.w3schools.com/xml").
                when().
                get("cd_catalog.xml").
                then().
                statusCode(200).
                header("Content-Type","text/xml").
                header("Content-Encoding","gzip").
                body("Catalog.CD[1].TITLE",equalTo("Hide your heart")).
                body("Catalog.CD[5].COMPANY",equalTo("Polydor"));
    }
}
