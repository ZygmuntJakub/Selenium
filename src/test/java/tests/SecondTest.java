package tests;

import driver.DriverManager;
import driver.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import page.objects.LoginPage;
import waits.WaitForElement;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class SecondTest extends TestBase {

    @Test
    public void locationTest() throws InterruptedException {
        DriverUtils.navigateToPage("https://35.234.114.2:8181/faces/common/signIn.xhtml");

        LoginPage loginPage = new LoginPage();
        boolean isLoggedIn = loginPage
                .typeIntoUserNameField("JDoe")
                .typeIntoPasswordField("P@ssw0rd")
                .clickOnLoginButton()
                .isBannerAfterLoginUsername("JDoe");
        assertTrue(isLoggedIn);
        Thread.sleep(10_000);
        assertTrue(true);


    }
}
