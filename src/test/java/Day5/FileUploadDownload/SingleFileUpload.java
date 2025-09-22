package Day5.FileUploadDownload;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class SingleFileUpload {

    @Test
    public void fileUploadTest_httpbin() {
        File myfile = new File("C:\\Harsh\\Harsh_test_file"); // make sure this exists

        Response res = given()
                .multiPart("file", myfile)
                .when()
                .post("https://httpbin.org/post");

        Assert.assertEquals(res.getStatusCode(), 200);
        System.out.println(res.asString());

        // httpbin returns file contents under "files" and form under "form"
        // Example assertion: response contains your filename string
        Assert.assertTrue(res.asString().contains("testfile.txt"));
    }
}
