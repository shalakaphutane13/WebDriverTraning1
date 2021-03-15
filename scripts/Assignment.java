package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Assignment {
	WebDriver driver;

	
  @Test
  public void navigators() {
	  driver.get("https://www.google.com");
	  driver.navigate().back();
	  driver.navigate().forward();
	  driver.navigate().refresh();
	 
	  System.out.println("current URL is "+driver.getCurrentUrl());
	  
	  //System.out.println("Page Sorce of google page is aaaaaaaaaaaaaaaa "+ driver.getPageSource());
	  
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
  }

  @AfterClass
  public void afterClass() {
  }

}
