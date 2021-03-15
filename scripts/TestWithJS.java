package scripts;

import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.google.common.io.Files;

import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class TestWithJS {
  WebDriver driver;
  TakesScreenshot ts;
  MyListener myListener;
	
	@Test
  public void google() throws InterruptedException, IOException {
		DOMConfigurator.configure("log4j.xml");
		//Logger log=Logger.getLogger(TestWithJS.class.getName());
		
		
		driver.get("https://www.google.com");
		By by = null;
		//ts=(TakesScreenshot)driver;
		//File scrshot=ts.getScreenshotAs(OutputType.FILE);
		//Files.copy(scrshot, new File("C:\\Users\\A579096\\Desktop\\Class Material\\ScreenShots\\search.png"));
		WebElement search=driver.findElement(By.xpath("//input[@name=\"q\" ][@ type=\"text\"]"));
		myListener.beforeFindBy(by, search, driver);
		search.sendKeys("vijay devarkonda");
		Thread.sleep(3000);
		myListener.afterFindBy(by, search, driver);
		driver.findElement(By.xpath("//div[@class=\"sbtc\"]//span[contains(text(),\"Indian film\")]")).click();
		Thread.sleep(10000);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		//jse.executeScript("scroll(0,500)");		
		//WebElement e=driver.findElement(By.xpath("//td[@class=\"YyVfkd\"]"));
		WebElement e1=driver.findElement(By.xpath("//div[@class=\"mod\"]//a[text()=\"Wikipedia\"]"));
		
		jse.executeScript("arguments[0].scrollIntoView(true);",e1);
	}
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "test\\DriverResource\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		myListener=new MyListener();
  }

  @AfterMethod
  public void afterMethod() {
  }

}
