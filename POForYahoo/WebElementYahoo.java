package POForYahoo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WebElementYahoo {
	
	private WebDriver driver;
	
	@FindBy(xpath="//a/span[contains(text(),'Sign in')]")
	private WebElement signIn;
	
	@FindBy(xpath="//input[@id='login-username']")
	private WebElement login;
	
	@FindBy(xpath="//input[@name='signin']")
	WebElement signIn2;
	
	@FindBy(xpath="//input[@id='login-passwd']")
	WebElement password;
	
	@FindBy(xpath="//button[@id='login-signin']")
	WebElement signIn3;
	
	@FindBy(xpath="//span[contains(text(),'Mail')]")
	WebElement mail;
	
	//@FindBy(xpath=)
	WebElement showPassword;
	
	
	WebElement comboBox;
	
	@FindBy(xpath="//a[contains(text(),'Compose')]")
	WebElement compose;
	
	@FindBy(xpath="//input[@role='combobox'][@id='message-to-field']")
	WebElement recepient;
	
	@FindBy(xpath="//input[@data-test-id='compose-subject']")
	WebElement subject;
	
	@FindBy(xpath="//div[@data-test-id='rte']")
	WebElement mailBody;
	
	@FindBy(xpath="//button[@data-test-id='compose-send-button']")
	WebElement sendButton;
	
	public WebElementYahoo() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "test\\DriverResource\\chromedriver.exe");
	     driver =new ChromeDriver();
	     PageFactory.initElements(driver, this);
	     driver.get("https://in.yahoo.com/?p=us");
	Thread.sleep(3000);
	     driver.manage().window().maximize();
	}
	
	
	public void login(String username, String pass,String RecList, String sub, String text) throws InterruptedException
	{
		signIn.click();
		Thread.sleep(5000);
		login.sendKeys(username);
		signIn2.click();
		Thread.sleep(3000);
		//wait.until(ExpectedConditions.visibilityOf(showPassword);
		password.sendKeys(pass);
		signIn3.click();
		Thread.sleep(3000);
		mail.click();
		//wait.until(ExpectedConditions.visibilityOf(comboBox);
		Thread.sleep(3000);
		compose.click();
		Thread.sleep(3000);
		//wait.until(ExpectedConditions.visibilityOf(comboBox);
		recepient.sendKeys(RecList);
		Thread.sleep(4000);
		subject.sendKeys(sub);
		//wait
		mailBody.sendKeys(text);
		sendButton.click();
		Thread.sleep(3000);
	}

	
	public void quitBrowser()
	{
		//driver.quit();
	}

}
