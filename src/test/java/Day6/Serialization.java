package Day6;

import Day2.Pojo_input_Class;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;
import org.testng.annotations.Test;

public class Serialization {


    @Test
    public void convertpojo2json() throws Exception
    {
        Pojo_input_Class picc = new  Pojo_input_Class();
        picc.setname("Ashish");
        picc.setemail("Test@test.com");


        //Converting java objects to json

        ObjectMapper obm = new ObjectMapper();
        {
           String Jsondata= obm.writerWithDefaultPrettyPrinter().writeValueAsString(picc);
           System.out.println(Jsondata);
        }
    }
}
