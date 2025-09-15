package Day5;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ParsingXMLResponseByStroringResponseVariable {

    //This is advance way to parse xml reponse can be used in production also

    @Test
    public void parsingXMLResponse()
    {
        Response res = given().
                baseUri("https://www.w3schools.com/xml").
                when().
                      get("cd_catalog.xml");

                Assert.assertEquals(res.getStatusCode(),200);
                Assert.assertEquals(res.getHeader("Content-Type"),"text/xml");

        XmlPath xp = new XmlPath(res.asString());
        //Calculating total number of Artists in the response

        List <String> Artist =xp.getList("Catalog.CD.ARTIST");
          System.out.println("Total number of Artists are : "+Artist.size());

          //Printing all artist
        System.out.println("All Artists are : ");
        for(String artist:Artist)
        {
            System.out.println(artist);
        }

        //Checking specific Artist is present or not
        Assert.assertEquals(Artist.contains("Bonnie Tyler"),true);

        

    }
}
