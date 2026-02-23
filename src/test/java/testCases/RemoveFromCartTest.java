package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductPage;
import utilities.DataProviders;

public class RemoveFromCartTest extends BaseClass {
		
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void verifyRemoveFromCart(String email, String password, String exp) {
		
		HomePage hp = new HomePage(driver);
        hp.clickMyAccount();
        hp.clickLogin();

        LoginPage lp = new LoginPage(driver);
        //lp.setEmail("b69bc@gmail.com");  // use a registered email 
        //lp.setPassword("Test@123");
        lp.setEmail(email);
        lp.setPassword(password);

        lp.clickLogin();

        ProductPage pp = new ProductPage(driver);
        pp.clickDesktops();
        pp.clickMac();
        pp.clickIMac();
        pp.addToCart();

        int beforeCount = pp.getCartItemCount();

        pp.addToCart();

        int afterCount = pp.getCartItemCount();

        Assert.assertEquals(afterCount, beforeCount+1);


        System.out.println("Product Added to Cart Successfully");
		
	}
}
