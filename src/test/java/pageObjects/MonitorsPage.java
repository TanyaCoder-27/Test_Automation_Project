package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MonitorsPage extends BasePage{
	
	
	//constructor
	public MonitorsPage(WebDriver driver) {
		super(driver);
		
	}
	
	//locators
	
	
	
	
	@FindBy(linkText = "Apple Cinema 30\"")
	WebElement appleCinemaLink;
	
	//actions
	
	

	
	public void clickAppleCinemaLink() {
		appleCinemaLink.click();
	}
	
	
	
}
