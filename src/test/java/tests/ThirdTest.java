package tests;

import driver.DriverUtils;
import org.testng.annotations.Test;
import page.objects.LoginPage;

import static org.testng.Assert.assertTrue;

public class ThirdTest extends TestBase {

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
