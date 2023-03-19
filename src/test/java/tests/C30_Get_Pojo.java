package tests;

import baseUrl.BaseUrlDummy;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.PojoDummyData;
import pojos.PojoDummyResponse;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C30_Get_Pojo extends BaseUrlDummy {
    /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request gonderdigimizde
    donen response’un asagidaki gibi oldugunu test edin.

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

    @Test
    public void test(){

        //1- Requesr url ve body olustur
        specDummy.pathParams("pp1","employee","pp2","3");

        //2- Soruda varsa expected data olustur
        PojoDummyData dataPojo = new PojoDummyData(3,"Ashton Cox",86000,66,"");
        PojoDummyResponse expectedResponseBody = new PojoDummyResponse("success",dataPojo,"Successfully! Record has been fetched.");

        //3- Response olustur, request gonderip sonucu response'a ata
        Response response = given().spec(specDummy).when().get("{pp1}/{pp2}");
        //response.prettyPrint();
        //System.out.println(expectedResponseBody);
        PojoDummyResponse responsePojo = response.as(PojoDummyResponse.class);

        /*
        PojoDummyResponse{
        status='success',
        data=PojoDummyData{
              id=3,
              employee_name='Ashton Cox',
              employee_salary=86000,
              employee_age=66,
              profile_image=''},
        message='Successfully! Record has been fetched.'}

         */

        //4- Assertion
        assertEquals(expectedResponseBody.getStatus(),responsePojo.getStatus());
        assertEquals(expectedResponseBody.getData().getId(),responsePojo.getData().getId());
        assertEquals(expectedResponseBody.getData().getEmployee_name(),responsePojo.getData().getEmployee_name());
        assertEquals(expectedResponseBody.getData().getEmployee_salary(),responsePojo.getData().getEmployee_salary());
        assertEquals(expectedResponseBody.getData().getEmployee_age(),responsePojo.getData().getEmployee_age());
        assertEquals(expectedResponseBody.getData().getProfile_image(),responsePojo.getData().getProfile_image());
        assertEquals(expectedResponseBody.getMessage(),responsePojo.getMessage());


    }
}
