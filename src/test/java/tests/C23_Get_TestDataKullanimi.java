package tests;

import baseUrl.BaseUrlDummy;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import testData.TestDataDummy;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C23_Get_TestDataKullanimi extends BaseUrlDummy {

    @Test
    public void test(){

        /*

    http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request gonderdigimizde
    donen response’un status code’unun 200, content Type’inin application/json ve
    body’sinin asagidaki gibi oldugunu test edin.

    Response Body
     {
         "status": "success",
         "data": {
             "id": 3,
             "employee_name": "Ashton Cox",
             "employee_salary": 86000,
             "employee_age": 66,
             "profile_image": ""
                  },
         "message": "Successfully! Record has been fetched."
     }

     */

        //1-request ve endpoint olustur
        specDummy.pathParams("pp1","employee","pp2","3");

        //2-expected data olustur
        JSONObject expectedData = TestDataDummy.jsonResponseBodyOlustur(3,
                                                                        "Ashton Cox",
                                                                        86000,
                                                                        66,
                                                                        "");
        System.out.println(expectedData);

        //3-request gonder response'i kaydet
        Response response = given().spec(specDummy).when().get("{pp1}/{pp2}");

        //4-Assertion

        //ExpectedData : JsonObject
        //response : JsonPath

        JsonPath responseJP = response.jsonPath();
        assertEquals(TestDataDummy.basariliStatusCode,response.statusCode());
        assertEquals(TestDataDummy.contentType,response.contentType());
        assertEquals(expectedData.getJSONObject("data").getString("employee_name"),
                     responseJP.getString("data.employee_name"));

        assertEquals(expectedData.getJSONObject("data").getInt("employee_salary"),
                responseJP.getInt("data.employee_salary"));

        assertEquals(expectedData.getJSONObject("data").getInt("employee_age"),
                responseJP.getInt("data.employee_age"));

        assertEquals(expectedData.getJSONObject("data").getInt("id"),
                responseJP.getInt("data.id"));

        assertEquals(expectedData.getJSONObject("data").getString("profile_image"),
                responseJP.getString("data.profile_image"));

    }
}
