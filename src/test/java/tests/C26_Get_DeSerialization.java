package tests;

import baseUrl.BaseUrlDummy;
import org.junit.Test;
import testData.TestDataDummy;

import java.util.HashMap;
import java.util.Map;

public class C26_Get_DeSerialization extends BaseUrlDummy {

    @Test
    public void test(){

        /*
        http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request gonderdigimizde
        donen response’un status code’unun 200, content Type’inin application/json ve body’sinin
        asagidaki gibi oldugunu test edin.

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
        Map<String,Object> expectedData = TestDataDummy.bodyOlusturMap();


        //3-request gonder response'i kaydet

        //4-Assertion



    }
}
