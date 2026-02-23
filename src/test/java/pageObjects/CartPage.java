package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {
	WebDriver driver;
    public CartPage(WebDriver driver) {
    	super(driver);
    }

    // ===== LOCATORS =====

    By cartRows = By.xpath("//div[@class='table-responsive']//tbody/tr");
    By removeButtons = By.xpath("//button[@data-original-title='Remove']");
    By checkoutBtn = By.xpath("//a[text()='Checkout']");
    By productNames = By.xpath("//div[@class='table-responsive']//tbody/tr/td[2]/a");

    // ===== ACTION METHODS =====

    public int getCartItemsCount() {
        return driver.findElements(cartRows).size();
    }

    public boolean isProductInCart(String productName) {
        List<WebElement> products = driver.findElements(productNames);

        for (WebElement p : products) {
            if (p.getText().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }

    public void removeFirstProduct() {
        driver.findElements(removeButtons).get(0).click();
    }

    public void clickCheckout() {
        driver.findElement(checkoutBtn).click();
    }
}
