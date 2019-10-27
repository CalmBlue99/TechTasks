package com.test.au;

import static org.testng.AssertJUnit.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

public class UIAutomationTaskHelper {
	
	WebDriver driver;
	
	/**
     * This reusable method is used to read excel data from given sheet. 
     * @param excelLoc This is the path of excel file
     * 
	 * @throws IOException 
	 * @throws InvalidFormatException 
	 * @throws EncryptedDocumentException 
     * 
     */
	
	public Object[][] getExcelData(String excelLoc) throws EncryptedDocumentException, InvalidFormatException, IOException {
		
		InputStream inputStream = null;
		 
		inputStream = new FileInputStream(new File(excelLoc));
		Workbook wb = WorkbookFactory.create(inputStream);
		Sheet sheet = wb.getSheetAt(0);
		 int lastRowNum = sheet.getLastRowNum() ;
		    int lastCellNum = sheet.getRow(0).getLastCellNum();
		    Object[][] obj = new Object[lastRowNum][1];

		    for (int i = 0; i < lastRowNum; i++) {
		      Map<Object, Object> datamap = new HashMap<Object, Object>();
		      for (int j = 0; j < lastCellNum; j++) {
		        datamap.put(sheet.getRow(0).getCell(j).toString(), sheet.getRow(i+1).getCell(j).toString());
		      }
		      obj[i][0] = datamap;

		    }
		    return  obj;
		  }

		
  public void assertPageTitle(String PageTitle,WebDriver driver)
  {
	  assertTrue(driver.getTitle().contains(PageTitle));
  }

}
