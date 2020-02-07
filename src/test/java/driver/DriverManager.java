package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverManager {
    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    private DriverManager() {
    }

    public static WebDriver getWebDriver() {

        if (webDriverThreadLocal.get() == null) {
            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--disable-dev-shm-usage");
//            options.addArguments("--no-sandbox");
            options.addArguments("--headless", "--window-size=1920,1200", "--ignore-certificate-errors");
            options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
            webDriverThreadLocal.set(new ChromeDriver(options));
        }
        return webDriverThreadLocal.get();
    }

    public static void disposeDriver() {

        webDriverThreadLocal.get().close();
        webDriverThreadLocal.remove();
    }
}