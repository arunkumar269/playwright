package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.List;

public class SearchResultsPage extends BasePage {

    private final Locator resultItems;
    private final Locator resultTitle;

    public SearchResultsPage(Page page) {
        super(page);
        this.resultItems = page.locator("div[data-component-type='s-search-result']");
        this.resultTitle = page.locator("span.a-size-medium.a-color-base.a-text-normal, h2 span");
    }

    public int getResultsCount() {
        resultItems.first().waitFor();
        return resultItems.count();
    }

    public List<String> getResultTitles() {
        return resultTitle.allInnerTexts();
    }

    public ProductPage openResultByIndex(int index) {
        resultItems.nth(index).locator("h2 a, h2 span").first().click();
        return new ProductPage(page);
    }

    public boolean hasResultsContaining(String keyword) {
        List<String> titles = getResultTitles();
        return titles.stream()
                .anyMatch(t -> t.toLowerCase().contains(keyword.toLowerCase()));
    }
}