
// Dynamic data ; not static data

package testCases;

import java.util.UUID;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;

public class RegistrationTest extends BaseClass {

    @Test
    public void verifyRegistration() {

    	HomePage hp = new HomePage(driver);

    	hp.clickMyAccount();
    	hp.clickRegister();


        RegistrationPage rp = new RegistrationPage(driver);

        rp.setFirstName("Tanya");
        rp.setLastName("Automation");

        // Generate random email
        String email = UUID.randomUUID().toString().substring(0,5) + "@gmail.com";
        
        rp.setEmail(email);

        rp.setTelephone("9876543210");
        rp.setPassword("Test@123");
        rp.setConfirmPassword("Test@123");

        rp.clickPolicy();
        rp.clickContinue();

        // Validation
        String successMessage = driver.findElement(
                By.xpath("//h1[text()='Your Account Has Been Created!']")
        ).getText();

        Assert.assertEquals(successMessage, "Your Account Has Been Created!");

        System.out.println("Registration Successful");
        System.out.println("Registered Email: " + email);
    }
}



/*
Registration Successful
PASSED: testCases.RegistrationTest.verifyRegistration

===============================================
    Default test
    Tests run: 1, Failures: 0, Skips: 0
===============================================


===============================================
Default suite
Total tests run: 1, Passes: 1, Failures: 0, Skips: 0




*/
