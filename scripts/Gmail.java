package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Gmail {
	WebDriver driver;
  @Test
  public void Gmail() {
	  driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
	  //WebElement login=driver.findElement(By.xpath("//div[4]/ul[1]/li[2]/a"));
	  //login.click();
	  
	  driver.findElement(By.cssSelector("input[type='email']")).sendKeys("shalakaphutane13");;
//	  email.sendKeys("shalakaphutane13");
	  
	 // WebElement email=driver.findElement(By.xpath("//input[@id='identifierId']"));
		//	 email.sendKeys("shalaka");
	   
	//WebElement next=driver.findElement(By.xpath("//span[@class='VfPpkd-vQzf8d']"));	 
	//next.click();
    driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']")).click();
    driver.findElement(By.cssSelector("input[type='password']")).sendKeys("Shalaka$13");
    
	  
	  
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
  
  }

  @AfterClass
  public void afterClass() {
  }

}
