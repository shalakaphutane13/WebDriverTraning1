package remoteExecution;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;

public class TestNGYahoo {
	
	WebElementYahoo yahooLogin; 
	RemoteWebDriver driver;
  @Test
  public void yahooLogin() throws InterruptedException {
	  
	  yahooLogin.login("shalaka.phutane@yahoo.com", "Seema$13", "shalakaphutane07@gmail.com", " First automated mail","This is my fist automated email using page object");
	  
  }
  @BeforeMethod
  public void beforeMethod() throws InterruptedException, MalformedURLException {
	  DesiredCapabilities caps = new DesiredCapabilities();
		caps.setBrowserName("chrome");
	 	driver = new RemoteWebDriver(new URL("http://192.168.0.108:4444/wd/hub"), caps);//Opens the browser - represents one browser window

	  
  }

  @AfterMethod
  public void afterMethod() {
	 // yahooLogin.quitBrowser();
  }

}
