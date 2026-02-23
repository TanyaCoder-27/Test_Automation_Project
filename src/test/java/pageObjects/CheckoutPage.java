package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage{
	
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath = "//h1[contains(text(),'Shopping Cart')]")
	WebElement checkoutHeader;
	
	public String getCheckoutHeader() {
		return checkoutHeader.getText();
	}
	
	//check if checkout is empty or not
	@FindBy(xpath = "//p[contains(text(),'Your shopping cart is empty!')]")
	WebElement emptyCartMsg;
	
	public boolean isCartEmpty() {
		return emptyCartMsg.isDisplayed();
	}
	
	
}
