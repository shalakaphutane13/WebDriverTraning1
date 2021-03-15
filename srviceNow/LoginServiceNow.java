package srviceNow;

import java.io.File;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class LoginServiceNow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	

		System.setProperty("webdriver.chrome.driver","X://chromedriver.exe");		
		ChromeOptions options = new ChromeOptions();
		//options.addExtensions(new File("X://extension_3_40_1_0.crx")); 
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(capabilities);
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://pisadev.myatos.net/home?id=sc_cat_item&sys_id=d58ddee9db529c10eeaf30d6f496191c&sysparm_category=fca9884f1bc1c8107c1ddceacd4bcb39");
		driver.manage().window().maximize();
		//driver.quit();
		
		
		
		
		
		
	}

}
