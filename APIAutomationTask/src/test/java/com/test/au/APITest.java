package com.test.au;

import static com.jayway.restassured.RestAssured.get;
import org.testng.annotations.Test;
import com.jayway.restassured.response.Response;

public class APITest extends APITestHelper {
	
		public static Response response;
		public static String lat="40.730610";public static String lon="-73.935242"; public static String pcode="28456"; 
		
		public static String baseURI="https://api.weatherbit.io/v2.0/current?";
	 	public static String basePath1= "lat=" + lat + "&lon=" + lon;
	 	public static String basePath2= "postal_code=" + pcode;
	 	public static String masterKeyUrl="&key=927d413841fd4583ac96665d49a2728f";

	 	
    @Test
	public void testGET_Postcode_for_latlon()
	{
		 response= get(baseURI+basePath1+masterKeyUrl).
        		 then().                   
                 extract().response(); // extract the response
         validateResponseforPostCode(response.jsonPath(),response.asString());
                  
	}
    
    @Test
	public void testGET_weather_for_postcode()
	{
		 response= get(baseURI+basePath2+masterKeyUrl).
        		 then().                   
                 extract().response(); // extract the response
         validateResponseforWeather(response.jsonPath(),response.asString());
                  
	}
    
}
