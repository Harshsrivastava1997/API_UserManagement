package Day5;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ParsingResponsePart2 {
    //This is advance way to parse xml reponse can be used in production also

    @Test
    void parsingResponsePart2()
    {
        Response res = given().
                       baseUri("https://www.w3schools.com/xml").
                when().
                       get("cd_catalog.xml");

             XmlPath xp1 = new XmlPath(res.asString());

             //Calculating total price of all CDs
              double sum=0;
            List<String> price = xp1.getList("Catalog.CD.PRICE");

               for(int i =0;i<price.size();i++)
               {
                   String priceString = price.get(i).replace("$", "");
                   sum = sum + Double.parseDouble(priceString);
               }
               System.out.println("Total price of all CDs is : "+sum);
    }
}
