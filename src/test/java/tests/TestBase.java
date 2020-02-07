package tests;

import driver.DriverManager;
import driver.DriverUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "/Users/jakubzygmunt/chromedriver");
        DriverManager.getWebDriver();
        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateToPage("https://35.234.114.2:8181");
    }

    @AfterMethod
    public void afterTest() {
        DriverManager.disposeDriver();
    }
}
