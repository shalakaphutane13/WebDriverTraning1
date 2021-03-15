package srviceNow;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;

public class NewTest {
	WebDriver driver;
  @Test
  public void f() throws IOException, InterruptedException {
	  
	  driver.get("https://pisadev.myatos.net/home");
	  driver.findElement(By.cssSelector("input[value='Login']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//div/*[text()='IT']")).click();
	  driver.findElement(By.xpath("//div/*[text()='Network']")).click();
	  driver.findElement(By.xpath("//div/*[text()='Guest Internet Access']")).click();
	  driver.findElement(By.xpath("//div/*[text()='Guest Internet Access Request']")).click();
	  
	  //Runtime.getRuntime().exec("C:\\Users\\A579096\\Desktop\\Selenium\\autoIT.exe");
	  //Runtime.getRuntime().exec("C:\\Users\\A579096\\Desktop\\Selenium\\autoIT.exe");
	 // Alert myAlert;
	  //driver.switchTo().alert().accept();
	
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void beforeClass() {
	  DesiredCapabilities cap=DesiredCapabilities.chrome();
	  cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	  
	  
	  
	  
		System.setProperty("webdriver.chrome.driver", "test\\DriverResource\\chromedriver.exe");
		driver =new ChromeDriver(cap);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterClass
  public void afterClass() {
  }

}
