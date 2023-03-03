import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C11_Post_JsonPathIleBodyTesti {

    @Test
    public void test(){

        /*
        https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip bir POST request gonderdigimizde
         {
         "firstname" : "Ahmet",
         "lastname" : “Bulut",
         "totalprice" : 500,
         "depositpaid" : false,
         "bookingdates" : {
                 "checkin" : "2023-01-10",
                 "checkout" : "2023-01-20" },
         "additionalneeds" : "wi-fi"
         }
         donen Response’un,
         status code’unun 200,
         ve content type’inin application-json,
         ve response body’sindeki
         "firstname“in,"Ahmet",
         ve "lastname“in, "Bulut",
         ve "totalprice“in,500,
         ve "depositpaid“in,false,
         ve "checkin" tarihinin 2023-01-10 ve "checkout" tarihinin 2023-01-20 ve "additionalneeds“in,"wi-fi"
         oldugunu test edin
         */

        //1-request ve endpoint olustur
        String url = "https://restful-booker.herokuapp.com/booking";

        JSONObject innerBody = new JSONObject();
        innerBody.put("checkin" , "2023-01-10");
        innerBody.put("checkout" , "2023-01-20");

        JSONObject requestBody = new JSONObject();
        requestBody.put("firstname" , "Ahmet");
        requestBody.put("lastname" , "Bulut");
        requestBody.put("totalprice" , 500);
        requestBody.put("depositpaid" , false);
        requestBody.put("bookingdates",innerBody);
        requestBody.put("additionalneeds" , "wi-fi");

        //2-expected data olustur

        //3-request gonder response'i kaydet
        Response response = given().contentType(ContentType.JSON)
                            .when().body(requestBody.toString())
                            .post(url);

        //4-Assertion
        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("booking.firstname",equalTo("Ahmet"),
                        "booking.lastname",equalTo("Bulut"),
                        "booking.totalprice",equalTo("500"),
                        "booking.depositpaid",equalTo(false),
                        "booking.bookingdates.checkin",equalTo("2023-01-10"),
                        "booking.bookingdates.checkout",equalTo("2023-01-20"));

    }
}
