package com.test.au;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.jayway.restassured.path.json.JsonPath;


public class APITestHelper {	
	
	static final Logger logger = Logger.getLogger(APITestHelper.class);
	
	
	public void validateResponseforPostCode(JsonPath jsonPathEvaluator,String response)
	{		
		printConsole("Response Recieved from API -----> " + response);
		printConsole("State Code from Response :" +jsonPathEvaluator.getString("data.state_code"));
	}
	
	public void validateResponseforWeather(JsonPath jsonPathEvaluator,String response)
	{		
		printConsole("Response Recieved from API -----> " + response);
		printConsole("Time Stamp from Response :" +jsonPathEvaluator.getString("data.datetime"));
		printConsole("Weather code from Response :" +jsonPathEvaluator.getString("data.weather.code"));
		printConsole("Weather Description Response :" +jsonPathEvaluator.getString("data.weather.description"));
	}
	
	public void printConsole(String msg)
	{		
		BasicConfigurator.configure();
		logger.getRootLogger().setLevel(Level.INFO);
		logger.info(msg);
	}
}
