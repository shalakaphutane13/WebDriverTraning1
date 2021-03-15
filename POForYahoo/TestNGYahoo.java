package POForYahoo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class TestNGYahoo {
	WebElementYahoo yahooLogin; 
	
  @Test
  public void yahooLogin() throws InterruptedException {
	  
	  yahooLogin.login("shalaka.phutane@yahoo.com", "Seema$13", "shalakaphutane07@gmail.com", " First automated mail","This is my fist automated email using page object");
	  
  }
  @BeforeMethod
  public void beforeMethod() throws InterruptedException {
	  yahooLogin =new WebElementYahoo();
  }

  @AfterMethod
  public void afterMethod() {
	 // yahooLogin.quitBrowser();
  }

}
