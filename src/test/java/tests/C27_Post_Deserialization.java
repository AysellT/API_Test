package tests;

import baseUrl.BaseUrlHerokuapp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataHerokuapp;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C27_Post_Deserialization extends BaseUrlHerokuapp {

    @Test
    public void test(){

        /*
        https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip bir POST request gonderdigimizde
        donen response’un id haric asagidaki gibi oldugunu test edin.

        Request body
        {
             "firstname" : "Ahmet",
             "lastname" : “Bulut",
             "totalprice" : 500,
             "depositpaid" : false,
             "bookingdates" : {
                   "checkin" : "2021-06-01",
                   "checkout" : "2021-06-10"
                            },
             "additionalneeds" : "wi-fi"
         }

         Response Body // expected data
         {
              "bookingid": 24,
              "booking": {
                   "firstname": "Ahmet",
                   "lastname": "Bulut",
                   "totalprice": 500,
                   "depositpaid": false,
                   "bookingdates": {
                          "checkin": "2021-06-01",
                          "checkout": "2021-06-10"
                          },
                    "additionalneeds": "wi-fi"
                          }
         }
         */

        //1-request ve endpoint olustur
        specHerokuapp.pathParam("pp1","booking");

        Map<String,Object> requestBodyMap = TestDataHerokuapp.requestBodyOlusturMap();

        //2-expected data olustur
        Map<String,Object> expectedData = TestDataHerokuapp.responseBodyOlusturMap();
        //System.out.println(expectedData);

        //3-request gonder response'i kaydet
        Response response = given().spec(specHerokuapp).contentType(ContentType.JSON)
                .when().body(requestBodyMap).post("{pp1}");
        //response.prettyPrint();

        //4-Assertion
        Map<String,Object> responseMap = response.as(HashMap.class);

        assertEquals( ((Map)expectedData.get("booking")).get("firstname"),
                      ((Map)responseMap.get("booking")).get("firstname")  );

        assertEquals(  ((Map)expectedData.get("booking")).get("lastname"),
                       ((Map)responseMap.get("booking")).get("lastname")  );

        assertEquals(  ((Map)expectedData.get("booking")).get("totalprice"),
                          ((Map)responseMap.get("booking")).get("totalprice") );

        assertEquals( ((Map) expectedData.get("booking")).get("depositpaid"),
                          ((Map) responseMap.get("booking")).get("depositpaid")  );

        assertEquals( ((Map)((Map) expectedData.get("booking")).get("bookingdates")).get("checkout"),
                      ((Map)((Map) responseMap.get("booking")).get("bookingdates")).get("checkout")  );

    }

}
