package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class BrowserMethod {
	WebDriver driver;
  @Test
  public void LearningWebDriverMethos() {
	  driver.get("https://www.google.com");
	  driver.getTitle();
	  List<WebElement> AllLinks=driver.findElements(By.tagName("a"));
	  
	  for(int i=0;i<AllLinks.size();i++)
	  {
		  System.out.println(AllLinks.get(i).getText()+"-"+AllLinks.get(i).getAttribute("href"));
	  }
	  for(WebElement oneLink : AllLinks)
	  {
		  
		  System.out.println(oneLink.getText()+"-"+oneLink.getAttribute("href"));
	  }
	  
	  
  }
  
  
  @BeforeClass
  public void BeforeClass()
  {
	System.setProperty("webdriver.chrome.driver", "test\\DriverResource\\chromedriver.exe");
	driver =new ChromeDriver();
	driver.manage().window().maximize();
	  
  }
  

  @AfterClass
  public void AfterClass()
  {
	  
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

}
