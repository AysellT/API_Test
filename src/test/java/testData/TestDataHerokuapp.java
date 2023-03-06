package testData;

import netscape.javascript.JSObject;
import org.json.JSONObject;

public class TestDataHerokuapp {

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

    public static JSONObject jsonRequestBodyOlustur(){

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

    public static JSONObject jsonResponseBodyOlustur(){

        JSONObject responseBody = new JSONObject();
        JSONObject bookingBody =  jsonRequestBodyOlustur();

        responseBody.put("bookingid",24);
        responseBody.put("booking",bookingBody);

        return responseBody;

    }
}
