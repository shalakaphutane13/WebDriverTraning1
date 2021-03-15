package scripts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Collection {

	 public static WebDriver driver;
	 
	 public static void setup(String application)
	 {
		 System.setProperty("webdriver.chrome.driver", "test\\DriverResource\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.get(application);
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS); 
		 
		 driver.get("https://money.rediff.com/index.html");
		 
		 List<WebElement> webe=driver.findElements(By.xpath("//*[text()='NIFTY 500']/parent::li/parent::ul"));
	 System.out.println(webe);
	 
	 }

	 
	 
	 
	 
	 
	 

}
