package tests;


import baseUrl.BaseUrlJsonPlaceHolder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.PojoJsonPlaceHolder;
import testData.TestDataJsonPlaceHolder;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C28_Put_PojoClass extends BaseUrlJsonPlaceHolder {
    /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body’e sahip bir PUT request yolladigimizda
    donen response’in response'in
    status kodunun 200,
    content type'inin "application/json; charset=utf-8",
    Connection header degerinin "keep-alive"
    ve response body’sinin asagida verilen ile ayni oldugunu test ediniz

    Request Body Expected Data :
     {
        "title": "Ahmet",
        "body": "Merhaba",
        "userId": 10,
        "id": 70
     }

     Response body :
     {
        "title": "Ahmet",
        "body": "Merhaba",
        "userId": 10,
        "id": 70
     }

     */

    @Test
    public void test9(){

        //1-request ve endpoint olustur
        specJsonPlaceHolder.pathParams("pp1","posts","pp2","70");

        PojoJsonPlaceHolder requestBodyPojo = new PojoJsonPlaceHolder("Ahmet","Merhaba",10,70);

        //2-expected data olustur
        PojoJsonPlaceHolder expectedDataPojo = new PojoJsonPlaceHolder("Ahmet","Merhaba",10,70);

        //3-request gonder response'i kaydet
        Response response = given().spec(specJsonPlaceHolder).contentType(ContentType.JSON)
                            .when().body(requestBodyPojo)
                            .put("{pp1}/{pp2}");

        PojoJsonPlaceHolder responsePojo = response.as(PojoJsonPlaceHolder.class);

        //4-Assertion
        // expected data (Pojo) <====> response (Pojo)
        //  expectedDataPojo    <====>  responsePojo

        assertEquals(TestDataJsonPlaceHolder.basariliStatusCode,response.statusCode());
        assertEquals(TestDataJsonPlaceHolder.contentType,response.contentType());
        assertEquals(TestDataJsonPlaceHolder.headerConnection,response.header("Connection"));

        assertEquals(expectedDataPojo.getTitle(),responsePojo.getTitle());
        assertEquals(expectedDataPojo.getBody(),responsePojo.getBody());
        assertEquals(expectedDataPojo.getUserId(),responsePojo.getUserId());
        assertEquals(expectedDataPojo.getId(),responsePojo.getId());

    }
}
