package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;

public class EventFiringTest {
	
	private WebDriver Driver;
	EventFiringWebDriver eventDriver;
	MyListener myListener;
	
  @Test
  public void f() {
	  eventDriver.get("https://www.google.com");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "test\\DriverResource\\chromedriver.exe");
	  Driver =new ChromeDriver();
	  eventDriver =new EventFiringWebDriver(Driver);
	  myListener=new MyListener();
	  eventDriver.unregister(myListener);
	  eventDriver.register(myListener);
	  
	  
	  
  }

  @AfterMethod
  public void afterMethod() {
  }

}
