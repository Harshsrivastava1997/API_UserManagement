package Day5;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class CheckingAllYears {

    @Test
    public void checkingYearsinXMLResponse()
    {

        Response res = given().
                baseUri("https://www.w3schools.com/xml").
                when().
                      get("cd_catalog.xml");
                Assert.assertEquals(res.getStatusCode(),200);
                Assert.assertEquals(res.getHeader("Content-Type"),"text/xml");
                Assert.assertEquals(res.getHeader("Content-Encoding"),"gzip");

                // Creating class for xml path

              XmlPath xp = new XmlPath(res.asString());


               //Taking all years in list
              List <String> All_years= (xp.getList("CATALOG.CD.YEAR"));
               //Checking total years size
               System.out.println("Total years are : "+All_years.size());

               //Printing all years

               System.out.println("All years are : ");

               //Taken years in list above  and now  will print using for each loop


              for(String current_year:All_years)
              {
                  System.out.println(current_year);
              }

              //Checking year 1997 is present or not
            Assert.assertEquals(All_years.contains("1996"),true);
    }
}
