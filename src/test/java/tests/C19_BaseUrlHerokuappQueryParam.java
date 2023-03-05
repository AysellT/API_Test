package tests;

import baseUrl.BaseUrlHerokuapp;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C19_BaseUrlHerokuappQueryParam extends BaseUrlHerokuapp {

    /*
    Class icinde 2 Test metodu olusturun ve asagidaki testleri yapin

    1- https://restful-booker.herokuapp.com/booking endpointine gerekli Query parametrelerini yazarak
    “firstname” degeri “Susan” olan rezervasyon oldugunu test edecek bir GET request gonderdigimizde,
    donen response’un status code’unun 200 oldugunu ve “Susan” ismine sahip en az 2 booking oldugunu test edin

    2- https://restful-booker.herokuapp.com/booking endpointine gerekli Query parametrelerini yazarak
    “firstname” degeri “Jim” ve “lastname” degeri “Jackson” olan rezervasyon oldugunu test edecek bir GET request gonderdigimizde,
    donen response’un status code’unun 200 oldugunu ve “Jim Jackson” ismine sahip en az bir booking oldugunu test edin

     */

    @Test
    public void test01(){

        //1- https://restful-booker.herokuapp.com/booking endpointine gerekli Query parametrelerini yazarak
        //    “firstname” degeri “Eric” olan rezervasyon oldugunu test edecek bir GET request gonderdigimizde,
        //    donen response’un status code’unun 200 oldugunu ve “Eric” ismine sahip en az bir booking oldugunu test edin

        //1-request ve endpoint olustur
        specHerokuapp.pathParam("pp1","booking").queryParams("firstname","Susan");

        //2-expected data olustur

        //3-request gonder response'i kaydet
        Response response = given()
                                   .when().spec(specHerokuapp)
                                   .get("/{pp1}");

        //4-Assertion
        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("bookingid", Matchers.hasSize(3));
    }

    @Test
    public void test02(){

        // 2- https://restful-booker.herokuapp.com/booking endpointine gerekli Query parametrelerini yazarak
        //    “firstname” degeri “Jim” ve “lastname” degeri “Jackson” olan rezervasyon oldugunu test edecek bir GET request gonderdigimizde,
        //    donen response’un status code’unun 200 oldugunu ve “Jim Jackson” ismine sahip en az bir booking oldugunu test edin

        //1-request ve endpoint olustur
        specHerokuapp.pathParam("pp1","booking").queryParams("firstname","Susan","lastname","Jones");

        //2-expected data olustur

        //3-request gonder response'i kaydet
        Response response = given()
                                  .when().spec(specHerokuapp)
                                  .get("/{pp1}");
        //response.prettyPrint();

        //4-Assertion
        response.then()
                .assertThat()
                .statusCode(200)
                .body("bookingid",Matchers.hasSize(1));

    }
}
