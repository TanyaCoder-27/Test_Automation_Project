package pageObjects;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

    WebDriver driver;

    // Locators
    By firstNameInput = By.id("input-firstname");
    By lastNameInput = By.id("input-lastname");
    By emailInput = By.id("input-email");
    By telephoneInput = By.id("input-telephone");
    By passwordInput = By.id("input-password");
    By confirmPasswordInput = By.id("input-confirm");
    By policyCheckbox = By.name("agree");
    By continueButton = By.xpath("//input[@value='Continue']");
    By successHeader = By.xpath("//h1[text()='Your Account Has Been Created!']");
    By errorMessage = By.cssSelector(".alert-danger");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    // Action Methods

    public void setFirstName(String fname) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameInput)).sendKeys(fname);
    }

    public void setLastName(String lname) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameInput)).sendKeys(lname);
    }

    public void setEmail(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput)).sendKeys(email);
    }

    public void setTelephone(String phone) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(telephoneInput)).sendKeys(phone);
    }

    public void setPassword(String pwd) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput)).sendKeys(pwd);
    }

    public void setConfirmPassword(String pwd) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPasswordInput)).sendKeys(pwd);
    }

    public void clickPolicy() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(policyCheckbox)).click();
    }

    public void clickContinue() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }

    public boolean isSuccessMessageDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(successHeader)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isErrorMessageDisplayed() {
        try {
            return driver.findElements(errorMessage).size() > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
