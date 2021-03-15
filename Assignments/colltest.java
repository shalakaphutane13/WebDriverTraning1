package Assignments;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

public class colltest {
	WebDriver driver;
	Alert MyAlert;
	WebDriverWait wait;
	
	
  @Test
  public void homePage() throws InterruptedException {
	  driver.get("https://money.rediff.com/index.html");
	 /* List<WebElement> webe=driver.findElements(By.xpath("//*[text()='NIFTY 500']/parent::li/parent::ul"));
	  
		  // String s=webe.toString();
		   System.out.println("value is "+webe.get(0));*/
	  
	  
	  Set<String> urllist=new HashSet<String>();
	  
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
