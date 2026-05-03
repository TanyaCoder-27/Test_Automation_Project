package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utilities.DataProviders;

public class LoginTest extends BaseClass {

    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
    public void verifyLogin(String email, String password, String expected) {

        logger.info("===== Starting Login Test =====");
        System.out.println("Login Test Started with email: " + email + " | Expected: " + expected);

        try {
            // Home Page
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            hp.clickLogin();

            // Login Page
            LoginPage lp = new LoginPage(driver);
            lp.setEmail(email);
            lp.setPassword(password);
            lp.clickLogin();

            // Check if login success using page object method
            boolean isLoggedIn = lp.isLoggedIn();

            // Validation Logic based on expected result
            if (expected.equalsIgnoreCase("Pass")) {
                if (isLoggedIn) {
                    logger.info("Login passed as expected");
                    System.out.println("✅ LOGIN TEST PASSED - User successfully logged in");
                    Assert.assertTrue(true);
                    
                    // logout to reset state
                    lp.logout();
                    System.out.println("✅ LOGOUT COMPLETED - Test state reset");
                } else {
                    logger.error("Login failed but expected Pass");
                    System.out.println("❌ LOGIN TEST FAILED - Expected login to pass but it failed");
                    Assert.fail();
                }
            } else if (expected.equalsIgnoreCase("Fail")) {
                if (!isLoggedIn) {
                    logger.info("Login failed as expected");
                    System.out.println("✅ LOGIN TEST PASSED - Login correctly failed with invalid credentials");
                    Assert.assertTrue(true);
                } else {
                    logger.error("Login passed but expected Fail");
                    System.out.println("❌ LOGIN TEST FAILED - Expected login to fail but it passed");
                    Assert.fail();
                }
            } else {
                logger.error("Invalid expected result: " + expected);
                System.out.println("❌ LOGIN TEST ERROR - Invalid expected result: " + expected);
                Assert.fail("Invalid expected result: " + expected);
            }

        } catch (Exception e) {
            logger.error("Exception in login test: " + e.getMessage());
            System.out.println("❌ LOGIN TEST EXCEPTION - " + e.getMessage());
            Assert.fail();
        }

        logger.info("===== Finished Login Test =====");
        System.out.println("Login Test Completed");
    }
}

/*
Login Successful
PASSED: testCases.LoginTest.verifyLogin

===============================================
    Default test
    Tests run: 1, Failures: 0, Skips: 0
===============================================


===============================================
Default suite
Total tests run: 1, Passes: 1, Failures: 0, Skips: 0
===============================================
*/