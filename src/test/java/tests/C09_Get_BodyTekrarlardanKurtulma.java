package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;



public class C09_Get_BodyTekrarlardanKurtulma {

    @Test
    public void test(){

        /*
        https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request gonderdigimizde donen Response’un,
         status code’unun 200,
         ve content type’inin application-json,
         ve response body’sindeki
             "firstname“in, "Sally",
             ve "lastname“in, "Jackson",
             ve "totalprice“in 1000'den kucuk,
             ve "depositpaid“in, true
         oldugunu test edin
         */


        //1-request ve endpoint olustur
        String url = "https://restful-booker.herokuapp.com/booking/10";

        //2-expected data olustur

        //3-request gonder response'i kaydet
        Response response = given().when().get(url);

        //4-Assertion
        /*ikinci yontemle yazildiginda etkilenmemek icin yoruma aldim
        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname", Matchers.equalTo("Susan"))
                .body("lastname", Matchers.equalTo("Ericsson"))
                .body("totalprice", Matchers.lessThan(1000))
                .body("depositpaid", Matchers.equalTo(false));
         */

        response.then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname",equalTo("Susan"),
                        "lastname", equalTo("Ericsson"),
                        "totalprice", lessThan(1000),
                        "depositpaid", equalTo(false));

    }
}
