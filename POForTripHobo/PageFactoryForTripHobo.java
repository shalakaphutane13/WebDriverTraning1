package POForTripHobo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageFactoryForTripHobo {
	
WebDriver driver;
WebDriverWait wait;
Actions drag=new Actions(driver);

@FindBy(xpath="\"//div[@class='screen-title']\"")
private WebElement ScreenTitle;

@FindBy(xpath="//*[@id=\\\"screen-wrapper\\\"]/div[3]/div/section/div[1]/div/div[1]/div[1]/div/div/div/input")
private WebElement location;

@FindBy(xpath="//ul//li[@data-id='594d77e37f8b9ad2c20001bd']")
private WebElement locationFromList; 
 
@FindBy(xpath="//*[@id=\\\"screen-wrapper\\\"]/div[3]/div/section/div[2]/div[1]/div/i[2]")
private WebElement selectDate;

@FindBy(xpath="//td[@data-month=\\\"9\\\"]//a[text()=29]")
private WebElement StartDate;


@FindBy(xpath="//td[@data-month='10']//a[text()=29]")
private WebElement EndDate;


@FindBy(xpath="//section/div[3]/div/span")
private WebElement StartPlanning;


@FindBy(xpath="//*[@id=\\\"js_city_step_next\\\"]/span")
private WebElement NextTripOverview;


@FindBy(xpath="//*[@id=\"js_city_step_next\"]/span")
private WebElement NextAboutYou;

@FindBy(xpath="//*[@id=\\\"js_city_step_next\\\"]/span")
private WebElement SkipToTripOverview;

@FindBy(xpath="//span[text()='Edit This Plan']")
private WebElement edit;

@FindBy (xpath="//table/tbody/tr/td[3]/div/div[2]/a[9]/div[2]\"")
private WebElement source;

@FindBy (xpath="//table/tbody/tr/td[4]/div/div[2]/a[7]/div[2]")
private WebElement target;

@FindBy (xpath="//span[text()='Save Plan ']")
private WebElement save;

@FindBy(xpath="//ul[@class='dropdown']/li[2]")
private WebElement finishButton;



public PageFactoryForTripHobo() throws InterruptedException
{
	System.setProperty("webdriver.chrome.driver", "test\\DriverResource\\chromedriver.exe");
     driver =new ChromeDriver();
     PageFactory.initElements(driver, this);
     driver.get("https://www.triphobo.com/trip");
     Thread.sleep(3000);
     driver.manage().window().maximize();
     
}

public void location(String loc) throws InterruptedException
{
	location.sendKeys(loc);
	Thread.sleep(5000);
	locationFromList.click();
	Thread.sleep(5000);
	selectDate.click();
	Thread.sleep(5000);
	StartDate.click();
	EndDate.click();
	StartPlanning.click();
	Thread.sleep(5000);
	NextTripOverview.click();
	Thread.sleep(5000);
	NextAboutYou.click();
	Thread.sleep(5000);
	SkipToTripOverview.click();
	Thread.sleep(6000);
	edit.click();	
	Thread.sleep(6000);
}

public void dragAnddrop()
{
	
	 drag.dragAndDrop(source, target).perform();
	 save.click();
}

public void Mousehover()
{
	 drag.moveToElement(save).moveToElement(finishButton).click().perform();
}

public void quit()
{
	driver.quit();
	
}

}
