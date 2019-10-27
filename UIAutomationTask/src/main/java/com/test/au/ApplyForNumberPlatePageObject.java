package com.test.au;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
* <h1>Apply for Number Plate Navigation Page</h1>
* 
* This is page factory Class for Navigating to Apply for Number plate functionality
* 
* @author  Arun Ramakrishnan
* @version 1.0
* @since   02-09-2019 
*/


public class ApplyForNumberPlatePageObject {
	
	WebDriver driver;
    
    @FindBy(name="q")
    WebElement Main_Page_Search_TextBox;
    
    @FindBy(xpath="//button[@type='submit']")
    WebElement Main_Page_Search_Button;
        
    @FindBy(linkText="Apply for a number plate")
    WebElement Apply_for_a_number_plate_link;
    
    
    public ApplyForNumberPlatePageObject(WebDriver driver)
    {    	 
        this.driver = driver;
        PageFactory.initElements(driver, this);  
    }
    
    public void navigateToApplyforaNumberPlatePage()
    {
    	Main_Page_Search_TextBox.sendKeys("Apply for a number plate");
    	Main_Page_Search_Button.click();
    	Apply_for_a_number_plate_link.click();
    	
    }
   

}
