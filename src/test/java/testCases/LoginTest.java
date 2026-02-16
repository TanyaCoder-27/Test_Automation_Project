package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;

import org.openqa.selenium.By;

public class LoginTest extends BaseClass {

    @Test
    public void verifyLogin() {

        HomePage hp = new HomePage(driver);
        hp.clickMyAccount();
        hp.clickLogin();

        LoginPage lp = new LoginPage(driver);

        //lp.setEmail("b69bc@gmail.com");  // use a registered email :d7531@gmail.com, b69bc@gmail.com  ,176c3@gmail.com, 2a537@gmail.com,  0ce45@gmail.com , 56435@gmail.com , 3f710@gmail.com , d9044@gmail.com, e9580@gmail.com, c555e@gmail.com, dcd43@gmail.com
        //lp.setPassword("Test@123");
        
        lp.setEmail(USER_EMAIL);
        lp.setPassword(USER_PASSWORD);

        lp.clickLogin();

        boolean isMyAccountDisplayed = driver.findElement(
                By.linkText("Edit your account information")
        ).isDisplayed();

        Assert.assertTrue(isMyAccountDisplayed);

        System.out.println("Login Successful");
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