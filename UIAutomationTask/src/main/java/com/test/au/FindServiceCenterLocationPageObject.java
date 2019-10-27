package com.test.au;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
* <h1>Apply for Number Plate Navigation Page</h1>
* 
* This is page factory Class for Navigating to Apply for Number plate functionality
* 
* @author  Arun Ramakrishnan
* @version 1.0
* @since   02-09-2019 
*/


public class FindServiceCenterLocationPageObject {
	
	WebDriver driver;WebDriverWait wait; 
	    
    @FindBy(linkText="Find locations")
    WebElement Find_Locations_Link;
    
    @FindBy(id="locatorTextSearch")
    WebElement Find_Location_Search_TextBox;
        
    @FindBy(css=".button--xxlarge > svg")
    WebElement Find_Location_Search_Button;
    
    
    public FindServiceCenterLocationPageObject(WebDriver driver)
    {    	 
        this.driver = driver;
        PageFactory.initElements(driver, this);  
        wait = new WebDriverWait(driver,30);
    }
    
    public void navigateToSpecificServiceCentre(String serviceCentrePostCode,String serviceCentreName) throws InterruptedException
    {    	
    	Find_Locations_Link.click();    	
    	wait.until(ExpectedConditions.visibilityOf(Find_Location_Search_TextBox));
    	Find_Location_Search_TextBox.sendKeys(serviceCentrePostCode);    	
    	Find_Location_Search_Button.click();    	
    	specific_Service_Center_Link_click(serviceCentreName);    	
    }
    
    public void specific_Service_Center_Link_click(String linkText)
    {
    	wait.until(ExpectedConditions.elementToBeClickable(By.linkText(linkText)));
    	this.driver.findElement(By.linkText(linkText)).click();
    
    }
   

}
