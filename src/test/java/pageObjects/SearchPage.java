package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators
    By txtSearch = By.name("search");
    By btnSearch = By.xpath("//button[@class='btn btn-default btn-lg']");
    By products = By.xpath("//div[@class='product-thumb']");
    By noResultMsg = By.xpath("//p[contains(text(),'There is no product')]");

    // Actions
    public void enterSearchText(String product) {
        driver.findElement(txtSearch).clear();
        driver.findElement(txtSearch).sendKeys(product);
    }

    public void clickSearch() {
        driver.findElement(btnSearch).click();
    }

    public boolean isProductDisplayed() {
        List<WebElement> list = driver.findElements(products);
        return list.size() > 0;
    }

    public boolean isNoResultDisplayed() {
        return driver.findElements(noResultMsg).size() > 0;
    }
}
