package Day6;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class JsonSchemaValidation {


    //URl : https://www.liquid-technologies.com/online-json-to-schema-converter

@Test
    public void jsonvalidation()
{
    File schema = new File("resources/ExpectedmSchema.json");
    given().
            when().
                   get("https://reqres.in/api/users?page=2")
            .then()
            .assertThat()
            .statusCode(200)
            .body(JsonSchemaValidator.matchesJsonSchema(schema));
}
}
