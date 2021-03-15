package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstWebDriverTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "test\\DriverResource\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://selenium-examples.nichethyself.com");
		driver.findElement(By.id("loginname")).sendKeys("stc123");
		driver.findElement(By.id("loginpassword")).sendKeys("12345");
		driver.findElement(By.id("loginbutton")).click();
		
		String ExpectedTitlePage="My account";
		String ActualTitlePage= driver.getTitle();
		
		if (ExpectedTitlePage.equals(ActualTitlePage))
			System.out.println("Test case passed");
		else
			System.out.println("Test case failed. Actual title is "+ActualTitlePage +" While it was expected "+ ActualTitlePage);
	driver.quit();	
	}

}
