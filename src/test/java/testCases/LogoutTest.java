package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utilities.DataProviders;

public class LogoutTest extends BaseClass {

    @Test(dataProvider="RegData",dataProviderClass=DataProviders.class)
    public void verifyLogout(String email, String password) {

        System.out.println("Logout Test Started with email: " + email);
        
        HomePage hp = new HomePage(driver);
        hp.clickMyAccount();
        hp.clickLogin();

        LoginPage lp = new LoginPage(driver);
        lp.setEmail(email);
        lp.setPassword(password);

        lp.clickLogin();

        hp.clickMyAccount();
        hp.clickLogout();

        // Using page object method instead of hardcoded xpath
        boolean logoutMsg = lp.isLogoutMessageDisplayed();

        if (logoutMsg) {
            System.out.println(" LOGOUT TEST PASSED - Account Logout message displayed");
            Assert.assertTrue(logoutMsg, "Logout message should be displayed");
        } else {
            System.out.println(" LOGOUT TEST FAILED - Account Logout message not found");
            Assert.assertTrue(logoutMsg, "Logout message should be displayed");
        }

        System.out.println("Logout Test Completed");
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