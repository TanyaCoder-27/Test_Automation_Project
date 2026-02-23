
package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import utilities.ExcelUtility;

public class RegistrationTest extends BaseClass {

    @Test
    public void verifyRegistration() throws IOException {

        HomePage hp = new HomePage(driver);
        hp.clickMyAccount();
        hp.clickRegister();

        RegistrationPage rp = new RegistrationPage(driver);

        // Dynamic data using BaseClass methods
        String firstName = randomeString();
        String lastName = randomeString();
        String email = randomeString().toLowerCase() + randomeNumber().substring(0,3) + "@gmail.com";
        String phone = randomeNumber();
        String password = "Test@" + randomeNumber().substring(0,3);

        rp.setFirstName(firstName);
        rp.setLastName(lastName);
        rp.setEmail(email);
        rp.setTelephone(phone);
        rp.setPassword(password);
        rp.setConfirmPassword(password);

        rp.clickPolicy();
        rp.clickContinue();

        // Validation
        String successMessage = driver.findElement(
                By.xpath("//h1[text()='Your Account Has Been Created!']")
        ).getText();

        Assert.assertEquals(successMessage, "Your Account Has Been Created!");

        System.out.println("Registration Successful");
        System.out.println("Registered Email: " + email);
        System.out.println("Password: " + password);

        // ✅ Write Email & Password into Excel
        String path = System.getProperty("user.dir") + "/testData/RegistrationData.xlsx";
        ExcelUtility xl = new ExcelUtility(path);
        
     // Create headers if first time
        if (xl.getRowCount("Users") == 0) {
            xl.setCellData("Users", 0, 0, "Email");
            xl.setCellData("Users", 0, 1, "Password");
        }

        // Next available row
        int row = xl.getRowCount("Users") + 1;

        xl.setCellData("Users", row, 0, email);
        xl.setCellData("Users", row, 1, password);
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
