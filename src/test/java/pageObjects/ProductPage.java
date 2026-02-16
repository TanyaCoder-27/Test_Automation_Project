package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    By desktopsLink = By.xpath("//a[normalize-space()='Desktops']");
    By macLink = By.xpath("//a[normalize-space()='Mac (1)']");
    By iMacLink = By.linkText("iMac");
    By addToCartBtn = By.id("button-cart");
    By cartTotalText = By.id("cart-total");

    
    public void clickDesktops() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(desktopsLink)).click();
    }

    public void clickMac() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(macLink)).click();
    }

    public void clickIMac() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(iMacLink)).click();
    }

    public void addToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
    }

    public int getCartItemCount() {
        String text = driver.findElement(cartTotalText).getText();
        String number = text.split(" ")[0];
        return Integer.parseInt(number);
    }
}
    
    
    
    /*
     PageFactory is convenient…

	But in dynamic applications, using By + explicit wait is more stable.
	I encountered stale element issues with PageFactory and solved them by switching to By-based dynamic locating with explicit waits.
	
	Also, If you use:

	✔ By + Explicit Wait in one page
	Then
	❌ Don’t mix it with PageFactory in another page.

	Consistency matters.

	🏆 Proper Fix Now

	Refactor HomePage exactly like ProductPage.

	Remove all @FindBy and WebElements.
	
	Now every click:

	✔ Re-locates element fresh
	✔ Waits until clickable
	✔ Avoids stale cached references
	You are now building a stable, dynamic-safe framework.
     */
    
    
    
    /* OLD CODE: WITH @FindBy
    @FindBy(xpath = "//a[normalize-space()='Desktops']")  //   //a[text()='Desktops']
    WebElement lnkDesktops;

    @FindBy(xpath = "//a[normalize-space()='Mac (1)']")             //            //a[text()='Mac (1)']
    WebElement lnkMac;
    
    @FindBy(linkText = "iMac")
    WebElement lnkIMac;

    /*
    @FindBy(xpath = "//a[normalize-space()='iMac']")
    WebElement lnkIMac;
		 
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement btnAddToCart;


    @FindBy(xpath = "//span[@id='cart-total']")                   // //span[@id='cart-total']
    WebElement cartTotal;
    
    public void clickDesktops() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(lnkDesktops));
        lnkDesktops.click();
    }

    public void clickMac() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(lnkMac));
        lnkMac.click();
    }
    
    public void clickIMac() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(lnkIMac));
        lnkIMac.click();
    }

    public void addToCart() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(btnAddToCart));
        btnAddToCart.click();
    }

    public int getCartItemCount() {

        String text = cartTotal.getText();
        // Example: "2 item(s) - $602.00"

        String number = text.split(" ")[0];
        return Integer.parseInt(number);
    }

}

*/

/*
Explicit wait used for:
Waits until fresh DOM

Waits until element clickable

Then interacts

*/
