package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage extends BasePage {

    private static final String URL = "https://www.amazon.com";

    private final Locator searchBox;
    private final Locator searchButton;
    private final Locator logo;

    public HomePage(Page page) {
        super(page);
        this.searchBox = page.locator("#twotabsearchtextbox");
        this.searchButton = page.locator("#nav-search-submit-button");
        this.logo = page.locator("#nav-logo-sprites");
    }

    public HomePage open() {
        navigateTo(URL);
        return this;
    }

    public boolean isLogoVisible() {
        return isVisible(logo);
    }

    public SearchResultsPage searchFor(String product) {
        type(searchBox, product);
        click(searchButton);
        return new SearchResultsPage(page);
    }
}