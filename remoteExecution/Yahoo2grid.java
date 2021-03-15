package remoteExecution;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.fail;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class Yahoo2grid {
	RemoteWebDriver driver;
	WebDriverWait wait;
  @Test
  public void Testgrid() throws MalformedURLException{
	    driver.get("https://www.google.com");
	  
  }
  @BeforeMethod
  public void beforeMethod() throws MalformedURLException {
	  DesiredCapabilities caps = new DesiredCapabilities();
		caps.setBrowserName("chrome");
	 	driver = new RemoteWebDriver(new URL("http://192.168.0.108:4444/wd/hub"), caps);//Opens the browser - represents one browser window

	  
	  
  }

  @AfterMethod
  public void afterMethod() {
	
	  
  }

  @BeforeClass
  public void beforeClass() {
	  
		
  
  }

  @AfterClass
  public void afterClass() {
  }

}
