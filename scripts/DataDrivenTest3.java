package scripts;

import org.testng.annotations.Test;

import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.testng.annotations.BeforeMethod;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class DataDrivenTest3 {
	WebDriver driver;
  @Test(dataProvider = "LoginData")
  public void loginTest(String user, String pass) {
		driver.findElement(By.id("loginname")).sendKeys(user);
		driver.findElement(By.id("loginpassword")).sendKeys(pass);
		driver.findElement(By.id("loginbutton")).click();
  }
    
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "test\\DriverResource\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.get("http://selenium-examples.nichethyself.com");
  }

  @AfterMethod
  public void afterMethod() {
  }

@DataProvider (name="loginData")
public Object[][] readDataFromExternalSource()
{
	Object[][] retObjArr=getTableArray("/webdrivertraining1/test/DriverResource", "LoginData", "DataBoundry");
	return retObjArr;
	
}

public String[][] getTableArray(String path, String Sheet1, String TableName)
{
	String[][] tabArray=null;
	try {
		Workbook workbook1=Workbook.getWorkbook(new File(path));
		Sheet sheet1=workbook1.getSheet(Sheet1);
		Cell tableStart=sheet1.findCell(TableName);
		
		int startCol, startRow, EndCol, EndRow, ci, cj;
		startRow=tableStart.getRow();
		startCol=tableStart.getColumn();
		
		//Cell tableEnd=sheet1.findCell(TableName, startCol+1, +1,startRow+1,100,64000,false);
		Cell tableEnd=sheet1.findCell(TableName);
		EndRow=tableEnd.getRow();
		EndCol=tableEnd.getColumn();
		System.out.println("startRow="+startRow+", EndRow ="+EndRow+", startColumn="+startCol+", EndCol= "+EndCol);
		
		tabArray=new String[EndRow-startRow-1][EndCol-startCol-1];
		ci=0;
		for(int i=startRow+1; i<EndRow;i++,ci++) {
			cj=0;
		for(int j=startCol+1; j<EndCol;j++,cj++) {
			tabArray[ci][cj]=sheet1.getCell(j,i).getContents();	
			
		}	
		}
				
	}
	catch(Exception e)
	{
		System.out.println("Please check if file path, sheet name and tag name are correct");
	}
	
	return(tabArray);
}

	
public static Collection<String[]> getTestData(String fileName) throws IOException
{
	List<String[]> records = new ArrayList<String[]>();
	String record;
	BufferedReader file = new BufferedReader(new FileReader(fileName));
	while ((record=file.readLine())!=null) {
		String fields[] = record.split(",");
		records.add(fields);
	}
	file.close();
	return records;
	
}




}




