package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utilities.DataProviders;

import org.openqa.selenium.By;

public class LogoutTest extends BaseClass {

    @Test(dataProvider="RegData",dataProviderClass=DataProviders.class)
    public void verifyLogout(String email, String password) {

        HomePage hp = new HomePage(driver);
        hp.clickMyAccount();
        hp.clickLogin();

        LoginPage lp = new LoginPage(driver);
        //lp.setEmail("b69bc@gmail.com");  // use a registered email : b69bc@gmail.com
        //lp.setPassword("Test@123");
        lp.setEmail(email);
        lp.setPassword(password);

        lp.clickLogin();

        hp.clickMyAccount();
        hp.clickLogout();

        boolean logoutMsg = driver.findElement(
                By.xpath("//h1[text()='Account Logout']")
        ).isDisplayed();

        Assert.assertTrue(logoutMsg);

        System.out.println("Logout Successful");
    }
}






/*
Logout Successful
PASSED: testCases.LogoutTest.verifyLogout

===============================================
    Default test
    Tests run: 1, Failures: 0, Skips: 0
===============================================


===============================================
Default suite
Total tests run: 1, Passes: 1, Failures: 0, Skips: 0
===============================================


*/