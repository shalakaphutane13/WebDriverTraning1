package Assignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class AlertAssignment_CookBook {
	WebDriver driver;
  @Test
  public void AlerTest() {
	  driver.get("http://www.cookbook.seleniumacademy.com/Alerts.html");
	  driver.findElement(By.id("simple")).click();
	  driver.switchTo().alert().accept();
	 
	  
	  
  }
  @Test
  public void AlerTestPrompt() {
	  driver.findElement(By.id("confirm")).click();
	  driver.switchTo().alert().accept();
	  String ExpectedTest= "You Accepted Alert!";
	  String ActualText=driver.findElement(By.id("demo")).getText();
	  assertEquals(ExpectedTest, ActualText);
	  	  
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Execute test methods");
	  
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("test method executed");
  }

  @Test
  public void AlerTestForConfirm() {
	  //driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	  driver.findElement(By.cssSelector("button[id=prompt]")).click();
	  driver.switchTo().alert().sendKeys("Shalaka Phutane");
	  driver.switchTo().alert().accept();
	  String ExpectedTest= "Hello Shalaka Phutane! How are you today?";
	  String ActualText=driver.findElement(By.id("prompt_demo")).getText();
	  assertEquals(ExpectedTest, ActualText);
	  
	  
  }
  
  
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", "test\\DriverResource\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterClass
  public void afterClass() {
  }

}
