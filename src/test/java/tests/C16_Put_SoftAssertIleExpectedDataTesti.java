package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C16_Put_SoftAssertIleExpectedDataTesti {

    @Test
    public void test(){

        /*
        http://dummy.restapiexample.com/api/v1/update/21 url’ine asagidaki body’ye sahip bir PUT request gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.

            Request Body
            {
               "status": "success",
               "data": {
                    "name": “Ahmet",
                    "salary": "1230",
                    "age": "44",
                    "id": 40
                       }
            }

            Response Body
            {
               "status": "success",
               "data": {
                   "status": "success",
                   "data":  {
                       "name": “Ahmet",
                       "salary": "1230",
                       "age": "44",
                       "id": 40
                            }
                        },
            "message": "Successfully! Record has been updated."
            }

         */

        //1-request ve endpoint olustur
        String url = "http://dummy.restapiexample.com/api/v1/update/21";

        JSONObject requestBody = new JSONObject();
        JSONObject innerBodyData = new JSONObject();

        innerBodyData.put("name", "Ahmet");
        innerBodyData.put("salary","1230");
        innerBodyData.put("age","44");
        innerBodyData.put("id",40);

        requestBody.put("status", "success");
        requestBody.put("data", innerBodyData);

        //2-expected data olustur
        JSONObject expectedBody = new JSONObject();
        expectedBody.put("status","success");
        expectedBody.put("data",requestBody);
        expectedBody.put("message","Successfully! Record has been updated.");

        //3-request gonder response'i kaydet
        Response response = given().contentType(ContentType.JSON)
                                   .when().body(requestBody.toString())
                                   .put(url);

        //4-Assertion
        JsonPath responseJsonPath = response.jsonPath();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(responseJsonPath.get("status"),expectedBody.get("status"));
        softAssert.assertEquals(responseJsonPath.get("message"),expectedBody.get("message"));
        softAssert.assertEquals(responseJsonPath.get("data.status"),expectedBody.getJSONObject("data").get("status"));
        softAssert.assertEquals(responseJsonPath.get("data.data.name"),expectedBody.getJSONObject("data").getJSONObject("data").get("name"));
        softAssert.assertEquals(responseJsonPath.get("data.data.id"),expectedBody.getJSONObject("data").getJSONObject("data").get("id"));
        softAssert.assertEquals(responseJsonPath.get("data.data.salary"),expectedBody.getJSONObject("data").getJSONObject("data").get("salary"));
        softAssert.assertEquals(responseJsonPath.get("data.data.age"),expectedBody.getJSONObject("data").getJSONObject("data").get("age"));
        softAssert.assertAll();

    }

}
