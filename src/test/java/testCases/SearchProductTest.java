package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.SearchPage;
import utilities.DataProviders;

public class SearchProductTest extends BaseClass {

    @Test(dataProvider = "SearchData", dataProviderClass = DataProviders.class)
    public void verifyProductSearch(String searchTerm, boolean expectedResults, int minResults) {

        System.out.println("Search Test Started for: '" + searchTerm + "'");
        System.out.println("Expected results: " + expectedResults + ", Minimum results: " + minResults);

        SearchPage sp = new SearchPage(driver);

        sp.enterSearchText(searchTerm);
        sp.clickSearch();

        int actualResults = sp.getProductCount();
        System.out.println("Actual search results found: " + actualResults);

        if (expectedResults) {
            if (sp.isProductDisplayed()) {
                System.out.println("✅ SEARCH TEST PASSED - Products displayed for: " + searchTerm);
                Assert.assertTrue(sp.isProductDisplayed(), "Should show search results for: " + searchTerm);
                
                if (actualResults >= minResults) {
                    System.out.println("✅ SEARCH COUNT PASSED - Found " + actualResults + " results (expected >= " + minResults + ")");
                    Assert.assertTrue(sp.getProductCount() >= minResults, 
                                    "Should show at least " + minResults + " results for: " + searchTerm);
                } else {
                    System.out.println("❌ SEARCH COUNT FAILED - Found " + actualResults + " results (expected >= " + minResults + ")");
                    Assert.assertTrue(sp.getProductCount() >= minResults, 
                                    "Should show at least " + minResults + " results for: " + searchTerm);
                }
                
                // Verify search accuracy for valid searches
                if (!searchTerm.isEmpty()) {
                    boolean allContain = sp.allResultsContain(searchTerm);
                    if (allContain) {
                        System.out.println("✅ SEARCH ACCURACY PASSED - All results contain search term");
                        Assert.assertTrue(sp.allResultsContain(searchTerm), 
                                        "All results should contain search term: " + searchTerm);
                    } else {
                        System.out.println("❌ SEARCH ACCURACY FAILED - Some results don't contain search term");
                        Assert.assertTrue(sp.allResultsContain(searchTerm), 
                                        "All results should contain search term: " + searchTerm);
                    }
                }
            } else {
                System.out.println("❌ SEARCH TEST FAILED - No products displayed for: " + searchTerm);
                Assert.assertTrue(sp.isProductDisplayed(), "Should show search results for: " + searchTerm);
            }
        } else {
            if (sp.isNoResultDisplayed()) {
                System.out.println("✅ SEARCH TEST PASSED - No results message displayed for: " + searchTerm);
                Assert.assertTrue(sp.isNoResultDisplayed(), "Should show no results message for: " + searchTerm);
            } else {
                System.out.println("❌ SEARCH TEST FAILED - Expected no results but found: " + actualResults);
                Assert.assertTrue(sp.isNoResultDisplayed(), "Should show no results message for: " + searchTerm);
            }
        }

        System.out.println("Search Test Completed for: " + searchTerm);
    }
}
