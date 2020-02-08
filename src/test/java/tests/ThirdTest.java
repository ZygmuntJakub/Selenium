package tests;

import driver.DriverManager;
import driver.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import page.objects.LoginPage;
import waits.WaitForElement;

import java.io.Console;

import static org.testng.Assert.*;

public class ThirdTest extends TestBase {

    @Test
    public void changeUserEmailTest() throws InterruptedException {
        //login page
        DriverUtils.navigateToPage("https://35.234.114.2:8181/faces/common/signIn.xhtml");

        //login
        LoginPage loginPage = new LoginPage();
        boolean isLoggedIn = loginPage
                .typeIntoUserNameField("DMitchell")
                    .typeIntoPasswordField("P@ssw0rd")
                .clickOnLoginButton()
                .isBannerAfterLoginUsername("DMitchell");
        assertTrue(isLoggedIn);

        //click dropdown
        WebElement dropdownAccounts = DriverManager.getWebDriver().findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/nav[1]/div[1]/div[2]/ul[1]/li[4]/a[1]"));
        WaitForElement.waitUntilElementIsVisible(dropdownAccounts);
        dropdownAccounts.click();

        //click list accounts
        WebElement accountButton = DriverManager.getWebDriver().findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/nav[1]/div[1]/div[2]/ul[1]/li[4]/ul[1]/li[2]/a[1]"));
        accountButton.click();

        //get current email of third account
        String currentEmail = DriverManager.getWebDriver().findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/form[1]/table[1]/tbody[1]/tr[3]/td[4]")).getText();
        System.out.println(currentEmail);
        //click edit button for third account
        WebElement accountEditButton = DriverManager.getWebDriver().findElement(By.xpath( "/html[1]/body[1]/div[1]/div[3]/div[1]/form[1]/table[1]/tbody[1]/tr[3]/td[5]/input[2]"));
        accountEditButton.click();

        //insert new email
        WebElement emailField = DriverManager.getWebDriver().findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/form[1]/table[1]/tbody[1]/tr[4]/td[2]/input[1]"));
        WaitForElement.waitUntilElementIsVisible(emailField);
        emailField.sendKeys("testowy@email.com");

        //click save button
        WebElement saveButton = DriverManager.getWebDriver().findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/form[1]/input[2]"));
        WaitForElement.waitUntilElementIsVisible(saveButton);
        saveButton.click();

        //click dropdown once again
        WebElement dropdownAccountsAgain = DriverManager.getWebDriver().findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/nav[1]/div[1]/div[2]/ul[1]/li[4]/a[1]"));
        WaitForElement.waitUntilElementIsVisible(dropdownAccountsAgain);
        dropdownAccountsAgain.click();

        //click list accounts once again
        WebElement accountButtonAgain = DriverManager.getWebDriver().findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/nav[1]/div[1]/div[2]/ul[1]/li[4]/ul[1]/li[2]/a[1]"));
        accountButtonAgain.click();

        //get current email of third account
        String currentEmailAfterChanges = DriverManager.getWebDriver().findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/form[1]/table[1]/tbody[1]/tr[3]/td[4]")).getText();

        assertNotEquals(currentEmailAfterChanges, currentEmail);
        assertEquals(currentEmailAfterChanges, "testowy@email.com");

        //click edit button for third account once again
        WebElement accountEditButtonAgain = DriverManager.getWebDriver().findElement(By.xpath( "/html[1]/body[1]/div[1]/div[3]/div[1]/form[1]/table[1]/tbody[1]/tr[3]/td[5]/input[2]"));
        accountEditButtonAgain.click();

        //insert new email
        WebElement emailFieldAgain = DriverManager.getWebDriver().findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/form[1]/table[1]/tbody[1]/tr[4]/td[2]/input[1]"));
        WaitForElement.waitUntilElementIsVisible(emailFieldAgain);
        emailField.sendKeys(currentEmail);

        //click save button
        WebElement saveButtonAgain = DriverManager.getWebDriver().findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[1]/form[1]/input[2]"));
        WaitForElement.waitUntilElementIsVisible(saveButtonAgain);
        saveButtonAgain.click();
    }
}
