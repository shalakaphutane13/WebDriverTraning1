package srviceNow;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class PisaDev {
	WebDriver driver;
	WebDriverWait wait;
	DesiredCapabilities capabilities = new DesiredCapabilities();
	ChromeOptions chrome1=new ChromeOptions();
	
  @Test
  public void f() throws InterruptedException {
	  driver.get("https://pisadev.myatos.net");
  
 driver.findElement(By.xpath("//input[@type='submit']")).click();
 driver.switchTo().window("Chrome_WidgetWin_1").manage();

 Thread.sleep(1000);
 //chrome1.setAcceptInsecureCerts(true);
 
 //Alert alert=driver.switchTo().alert();
 //alert.accept();
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
	wait = new WebDriverWait(driver,10,2000);
	driver.manage().timeouts().pageLoadTimeout(240, TimeUnit.SECONDS);
	
  }

  @AfterClass
  public void afterClass() {
	
  }

}
