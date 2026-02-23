package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.Select;

public class PhonesPage extends BasePage{

	

	//constructor
	public PhonesPage(WebDriver driver) {
		super(driver);
		
	}
	
	
	//locators
	@FindBy(xpath = "//select[@id='input-sort']")
	WebElement sortByDropdown;
	
	
	
	
	
	//actions
	public void selectSortByOption(String option) {
		sortByDropdown.click();
		Select select = new Select(sortByDropdown);
		select.selectByVisibleText(option);
	}
	
	/*for testing whether the correct option is selected in the dropdown, we can add a method to get the currently selected option
	 
	 * */
}
