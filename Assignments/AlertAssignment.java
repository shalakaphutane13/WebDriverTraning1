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
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class AlertAssignment {
	WebDriver driver;
  @Test
  public void AlerTest() {
	  driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	  driver.findElement(By.cssSelector("button[onClick='jsAlert()']")).click();
	  driver.switchTo().alert().accept();
	  String ExpectedTest= "You successfuly clicked an alert";
	  String ActualText=driver.findElement(By.xpath("//p[@id='result']")).getText();
	  assertEquals(ExpectedTest, ActualText);
	  
	  
  }
  @Test
  public void AlerTestPrompt() {
	  driver.findElement(By.cssSelector("button[onClick='jsPrompt()']")).click();
	  
	  driver.switchTo().alert().sendKeys("test");
	  //driver.switchTo().alert().accept();
	  String ExpectedTest= "You entered: test";
	  driver.switchTo().alert().dismiss();
	  String ExpectedTest2= "You entered: null";
	  
	  String ActualText=driver.findElement(By.xpath("//p[@id='result']")).getText();
	  assertEquals(ExpectedTest2, ActualText);
	  assertTrue(driver.findElement(By.xpath("//p[@style='color:red']")).isDisplayed()); //is it correct way to validate?
	  
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
	  driver.findElement(By.cssSelector("button[onClick='jsConfirm()']")).click();
	  driver.switchTo().alert().accept();
	  String ExpectedTest= "You clicked: Ok";
	  String ActualText=driver.findElement(By.xpath("//p[@id='result']")).getText();
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
