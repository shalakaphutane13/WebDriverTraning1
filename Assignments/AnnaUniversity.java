package Assignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class AnnaUniversity {
	WebDriver driver;
	Alert MyAlert;
	WebDriverWait wait;
	
	
  @Test
  public void homePage() throws InterruptedException {
	  driver.get("https://www.annauniv.edu/department/index.php");
	  WebElement civil=driver.findElement(By.name("link13"));
	  Actions builder = new Actions(driver);
	  WebElement ocean=driver.findElement(By.xpath("//div[@id='menuItemHilite32']"));
	  builder.moveToElement(civil).click(ocean).perform();
	 Thread.sleep(1000); 
	  
	  String expected="Institute For Ocean Management - Anna University offers M.Tech in Coastal Management. ENVIS Center for Coastal Zone Management and Coastal Shelterbelts";
	  String actual=driver.getTitle();
	  Thread.sleep(1000);
	  assertEquals(expected, actual);
	  WebElement research=driver.findElement(By.name("link2"));
	  WebElement pollution=driver.findElement(By.id("menuItemText13"));
	  Thread.sleep(2000);
	  builder.moveToElement(research).click(pollution).perform();
	  String expected2=":: IOM - Institute For Ocean Management - Anna University ::";
	  String actual2=driver.getTitle();
	  assertEquals(expected2,actual2);
	  
	  
	  
	  
  }
			
  
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void beforeClass() throws InterruptedException  {
	  System.setProperty("webdriver.chrome.driver", "test\\DriverResource\\chromedriver.exe");
     driver =new ChromeDriver();
driver.manage().window().maximize();
wait = new WebDriverWait(driver,10,2000);
driver.manage().timeouts().pageLoadTimeout(240, TimeUnit.SECONDS);



  }

  @AfterClass
  public void afterClass() {
	  //driver.quit();
  }

}
