package tests;

import baseUrl.BaseUrlJsonPlaceHolder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataJsonPlaceHolder;

import static io.restassured.RestAssured.given;

public class C20_Get_TestDataKullanimi extends BaseUrlJsonPlaceHolder {

    @Test
    public void test(){

        /*
        https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET request yolladigimizda
        donen response’in status kodunun 200 ve response body’sinin asagida verilen ile ayni oldugunutest ediniz
        Response body :
        {
            "userId": 3,
            "id": 22,
            "title": "dolor sint quo a velit explicabo quia nam",
            "body": "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
                      um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
        }
         */


        //1-request ve endpoint olustur
        specJsonPlaceHolder.pathParams("pp1","posts","pp2","22");

        //2-expected data olustur
        JSONObject expectedData = TestDataJsonPlaceHolder.responseBodyOlustur22();

        //3-request gonder response'i kaydet
        Response response = given().spec(specJsonPlaceHolder).when().get("/{pp1}/{pp2}");

        //4-Assertion
        JsonPath responseJsonPath = response.jsonPath();

        Assert.assertEquals(TestDataJsonPlaceHolder.basariliStatusCode,response.statusCode());
        Assert.assertEquals(expectedData.getInt("userId"),responseJsonPath.getInt("userId"));
        Assert.assertEquals(expectedData.getInt("id"),responseJsonPath.getInt("id"));
        Assert.assertEquals(expectedData.getString("title"),responseJsonPath.getString("title"));
        Assert.assertEquals(expectedData.getString("body"),responseJsonPath.getString("body"));


    }
}
