package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class DDTForSTCExample {
	WebDriver driver;
	
	
  @Test(dataProvider = "Cedentials")
  public void Login(String Uname, String Pass) throws InterruptedException {
	 
	  driver.findElement(By.id("loginname")).sendKeys(Uname);
	  Thread.sleep(2000);
		driver.findElement(By.id("loginpassword")).sendKeys(Pass);
		Thread.sleep(2000);
		driver.findElement(By.id("loginbutton")).click();
		
  }
  
  @BeforeMethod
  public void beforeMethod() {
  
		System.setProperty("webdriver.chrome.driver", "test\\DriverResource\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		 driver.get("http://selenium-examples.nichethyself.com");
  }

  @AfterMethod
  public void afterMethod() {
  }


  @DataProvider(name="Cedentials")
  public Object[][] DataFeed() {
	  Object[][] Login=new Object[4][2];
	  Login[0][0]="stc123";
	  Login[0][1]="12345";
	  
	  Login[1][0]="stc123";
	  Login[1][1]="#123";
	  
	  Login[2][0]="stc123";
	  Login[2][1]="P";
	  
	  Login[3][0]="stc123";
	  Login[3][1]="1a23";
	
	  
	  
    return Login ;
    
    
  }
}
