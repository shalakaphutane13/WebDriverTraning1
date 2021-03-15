package triphobo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class TripHoboCalDragNdDrop {
	WebDriver driver;
	WebDriverWait wait;
  @Test
  public void f() throws InterruptedException {
	  //driver.get("https://www.triphobo.com/");https://www.triphobo.com/trip
	  //driver.findElement(By.id("plan-my-trip")).click();
	  driver.get("https://www.triphobo.com/trip");
	  
	  
	  driver.findElement(By.xpath("//div[@class='screen-title']"));
	  WebElement location=driver.findElement(By.xpath("//*[@id=\"screen-wrapper\"]/div[3]/div/section/div[1]/div/div[1]/div[1]/div/div/div/input"));
	 // wait.until(ExpectedConditions.invisibilityOf(location));
	 location.sendKeys("Houston");
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//ul//li[@data-id='594d77e37f8b9ad2c20001bd']")).click();
	  Thread.sleep(1000);
	 driver.findElement(By.xpath("//*[@id=\"screen-wrapper\"]/div[3]/div/section/div[2]/div[1]/div/i[2]")).click();
	 driver.findElement(By.xpath("//td[@data-month=\"9\"]//a[text()=29]")).click();
	 driver.findElement(By.xpath("//td[@data-month='10']//a[text()=29]")).click();
	 driver.findElement(By.xpath("//section/div[3]/div/span")).click();
	 Thread.sleep(5000);
	 driver.findElement(By.xpath("//*[@id=\"js_city_step_next\"]/span")).click();
	 Thread.sleep(5000);
	 driver.findElement(By.xpath("//*[@id=\"js_city_step_next\"]/span")).click();
	 Thread.sleep(5000);
	 driver.findElement(By.xpath("//*[@id='js_city_step_next']/span")).click();
	 Thread.sleep(15000);
	 WebElement edit=driver.findElement(By.xpath("//span[text()='Edit This Plan']"));
	 Thread.sleep(6000);
	 edit.click();
	 Thread.sleep(5000);
	 WebElement source=driver.findElement(By.xpath("//table/tbody/tr/td[3]/div/div[2]/a[9]/div[2]"));
	 WebElement  target=driver.findElement(By.xpath("//table/tbody/tr/td[4]/div/div[2]/a[7]/div[2]"));
	 Actions drag=new Actions(driver);
	 drag.dragAndDrop(source, target).perform();
	 Thread.sleep(7000);
	 
	 WebElement save=driver.findElement(By.xpath("//span[text()='Save Plan ']"));
	 WebElement finish=driver.findElement(By.xpath("//ul[@class='dropdown']/li[2]"));
	 drag.moveToElement(save).moveToElement(finish).click().perform();
	 
	  
	 
	  
	  
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
		wait = new WebDriverWait(driver,10,2000);
  }
  

  @AfterClass
  public void afterClass() {
  }

}
