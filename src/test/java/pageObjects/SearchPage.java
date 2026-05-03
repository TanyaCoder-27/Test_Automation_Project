package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {

    WebDriver driver;

    // Locators
    By txtSearch = By.name("search");
    By btnSearch = By.xpath("//button[@class='btn btn-default btn-lg']");
    By products = By.xpath("//div[@class='product-thumb']");
    By noResultMsg = By.xpath("//p[contains(text(),'There is no product')]");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void enterSearchText(String product) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(txtSearch));
        searchField.clear();
        searchField.sendKeys(product);
    }

    public void clickSearch() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(btnSearch)).click();
    }

    public boolean isProductDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            List<WebElement> list = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(products));
            return list.size() > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isNoResultDisplayed() {
        try {
            return driver.findElements(noResultMsg).size() > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public int getProductCount() {
        try {
            List<WebElement> list = driver.findElements(products);
            return list.size();
        } catch (Exception e) {
            return 0;
        }
    }

    public boolean allResultsContain(String searchTerm) {
        try {
            List<WebElement> list = driver.findElements(products);
            for (WebElement product : list) {
                String productName = product.getText().toLowerCase();
                if (!productName.contains(searchTerm.toLowerCase())) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
