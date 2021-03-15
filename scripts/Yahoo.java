package scripts;

import org.testng.annotations.Test;
import org.w3c.dom.DOMConfiguration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.fail;

import java.util.NoSuchElementException;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class Yahoo {
	WebDriver driver;
	WebDriverWait wait;
	
	
	
  @Test
  public void yahoo() throws InterruptedException {
	  driver.get("https://login.yahoo.com/?.intl=in&.lang=en-IN&src=fpctx&pspid=97684142&done=https%3A%2F%2Fin.yahoo.com%2F&add=1");
	  driver.findElement(By.xpath("//span[contains(text(),'Sign in')]")).click();
	  
	  System.out.println("current window"+ driver.getWindowHandles());
	  driver.findElement(By.xpath("//input[@id='login-username']")).sendKeys("shalaka.phutane@yahoo.com");
	  driver.findElement(By.cssSelector("input[name='signin']")).click();
	 //Thread.sleep(2000);
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='password-toggle-button']")));
	 // wait.until((ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='login-passwd]"))));
	  
	  /*String newWindow =driver.getWindowHandle();
	  System.out.println("new windowis " + newWindow);
	  driver.switchTo().window(newWindow);*/
	  
	  driver.findElement(By.cssSelector("input[id='login-passwd']")).sendKeys("Seema$13");
	  driver.findElement(By.xpath("//button[@id='login-signin']")).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@role='combobox']")));
	  driver.findElement(By.xpath("//span[contains(text(),'Mail')]")).click();
	  //Thread.sleep(5000);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@role='combobox']")));
      driver.findElement(By.xpath("//a[contains(text(),'Compose')]")).click();
      //Thread.sleep(5000);
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@role='combobox']")));
      driver.findElement(By.xpath("//input[@role='combobox'][@id='message-to-field']")).sendKeys("shalaka.phutane@atos.net");
      //Thread.sleep(3000);
	  driver.findElement(By.xpath("//input[@data-test-id='compose-subject']")).sendKeys("First automated email");
	  driver.findElement(By.xpath("//div[@data-test-id='rte']")).sendKeys("Hello!!!, This is my first automatted email.");
	  driver.findElement(By.xpath("//button[@data-test-id='compose-send-button']")).click();
	 // Thread.sleep(2000);
      /* try {
	  driver.findElement(By.xpath("//button[@id=\"login-signin\"]")).click();
	  Thread.sleep(300);
	  }catch (NoSuchElementException e)
	  {
		fail("No such element");  
	  }
	  */	  
	  
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
	  	ChromeOptions chromeO=new ChromeOptions();
	  	//chromeO.addArguments("--incognito");
		driver =new ChromeDriver(chromeO);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver,10,2000);
  
  }

  @AfterClass
  public void afterClass() {
  }

}
