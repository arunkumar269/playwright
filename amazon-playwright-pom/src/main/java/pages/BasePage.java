package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

public class BasePage {

    protected Page page;

    public BasePage(Page page) {
        this.page = page;
    }

    protected void click(Locator locator) {
        locator.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        locator.click();
    }

    protected void type(Locator locator, String text) {
        locator.waitFor();
        locator.fill(text);
    }

    protected String getText(Locator locator) {
        locator.waitFor();
        return locator.innerText();
    }

    protected boolean isVisible(Locator locator) {
        return locator.isVisible();
    }

    protected void navigateTo(String url) {
        page.navigate(url);
    }
}