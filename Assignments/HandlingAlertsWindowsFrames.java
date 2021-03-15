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
import org.testng.annotations.AfterClass;

public class HandlingAlertsWindowsFrames {
	WebDriver driver;
	Alert MyAlert;
	
	
	
  @Test
  public void handlingAlert() throws InterruptedException {
	  driver.get("http://selenium-examples.nichethyself.com");
	  WebElement myElement = driver.findElement(By.id("loginname"));
		myElement.sendKeys("stc123");//method chaining.
		driver.findElement(By.name("password")).submit();	  
		Thread.sleep(3000);

		String expectedMessage = "Please enter Password";		
		
		try {
			MyAlert = driver.switchTo().alert();
			String actualMessage = MyAlert.getText();
			assertEquals(actualMessage,expectedMessage,"Actual and expected Message does not match");
			MyAlert.accept();
			
		}catch(NoAlertPresentException e) {
			fail("Seems Developer has forgotten to put alert box. Ha Ha Ha");//Assert
		}
  }
		
		@Test
		public void handlingWindowsPoupups() throws InterruptedException{
			driver.get("http://selenium-examples.nichethyself.com");
		  	String parentWindowHandle = driver.getWindowHandle();
		  	driver.findElement(By.xpath("//button[text()='Contact us!']")).click();
		  	
		  	try { 
		  		driver.switchTo().window("Contact"); //Name of the window given by developer
		  		Thread.sleep(5000);
		  		driver.findElement(By.className("glyphicon-search")).click();
		  		Thread.sleep(3000);
		  		Alert myAlert;
		  		try {
		  			myAlert = driver.switchTo().alert();
		  			myAlert.sendKeys("London");
		  			Thread.sleep(3000);
		  			myAlert.accept();	  			
		  		}catch (NoAlertPresentException e) {
		  			fail("No alert");
		  		}
		  	}catch (NoSuchWindowException e) {
		  		fail("There was a contact us Window Expected");
		  	}
		  	driver.close();
			driver.switchTo().window(parentWindowHandle);
		  	
	  
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
	  
		//System.setProperty("webdriver.gecko.driver", "test\\DriverResource\\geckodriver.exe");
		//driver =new FirefoxDriver();
//System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver_64bits.exe");
//driver = new ChromeDriver();//Opens the browser - represents one browser window		
//driver = new FirefoxDriver();
driver.manage().window().maximize();
//Implicit Wait in Selenium
//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
//Whenever you are calling findElement method and if the element is not found
//Selenium will NOT throw NoSuchElementException
//It will wait for the element to appear.
//How much time? 500 ms (polling 
//After 500ms it will again check if the element is found, if not 
//wait again 500ms
// till it reaches total of 10 second
//if element is not found even after 10 seconds then NoSuchElementException will be thrown



  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
