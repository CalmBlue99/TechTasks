package com.test.au;


import java.io.IOException;
import java.util.Map;



import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.poi.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class TestUIflow extends UIAutomationTaskHelper {
	
	 static final String destinationUrl = "https://www.service.nsw.gov.au/"; static final String titleToBeChecked = "Apply for a number plate";
	 static final String excelLoc = System.getProperty("user.dir")+"/src/test/resources/TestData.xlsx";	 static final String chromeDriverLoc = System.getProperty("user.dir")+"/src/test/resources/chromedriver.exe";
	 static WebDriver driver;
	 
	//Configure browser launch configuration[ IE, Headless , Grid ]
	 static final String browserConfig ="Chrome"; 
	 
	 /**
	     * This  method used to fetch testdata from excel file and return as Hashmap object     *
	  */
	     
	 @DataProvider(name = "myData")
	  public Object[][] dataSupplier() throws IOException, EncryptedDocumentException, InvalidFormatException {
		 
		 Object[][] obj = getExcelData(excelLoc);return  obj;
	  }

			
	/**
     * This  method used to initiate browser with URL read from property file     *
     */
    
    @BeforeMethod
    public void setup()
    {   	
     switch (browserConfig)
     {     
	     case "Chrome":
	    	 System.setProperty("webdriver.chrome.driver",chromeDriverLoc);        
	     	 driver=new ChromeDriver();    
	     	 driver.navigate().to(destinationUrl);
	         driver.manage().window().maximize();
	     
	     case "Headless":
	    	 // code for PhantomJS or other headless driver
	     
	     case "Grid":
	    	 // code for Selenium Grid
	    	 
     }           	          
    }
    
    /**
     * This  method closes all browsers after test     *
     */
    @AfterMethod   
    public void afterTest () {   	
    	driver.quit();          
    }
	
    @Test(dataProvider="myData")
	 public void testUIAutomationFlow(Map<Object, Object> map)throws InterruptedException {  
	 
    	FindServiceCenterLocationPageObject objNavigatetoSpecificServiceCenter = new FindServiceCenterLocationPageObject(driver);
    	ApplyForNumberPlatePageObject objApplyforNumberPlatePageNavigation= new ApplyForNumberPlatePageObject(driver);
    	
        objApplyforNumberPlatePageNavigation.navigateToApplyforaNumberPlatePage();
        assertPageTitle(titleToBeChecked,driver);
        
        objNavigatetoSpecificServiceCenter.navigateToSpecificServiceCentre(map.get("ServiceCentrePostCode").toString(),map.get("Service CentreName").toString());        
        assertPageTitle(map.get("Service CentreName").toString(),driver);
  }  

}
