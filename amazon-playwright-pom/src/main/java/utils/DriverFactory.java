package utils;

import com.microsoft.playwright.*;

public class DriverFactory {

    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext context;
    private static Page page;

    public static Page initBrowser(String browserName, boolean headless) {
        playwright = Playwright.create();

        switch (browserName.toLowerCase()) {
            case "firefox":
                browser = playwright.firefox().launch(
                        new BrowserType.LaunchOptions().setHeadless(headless));
                break;
            case "webkit":
                browser = playwright.webkit().launch(
                        new BrowserType.LaunchOptions().setHeadless(headless));
                break;
            default:
                browser = playwright.chromium().launch(
                        new BrowserType.LaunchOptions()
                                .setHeadless(headless)
                                .setSlowMo(50));
                break;
        }

        context = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(1366, 768));
        page = context.newPage();
        return page;
    }

    public static Page getPage() {
        return page;
    }

    public static void closeBrowser() {
        if (context != null) context.close();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }
}