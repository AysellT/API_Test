import org.json.JSONObject;
import org.junit.Test;

public class C16_Put_SoftAssertIleExpectedDataTesti {

    @Test
    public void test(){

        /*
        http://dummy.restapiexample.com/api/v1/update/21 url’ine asagidaki body’ye sahip bir PUT request gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.

            Request Body
            {
               "status": "success",
               "data": {
                    "name": “Ahmet",
                    "salary": "1230",
                    "age": "44",
                    "id": 40
                       }
            }

            Response Body
            {
               "status": "success",
               "data": {
                   "status": "success",
                   "data":  {
                       "name": “Ahmet",
                       "salary": "1230",
                       "age": "44",
                       "id": 40
                            }
                        },
            "message": "Successfully! Record has been updated."
            }

         */

        //1-request ve endpoint olustur
        String url = "http://dummy.restapiexample.com/api/v1/update/21";

        JSONObject requestBody = new JSONObject();
        JSONObject innerBodyData = new JSONObject();

        innerBodyData.put("name", "Ahmet");
        innerBodyData.put("salary","1230");
        innerBodyData.put("age","44");
        innerBodyData.put("id",40);

        requestBody.put("status", "success");
        requestBody.put("data", innerBodyData);

        //2-expected data olustur
        JSONObject expectedBody = new JSONObject();
        expectedBody.put("status","success");
        expectedBody.put("data",requestBody);
        expectedBody.put("message","Successfully! Record has been updated.");


        //3-request gonder response'i kaydet

        //4-Assertion

    }
}
