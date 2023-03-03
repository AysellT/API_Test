import org.json.JSONObject;
import org.junit.Test;

public class C05_JsonObjectOlusturma {

    @Test
    public void test(){

        /*
        Asagidaki JSON Objesini olusturup konsolda yazdirin.
        {
        "firstname":"Jim",
        "additionalneeds":"Breakfast",
        "bookingdates":{
                "checkin":"2018-01-01",
                "checkout":"2019-01-01"
                       },
        "totalprice":111,
        "depositpaid":true,
        "lastname":"Brown" }
         */

        JSONObject innerJson = new JSONObject();
        innerJson.put("checkin","2018-01-01");
        innerJson.put("checkout","2019-01-01");

        JSONObject requestBody = new JSONObject();
        requestBody.put("firstname","Jim");
        requestBody.put("additionalneeds","Breakfast");
        requestBody.put("bookingdates",innerJson);
        requestBody.put("totalprice",111);
        requestBody.put("depositpaid",true);
        requestBody.put("lastname","Brown");

        System.out.println(requestBody);

    }
}
