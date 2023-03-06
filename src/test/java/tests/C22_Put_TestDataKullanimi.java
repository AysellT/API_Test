package tests;

import baseUrl.BaseUrlJsonPlaceHolder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import testData.TestDataJsonPlaceHolder;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C22_Put_TestDataKullanimi extends BaseUrlJsonPlaceHolder {

    @Test
    public void test(){

        /*
        https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body’e sahip bir PUT request yolladigimizda donen response’in
        status kodunun 200, content type’inin “application/json; charset=utf-8”, Connection header degerinin “keep-alive”
        ve response body’sinin asagida verilen ile ayni oldugunu test ediniz

        Request Body;
        {
            "title": "Ahmet",
            "body": "Merhaba",
            "userId": 10,
            "id": 70
        }

        Expected Data:
        {
             "title": "Ahmet",
             "body": "Merhaba",
             "userId": 10,
             "id": 70
        }

         */

        //1-request ve endpoint olustur
        specJsonPlaceHolder.pathParams("pp1","posts","pp2","70");

        JSONObject requestBody = TestDataJsonPlaceHolder.JsonBodyOlustur(10,70,"Ahmet","Merhaba");

        //2-expected data olustur
        JSONObject expectedData = TestDataJsonPlaceHolder.JsonBodyOlustur(10,70,"Ahmet","Merhaba");

        //3-request gonder response'i kaydet
        Response response = given()
                                   .spec(specJsonPlaceHolder).contentType(ContentType.JSON)
                            .when().body(requestBody.toString()).put("/{pp1}/{pp2}");

        //4-Assertion
        assertEquals(TestDataJsonPlaceHolder.basariliStatusCode,response.statusCode());
        assertEquals(TestDataJsonPlaceHolder.contentType,response.contentType());
        assertEquals(TestDataJsonPlaceHolder.headerConnection,response.header("Connection"));

        JsonPath responseJsonPath = response.jsonPath();
        assertEquals(expectedData.getInt("id"),responseJsonPath.getInt("id"));
        assertEquals(expectedData.getInt("userId"),responseJsonPath.getInt("userId"));
        assertEquals(expectedData.getString("title"),responseJsonPath.getString("title"));
        assertEquals(expectedData.getString("body"),responseJsonPath.getString("body"));





        
    }
}
