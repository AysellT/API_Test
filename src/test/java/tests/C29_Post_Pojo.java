package tests;

import baseUrl.BaseUrlHerokuapp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.PojoHerkokuappRequestBody;
import pojos.PojoHerokuappBookingdates;
import pojos.PojoHerokuappResponseBody;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;
import static org.junit.Assert.assertEquals;

public class C29_Post_Pojo extends BaseUrlHerokuapp {

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
            }
      "additionalneeds" : "wi-fi"
      }

                Response body (expected data)
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

    @Test
    public void test(){
        //1-request ve endpoint olustur
        specHerokuapp.pathParam("pp1","booking");
        PojoHerokuappBookingdates bookingdatesPojo = new PojoHerokuappBookingdates("2021-06-01","2021-06-10");
        PojoHerkokuappRequestBody requestBodyPojo = new PojoHerkokuappRequestBody("Ahmet","Bulut",500,
                                false,bookingdatesPojo,"wi-fi");

        //2-expected data olustur
        bookingdatesPojo = new PojoHerokuappBookingdates("2021-06-01","2021-06-10");

        PojoHerkokuappRequestBody bookingPojo = new PojoHerkokuappRequestBody("Ahmet","Bulut",500,
                                false,bookingdatesPojo,"wi-fi");

        PojoHerokuappResponseBody expectedResponseBodyPojo = new PojoHerokuappResponseBody(24,bookingPojo);

        //3-request gonder response'i kaydet
        Response response = given().spec(specHerokuapp).contentType(ContentType.JSON)
                           .when().body(requestBodyPojo)
                           .post("{pp1}");

        PojoHerokuappResponseBody responsePojo = response.as(PojoHerokuappResponseBody.class);

        //4-Assertion
        assertEquals(expectedResponseBodyPojo.getBooking().getFirstname(),responsePojo.getBooking().getFirstname());
        assertEquals(expectedResponseBodyPojo.getBooking().getLastname(),responsePojo.getBooking().getLastname());
        assertEquals(expectedResponseBodyPojo.getBooking().getTotalprice(),responsePojo.getBooking().getTotalprice());
        assertEquals(expectedResponseBodyPojo.getBooking().getDepositpaid(),responsePojo.getBooking().getDepositpaid());
        assertEquals(expectedResponseBodyPojo.getBooking().getBookingdates().getCheckin(),responsePojo.getBooking().getBookingdates().getCheckin());
        assertEquals(expectedResponseBodyPojo.getBooking().getBookingdates().getCheckout(),responsePojo.getBooking().getBookingdates().getCheckout());
        assertEquals(expectedResponseBodyPojo.getBooking().getAdditionalneeds(),responsePojo.getBooking().getAdditionalneeds());




    }
}
