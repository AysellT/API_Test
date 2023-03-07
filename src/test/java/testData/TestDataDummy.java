package testData;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TestDataDummy {

    public static int basariliStatusCode = 200;
    public static String contentType = "application/json";

    public static JSONObject jsonResponseBodyOlustur(int id,
                                                     String employee_name,
                                                     int employee_salary,
                                                     int employee_age,
                                                     String profile_image) {

        JSONObject responseBody = new JSONObject();

        JSONObject dataBodyInner = new JSONObject();
        dataBodyInner.put("id", id);
        dataBodyInner.put("employee_name", employee_name);
        dataBodyInner.put("employee_salary", employee_salary);
        dataBodyInner.put("employee_age", employee_age);
        dataBodyInner.put("profile_image", profile_image);

        responseBody.put("status", "success");
        responseBody.put("data", dataBodyInner);
        responseBody.put("message", "Successfully! Record has been fetched.");

        return responseBody;
    }

    /*
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
    public static Map<String,Object> bodyOlusturMap() {

        Map<String, Object> bodyMap = new HashMap<>();
        Map<String, Object> innerDataMap = new HashMap<>();

        innerDataMap.put("id", 3.0);
        innerDataMap.put("employee_name", "Ashton Cox");
        innerDataMap.put("employee_salary", 86000.0);
        innerDataMap.put("employee_age", 66.0);
        innerDataMap.put("profile_image", "");

        bodyMap.put("status", "success");
        bodyMap.put("data", innerDataMap);
        bodyMap.put("message", "Successfully! Record has been fetched.");

        return bodyMap;

    }

}
