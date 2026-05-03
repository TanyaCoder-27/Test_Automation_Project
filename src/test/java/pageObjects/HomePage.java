package pageObjects;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

  

    By myAccount = By.xpath("//span[text()='My Account']");
    By registerLink = By.linkText("Register");
    By loginLink = By.linkText("Login");
    By logoutLink = By.linkText("Logout");
    By componentsLink = By.linkText("Components");
    By monitorsLink = By.linkText("Monitors (2)");
    By PhonesAndPDAsLink = By.linkText("Phones & PDAs");
    By checkoutLink = By.linkText("Checkout");
    By cartLink = By.xpath("//div[@id='cart']/button");
    
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickMyAccount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(myAccount)).click();
    }

    public void clickRegister() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(registerLink)).click();
    }

    public void clickLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(loginLink)).click();
    }

    public void clickLogout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();
    }
    
    public void clickComponents() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(componentsLink)).click();
	}
    
    public void clickMonitors() {
    			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    				wait.until(ExpectedConditions.elementToBeClickable(monitorsLink)).click();
    						
    }
    
    public void clickPhonesAndPDAs() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(PhonesAndPDAsLink)).click();
	}
    
    public void clickCheckout() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(checkoutLink)).click();
	}
    
    public void openCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(cartLink)).click();
    }
}




	
