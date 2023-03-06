package testData;

import org.json.JSONObject;

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
}
