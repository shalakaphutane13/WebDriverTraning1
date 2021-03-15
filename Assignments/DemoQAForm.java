package Assignments;

import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class DemoQAForm {
	WebDriver driver;
	WebDriverWait wait;
	Logger logs;
	
  @Test (dataProvider = "LoginData")
  public void UserDetails(String name, String lastName, String email, String Mnumber, String address) throws InterruptedException {
	  driver.get("http://demoqa.com/automation-practice-form/");
	 
	  System.out.println("Title is "+driver.getTitle());
	  driver.findElement(By.id("firstName")).sendKeys(name);
	  driver.findElement(By.id("lastName")).sendKeys(lastName);
	  driver.findElement(By.id("userEmail")).sendKeys(email);
	  //logs.info(email);
	  
	/* WebElement radio=driver.findElement(By.id("gender-radio-2"));
	  wait.until(ExpectedConditions.elementToBeClickable(radio));
	  radio.click(); */
	  driver.findElement(By.xpath("//label[@for='gender-radio-2']")).click();;
	  driver.findElement(By.id("userNumber")).sendKeys(Mnumber);
	  Thread.sleep(1000);
	  //driver.findElement(By.xpath("//div[@id='subjectsContainer']/div/div")).sendKeys("abcdefghijklmn");
	  driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']")).click();
	  driver.findElement(By.xpath("//label[@for='hobbies-checkbox-2']")).click();
	  driver.findElement(By.xpath("//label[@for='hobbies-checkbox-3']")).click();
	  driver.findElement(By.id("currentAddress")).sendKeys(address);
	  //driver.findElement(By.xpath("//input[@id='uploadPicture']")).sendKeys("‪C:\\Users\\A579096\\Pictures\\logo.PNG");
	  
	  //sendKeys("‪C:\\Users\\A579096\\Pictures\\logo.PNG");
	  //driver.findElement(By.xpath("//div[@id='state']/div/div[1]/div[1]")).click();
	 
	  
	  
	  driver.findElement(By.id("submit")).click();
	 //driver.switchTo().alert();
	 driver.findElement(By.xpath("//button[@id='closeLargeModal']")).click();
	  //WebElement state=driver.findElement(By.xpath("//div[@id=\"state\"]/div"));
	 // state.click();
	 //Select dropdown=new Select(state);
	 //dropdown.selectByValue("NCR");
  }
	  @DataProvider (name = "LoginData")
	  public Object[][] readDataFromExternalSource() {
	      Object[][] retObjArr=getTableArray("test/Assignments/FormDetails.xls", "FormDetails", "DataBoundry");
	      Object[][] retObjArr1=getTableArray(null, null, null);
	      return retObjArr;
	  }
	  
	  public String[][] getTableArray(String xlFilePath, String sheetName, String tableName){
	      String[][] tabArray=null;
	      try{
	          Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
	          //Workbook class is provied by jxl.jar
	          //WebDriver provided by Selenium 
	          //File is class provided by Java to read a physical file
	          Sheet sheet = workbook.getSheet(sheetName);
	          Cell tableStart=sheet.findCell(tableName);
	          
	          int startRow,startCol, endRow, endCol,ci,cj;
	          
	          startRow=tableStart.getRow();//2
	          startCol=tableStart.getColumn();//1

	          Cell tableEnd= sheet.findCell(tableName, startCol+1,startRow+1, 100, 64000,  false);                
	          //Cell tableEnd= sheet.findCell(tableName);
	          endRow=tableEnd.getRow();//7
	          endCol=tableEnd.getColumn();//4
	          System.out.println("startRow="+startRow+", endRow="+endRow+", " +
	                  "startCol="+startCol+", endCol="+endCol);
	          tabArray=new String[endRow-startRow-1][endCol-startCol-1];//4,2
	          ci=0; //array row
	          //ci=0,i=3, j=3,cj=1
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
			// FileReader is meant for reading streams of characters(reading text files)
			// FileReader myReader = new FileReader(fileName);
			// A BufferedReader object takes a FileReader object as 
			// an input which contains all the necessary information 
			// about the text file that needs to be read.
			BufferedReader file = new BufferedReader(new FileReader(fileName));
			while ((record=file.readLine())!=null) {//record = "stc123,12345"
			 	String fields[] = record.split(",");//split() method is inside String class
				records.add(fields);
			}
			file.close();
			return records;
		}
	
	  
	  
	  
	  
	  
	  
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void beforeClass() {
	System.setProperty("webdriver.chrome.driver", "test\\DriverResource\\chromedriver.exe");
	driver =new ChromeDriver();
	driver.manage().window().maximize();
	wait = new WebDriverWait(driver,30,2000);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  }

  @AfterClass
  public void afterClass() {
  }

}
