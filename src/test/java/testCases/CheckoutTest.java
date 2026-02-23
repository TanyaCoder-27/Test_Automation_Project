package testCases;




import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;

public class CheckoutTest extends BaseClass {
	@Test
	public void verifyCheckoutItemsPresentOrNot() {
		
		HomePage hp = new HomePage(driver);
		hp.clickCheckout();
		
		CheckoutPage cp = new CheckoutPage(driver);
		boolean result =cp.isCartEmpty();
		
		
		Assert.assertFalse(result, "Checkout is empty");
	}
	
}
