package Day5.FileUploadDownload;

import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class MultiFileUpload {

    //This code can't compile because we dont have end points to test
    //so this is going to be generic code

    @Test
    public void Multiupload()
    {
        File file1 = new File("Path/ to/ first/ file/file1.txt");
        File file2 = new File("Path /to/ second /file/file2.txt");

        given().
                      multiPart("myfiles",file1)
                      .multiPart("myfiles",file2)
                      .contentType("multipart/form-data")
                .when()
                      .post("URL of the Endpoint")
                .then()
                      .statusCode(200)
                      .body("[0].fileName",equalTo("file1.txt"))
                      .body("[1].fileName",equalTo("file2.txt"))
                      .log().all();
    }
}
