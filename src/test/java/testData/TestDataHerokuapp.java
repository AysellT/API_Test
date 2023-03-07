package testData;

import netscape.javascript.JSObject;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TestDataHerokuapp {



    public static JSONObject jsonRequestBodyOlustur(){
        /*
     Request body;
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
     */

        JSONObject requestBody = new JSONObject();
        JSONObject bookingdatesInnerBody = new JSONObject();

        bookingdatesInnerBody.put("checkin", "2021-06-01");
        bookingdatesInnerBody.put("checkout", "2021-06-10");

        requestBody.put("firstname", "Ahmet");
        requestBody.put("lastname", "Bulut");
        requestBody.put("totalprice", 500);
        requestBody.put("depositpaid", false);
        requestBody.put("bookingdates",bookingdatesInnerBody);
        requestBody.put("additionalneeds", "wi-fi");

        return requestBody;

    }

    public static JSONObject jsonResponseBodyOlustur(){
        /*
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

     */

        JSONObject responseBody = new JSONObject();
        JSONObject bookingBody =  jsonRequestBodyOlustur();

        responseBody.put("bookingid",24);
        responseBody.put("booking",bookingBody);

        return responseBody;
    }




    /*
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
         */
    public static Map<String,Object> bookingdatesOlusturMap(){

        Map<String,Object> innerBookingdatesMap = new HashMap<>();
        innerBookingdatesMap.put("checkin","2021-06-01");
        innerBookingdatesMap.put("checkout","2021-06-10");
        return innerBookingdatesMap;

    }
    public static Map<String,Object> requestBodyOlusturMap(){

        Map<String,Object> requestBodyMap = new HashMap<>();
        requestBodyMap.put("firstname", "Ahmet");
        requestBodyMap.put("lastname" , "Bulut");
        requestBodyMap.put("totalprice" , 500.0);
        requestBodyMap.put("depositpaid" , false);
        requestBodyMap.put("bookingdates" , bookingdatesOlusturMap());
        return requestBodyMap;

    }
    public static Map<String,Object> responseBodyOlusturMap(){//expectedData

        /*
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

        Map<String,Object> responseBodyMap = new HashMap<>();
        responseBodyMap.put("bookingid",24);
        responseBodyMap.put("booking",requestBodyOlusturMap());
        return responseBodyMap;

    }



}
