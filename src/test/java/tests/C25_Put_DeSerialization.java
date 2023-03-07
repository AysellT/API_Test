package tests;

import baseUrl.BaseUrlJsonPlaceHolder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import testData.TestDataJsonPlaceHolder;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C25_Put_DeSerialization extends BaseUrlJsonPlaceHolder {

    @Test
    public void test(){

        /*
        https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body’e sahip bir PUT request yolladigimizda
        donen response’in response body’sinin asagida verilen ile ayni oldugunu test ediniz

        RequestBody:
        {
            "title": "Ahmet",
            "body": "Merhaba",
            "userId": 10,
            "id": 70
        }

        ExpectedData:
        {
            "title": "Ahmet",
            "body": "Merhaba",
            "userId": 10,
            "id": 70
        }
         */

        //1-request ve endpoint olustur
        specJsonPlaceHolder.pathParams("pp1","posts","pp2","70");
        Map<String,Object> requestBodyMap = TestDataJsonPlaceHolder.bodyOlusturMap();

        //2-expected data olustur
        Map<String,Object> expectedData = TestDataJsonPlaceHolder.bodyOlusturMap();

        //3-request gonder response'i kaydet
        Response response = given().spec(specJsonPlaceHolder).contentType(ContentType.JSON)
                             .when().body(requestBodyMap)
                              .put("{pp1}/{pp2}");

        //4-Assertion
        // Expected response body <===> response body'i karsilastiriyorum
        //      Map               <===>    response(jsonObject)

        // Response'i map'e cevirmemiz gerekir
        Map<String,Object> responseMap = response.as(HashMap.class);

        // expectedData(Map)    <===>  responseMap(Map)
        assertEquals(expectedData.get("title"),responseMap.get("title"));
        assertEquals(expectedData.get("body"),responseMap.get("body"));
        assertEquals(expectedData.get("id"),responseMap.get("id"));
        assertEquals(expectedData.get("userId"),responseMap.get("userId"));

    }
}
