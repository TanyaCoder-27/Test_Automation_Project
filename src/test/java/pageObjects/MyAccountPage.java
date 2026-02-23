package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MyAccountPage extends BasePage {
	//constructor
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}
	
	//locators
	By myAccountHeader = By.xpath("//h2[normalize-space()='My Account']");
	By editAccountLink = By.linkText("Edit your account information");
	By changePasswordLink = By.linkText("Change your password");
	By orderHistoryLink = By.linkText("View your order history");
	By logoutLink = By.linkText("Logout");
	By newsletterLink = By.linkText("Subscribe / unsubscribe to newsletter");
	
	
	//actions
	public boolean isMyAccountHeaderDisplayed() {
		return driver.findElements(myAccountHeader).size() > 0;
	}
	
	public void clickEditAccount() {
		driver.findElement(editAccountLink).click();
	}
	
	public void clickChangePassword() {
		driver.findElement(changePasswordLink).click();
	}
	
	public void clickOrderHistory() {
		driver.findElement(orderHistoryLink).click();
	}
	
	public void clickLogout() {
		driver.findElement(logoutLink).click();
	}
	
	public void clickNewsletter() {
		driver.findElement(newsletterLink).click();
	}
	
		
}
