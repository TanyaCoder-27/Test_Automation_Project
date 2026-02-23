package testCases;

import org.openqa.selenium.By;
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

            // Check if login success (My Account visible)
            boolean isLoggedIn;

            try {
                isLoggedIn = driver.findElement(
                        By.linkText("Edit your account information")
                ).isDisplayed();
            } catch (Exception e) {
                isLoggedIn = false;
            }

            // ===== Validation Logic =====
            if (expected.equalsIgnoreCase("Pass")) {
                if (isLoggedIn) {
                    logger.info("Login passed as expected");
                    Assert.assertTrue(true);

                    // logout to reset state
                    driver.findElement(By.linkText("Logout")).click();

                } else {
                    logger.error("Login failed but expected Pass");
                    Assert.fail();
                }
            }

            if (expected.equalsIgnoreCase("Fail")) {
                if (!isLoggedIn) {
                    logger.info("Login failed as expected");
                    Assert.assertTrue(true);
                } else {
                    logger.error("Login passed but expected Fail");

                    // logout if accidentally logged in
                    driver.findElement(By.linkText("Logout")).click();

                    Assert.fail();
                }
            }

        } catch (Exception e) {
            logger.error("Exception in login test: " + e.getMessage());
            Assert.fail();
        }

        logger.info("===== Finished Login Test =====");
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