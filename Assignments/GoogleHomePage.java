package Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleHomePage implements Page {
	
	private WebDriver driver;
	
	private By searchBox=By.name("q");
	private By searchButton=By.name("btng");
	
	
	public GoogleHomePage(final WebDriver driver ) {
		this.driver=driver;
	}
	
	public googlesearchResult search(final String testdata)
	{
		System.out.println("#####");
		System.out.println("#####");
		System.out.println("Seearch on Home Page"+testdata);
		return new googlesearchResult();
		
		
		
	}

}
