package tests;

import org.json.JSONObject;
import org.junit.Test;

public class C04_JsonObjectOlusturma {

    @Test
    public void test(){

        /*
        Asagidaki JSON Objesini olusturup konsolda yazdirin.
         {
             "title":"Ahmet",
             "body":"Merhaba",
             "userId":1
         }
         */

        JSONObject obj1 = new JSONObject();
        obj1.put("title","Ahmet");
        obj1.put("body","Merhaba");
        obj1.put("userId",1);

        System.out.println(obj1);


        //1-request ve endpoint olustur

        //2-expected data olustur

        //3-request gonder response'i kaydet

        //4-Assertion
    }

}
