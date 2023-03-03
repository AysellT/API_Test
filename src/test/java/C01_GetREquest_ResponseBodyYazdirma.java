import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class C01_GetREquest_ResponseBodyYazdirma {

    @Test
    public void test(){
            /*
            https://restful-booker.herokuapp.com/booking/10 url’ine
            bir GET request gonderdigimizde donen Response’u yazdirin.
             */

        // 1- Request body ve end-point hazirla
        String url = "https://restful-booker.herokuapp.com/booking/10";

        // 2- Expected data hazirla
        // get sorgusunda expected data olmaz

        // 3- Request gonderip , donen response'i kaydet
        Response response = given().when().get(url);
        response.prettyPrint();

        // 4- Assertion

    }

}
