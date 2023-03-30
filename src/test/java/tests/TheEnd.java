package tests;

public class TheEnd {
    /*
        https://api.openweathermap.org/data/2.5/weather?q=London&a ppid=f4ffe3b2ef1fcb3600ab1d7fbc88c2f0 url’ine
        bir post request gonderdigimizde donen response’un asagidaki body’ye sahip oldugunu test ediniz

        {
           "coord": {
                "lon": -0.1257,
                "lat": 51.5085
           },
           "weather": [
              {
                "id": 803,
                "main": "Clouds"
                "description": "broken clouds"
                "icon": "04d"
           }
           ],
           "base": "stations"
           "main": {
                  "temp": 279.13,
                  "feels like": 275.22,
                  "temp_min": 277.57,
                  "temp_max": 280.03,
                  "pressure": 1023,
                  "humidity": 82
           },
           "visibility": 10000,
           "wind": {
                  "speed": 6.17,
                  "deg": 250
           },
           "clouds": {
                  "all": 56
           },
           "dt": 1675241066,
           "sys": {
                  "type": 2,
                  "id": 2075535,
                  "country": "GB"
                  "sunrise": 1675237170,
                  "sunset": 1675270107
           },
           "timezone": 0,
           "id": 2643743,
           "name": "London"
           "cod": 200
           }
     */

    String url = "https://api.openweathermap.org/data/2.5/weather?q=London&a ppid=f4ffe3b2ef1fcb3600ab1d7fbc88c2f0";


}
