package PageObjectModelExample.copy;

import org.testng.annotations.Test;

import PageObjectModelExample.NTHomePage;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class TestNG {
	
	NTHomePage mypage;
  @Test
  public void login() {
	  
	  mypage.login("stc123", "12345");
	  String ExpectedTitle="My account";
	String actualText=mypage.GetNextPageTitle();
	assertEquals(ExpectedTitle, actualText);
  }
  @BeforeMethod
  public void beforeMethod() {
	  mypage = new NTHomePage();
  }

  @AfterMethod
  public void afterMethod() {
  }

}
