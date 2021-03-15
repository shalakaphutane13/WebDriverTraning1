package scripts;

import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.testng.annotations.BeforeMethod;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

public class LoginWithDDT {
	WebDriver driver;
	WebDriverWait wait;
	
	
  @Test(dataProvider = "loginData")
  public void login(String user, String pass) {
	        driver.get("http://selenium-examples.nichethyself.com");
			driver.findElement(By.id("loginname")).sendKeys(user);
			driver.findElement(By.id("loginpassword")).sendKeys(pass);
			driver.findElement(By.id("loginbutton")).click();
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
	  
  }

  @BeforeClass
  public void beforeClass() 
  {
	  
	  System.setProperty("webdriver.chrome.driver", "test\\DriverResource\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver,10,2000);
	  
	  
  }
  @AfterClass
  public void afterClass() {
  }
  

  @DataProvider(name="loginData")
  public Object[][] readDataFromExternalSource() {
    Object[][] ObjArray = getTableArray("test\\DriverResource\\loginxls.xls","LoginData","DataBoundry");
	  return ObjArray;
  }
public String[][] getTableArray(String xlfilePath, String sheetName, String tableName) {
	String [][] tabArray =null;
	try {
		
		Workbook wb=Workbook.getWorkbook(new File(xlfilePath));
		Sheet sheet = wb.getSheet(sheetName);
        Cell tableStart=sheet.findCell(tableName);
        int startRow,startCol, endRow, endCol,ci,cj;
        
        startRow=tableStart.getRow();//2
        startCol=tableStart.getColumn();//1

        Cell tableEnd1= sheet.findCell(tableName);                
// Cell tableEnd= sheet.findCell(tableName, startCol+1,startRow+1, 100, 64000,  false);
        Cell tableEnd=sheet.findCell(tableName);
        endRow=tableEnd.getRow();//7
        endCol=tableEnd.getColumn();//4
        System.out.println("startRow="+startRow+", endRow="+endRow+", " +
                "startCol="+startCol+", endCol="+endCol);
        tabArray=new String[endRow-startRow-1][endCol-startCol-1];//4,2
        ci=0; //array row

        for (int i=startRow+1;i<endRow;i++,ci++){//i represents xls row
            cj=0;//array column
            for (int j=startCol+1;j<endCol;j++,cj++){//j represents xls column
                tabArray[ci][cj]=sheet.getCell(j,i).getContents();
            }
        }
    }
    catch (Exception e)    {
        System.out.println("Please check if file path, sheet name and tag name are correct");
        
    }

    return(tabArray);
}
public static Collection<String[]> getTestData(String fileName) throws IOException {
	List<String[]> records = new ArrayList<String[]>();
	String record;
	BufferedReader file = new BufferedReader(new FileReader(fileName));
	while ((record=file.readLine())!=null) {//record = "stc123,12345"
	 	String fields[] = record.split(",");//split() method is inside String class
		records.add(fields);
	}
	file.close();
	return records;
}
  
  
  
}
