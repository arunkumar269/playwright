package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchResultsPage;

public class AmazonSearchTest extends BaseTest {

    
    @Test(description = "Verify search returns relevant results")
    public void testSearchProduct() {
        HomePage homePage = new HomePage(page).open();
        SearchResultsPage resultsPage = homePage.searchFor("laptop");

        int count = resultsPage.getResultsCount();
        Assert.assertTrue(count > 0, "Search results should not be empty");
        Assert.assertTrue(resultsPage.hasResultsContaining("laptop"),
                "Results should contain items related to 'laptop'");
    }

    @Test(description = "Verify opening a product from search results")
    public void testOpenProductFromResults() {
        HomePage homePage = new HomePage(page).open();
        SearchResultsPage resultsPage = homePage.searchFor("wireless mouse");

        ProductPage productPage = resultsPage.openResultByIndex(0);
        String title = productPage.getProductTitle();
        System.out.println(title);

        Assert.assertFalse(title.isEmpty(), "Product title should not be empty");
    }
}