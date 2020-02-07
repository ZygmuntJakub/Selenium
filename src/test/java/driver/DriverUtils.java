package driver;

public class DriverUtils {

    public static void setInitialConfiguration(){
        driver.DriverManager.getWebDriver().manage().window().maximize();
    }

    public static void navigateToPage(String pageUrl){
        driver.DriverManager.getWebDriver().navigate().to(pageUrl);
    }

}