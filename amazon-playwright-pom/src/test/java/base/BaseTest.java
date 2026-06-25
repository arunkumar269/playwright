package base;

import com.microsoft.playwright.Page;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverFactory;

public class BaseTest {

    protected Page page;

    @BeforeMethod
    public void setUp() {
        page = DriverFactory.initBrowser("chromium", false); // set true for headless/CI
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.closeBrowser();
    }
}