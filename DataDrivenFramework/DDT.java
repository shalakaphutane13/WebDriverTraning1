package DataDrivenFramework;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class DDT {
	WebDriver driver;
	
	/*
  @Test(dataProvider = "dp")
  public void login(String uname, String pass) {
	 
		driver.findElement(By.id("loginname")).sendKeys("uname");
		driver.findElement(By.id("loginpassword")).sendKeys("pass");
	 
  }
  */
  
  @Test
   public void data() throws IOException {
  FileInputStream fis=new FileInputStream("C:\\Users\\A579096\\Desktop\\Selenium\\LoginDetails.xlsx");
	
	XSSFWorkbook wb=new XSSFWorkbook(fis);
	
XSSFSheet sheet=wb.getSheet("loginSheet");
for(int i=1;i<=sheet.getLastRowNum();i++)
{
	XSSFRow row1=sheet.getRow(i);
	XSSFCell cell1=sheet.getRow(i).getCell(1);
	cell1.setCellType(CellType.STRING);
	
	driver.findElement(By.id("loginname")).sendKeys(cell1.getStringCellValue());
	
	XSSFRow row=sheet.getRow(i);
	XSSFCell cell2=sheet.getRow(i).getCell(2);
	cell2.setCellType(CellType.STRING);
	
	driver.findElement(By.id("loginpassword")).sendKeys(cell2.getStringCellValue());
	
	driver.findElement(By.id("loginbutton")).click();
	
}
  }
	
  
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "test\\DriverResource\\chromedriver.exe");  
	  WebDriver driver=new ChromeDriver();
	  driver.get("http://selenium-examples.nichethyself.com");
	  
  }

  @AfterMethod
  public void afterMethod() {
  }


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
}
