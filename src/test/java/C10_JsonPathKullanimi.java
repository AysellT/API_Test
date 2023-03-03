import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C10_JsonPathKullanimi {

    @Test
    public void test(){

        JSONObject kisiBilgileriJsonObj = new JSONObject();

        JSONObject addressJsonObj = new JSONObject();
        addressJsonObj.put("streetAddress", "naist street");
        addressJsonObj.put("city","Nara");
        addressJsonObj.put("postalCode","0123-4567-8888");

        JSONArray telefonBilgilariArr = new JSONArray();

        JSONObject cepTelJsonObj = new JSONObject();
        cepTelJsonObj.put("type","iphone");
        cepTelJsonObj.put("number","05401234567");

        JSONObject evTelJsonObj = new JSONObject();
        evTelJsonObj.put("type","Ev telefonu");
        evTelJsonObj.put("number","01234567");

        telefonBilgilariArr.put(cepTelJsonObj);
        telefonBilgilariArr.put(evTelJsonObj);

        kisiBilgileriJsonObj.put("firstName","John");
        kisiBilgileriJsonObj.put("lastName","Doe");
        kisiBilgileriJsonObj.put("age",49);
        kisiBilgileriJsonObj.put("address",addressJsonObj);
        kisiBilgileriJsonObj.put("phoneNumbers",telefonBilgilariArr);


        System.out.println("firstname : " + kisiBilgileriJsonObj.get("firstName"));
        System.out.println("lastname : " + kisiBilgileriJsonObj.get("lastName"));

        System.out.println("cadde : "+ kisiBilgileriJsonObj.getJSONObject("address").get("streetAddress"));

        System.out.println(kisiBilgileriJsonObj.getJSONObject("address").get("city"));

        System.out.println("cepTelNo: "+ kisiBilgileriJsonObj.getJSONArray("phoneNumbers").getJSONObject(0).get("number"));


    }
}
