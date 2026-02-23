package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
//import pageObjects.HomePage;
import pageObjects.SearchPage;

public class SearchProductTest extends BaseClass {

    @Test
    public void verifyProductSearch() {

       // HomePage hp = new HomePage(driver);
        SearchPage sp = new SearchPage(driver);

        sp.enterSearchText("MacBook");
        sp.clickSearch();

        boolean result = sp.isProductDisplayed();

        Assert.assertTrue(result, "Search result not displayed");
    }
}
