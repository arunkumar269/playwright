package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ProductPage extends BasePage {

    private final Locator productTitle;
    private final Locator addToCartButton;

    public ProductPage(Page page) {
        super(page);
        this.productTitle = page.locator("#productTitle");
        this.addToCartButton = page.locator("#add-to-cart-button");
    }

    public String getProductTitle() {
        productTitle.waitFor();
        return getText(productTitle).trim();
    }

    public boolean isAddToCartVisible() {
        return isVisible(addToCartButton);
    }
}