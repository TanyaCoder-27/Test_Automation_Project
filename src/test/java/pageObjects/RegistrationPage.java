package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators

    @FindBy(id = "input-firstname")
    WebElement txtFirstName;

    @FindBy(id = "input-lastname")
    WebElement txtLastName;

    @FindBy(id = "input-email")
    WebElement txtEmail;

    @FindBy(id = "input-telephone")
    WebElement txtTelephone;

    @FindBy(id = "input-password")
    WebElement txtPassword;

    @FindBy(id = "input-confirm")
    WebElement txtConfirmPassword;

    @FindBy(name = "agree")
    WebElement chkPolicy;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement btnContinue;

    // Action Methods

    public void setFirstName(String fname) {
        txtFirstName.sendKeys(fname);
    }

    public void setLastName(String lname) {
        txtLastName.sendKeys(lname);
    }

    public void setEmail(String email) {
        txtEmail.sendKeys(email);
    }

    public void setTelephone(String phone) {
        txtTelephone.sendKeys(phone);
    }

    public void setPassword(String pwd) {
        txtPassword.sendKeys(pwd);
    }

    public void setConfirmPassword(String pwd) {
        txtConfirmPassword.sendKeys(pwd);
    }

    public void clickPolicy() {
        chkPolicy.click();
    }

    public void clickContinue() {
        btnContinue.click();
    }
}
