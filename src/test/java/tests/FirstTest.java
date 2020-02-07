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

public class FirstTest extends TestBase {

    @Test
    public void locationTest(){
        DriverUtils.navigateToPage("https://35.234.114.2:8181/faces/common/signIn.xhtml");

        LoginPage loginPage = new LoginPage();
        boolean isLoggedIn = loginPage
                .typeIntoUserNameField("JDoe")
                .typeIntoPasswordField("P@ssw0rd")
                .clickOnLoginButton()
                .isBannerAfterLoginUsername("JDoe");
        assertTrue(isLoggedIn);


        //click dropdown
        WebElement dropdownLocations = DriverManager.getWebDriver().findElement(By.cssSelector(".dropdown:nth-child(4) > .dropdown-toggle"));
        WaitForElement.waitUntilElementIsVisible(dropdownLocations);
        dropdownLocations.click();

        //click list locations
        WebElement locationsButton = DriverManager.getWebDriver().findElement(By.cssSelector(".open li:nth-child(2) > a"));
        locationsButton.click();

        //count all rows
        List<WebElement> allRows = DriverManager.getWebDriver().findElements(By.tagName("tr"));
        WaitForElement.waitUntilElementIsVisible(allRows.get(0));
        int numberOfRowsBeforeUpdate = allRows.size();

        //click dropdown
        dropdownLocations = DriverManager.getWebDriver().findElement(By.cssSelector(".dropdown:nth-child(4) > .dropdown-toggle"));
        WaitForElement.waitUntilElementIsVisible(dropdownLocations);
        dropdownLocations.click();

        //click create location
        WebElement createLocationsButton = DriverManager.getWebDriver().findElement(By.cssSelector(".open li:nth-child(1) > a"));
        WaitForElement.waitUntilElementIsVisible(createLocationsButton);
        createLocationsButton.click();

        //insert location symbol
        WebElement localization = DriverManager.getWebDriver().findElement(By.id("CreateLocationForm:locationSymbol"));
        WaitForElement.waitUntilElementIsVisible(localization);
        localization.sendKeys("XX-99-99-99");

        //insert location type
        WebElement localizationType = DriverManager.getWebDriver().findElement(By.id("CreateLocationForm:locationType"));
        Select countryDropDown = new Select(localizationType);
        countryDropDown.selectByValue("SHELF1");

        //click create location form
        WebElement createButton = DriverManager.getWebDriver().findElement(By.name("CreateLocationForm:j_idt34"));
        WaitForElement.waitUntilElementIsVisible(createButton);
        createButton.click();

        //click dropdown
        dropdownLocations = DriverManager.getWebDriver().findElement(By.cssSelector(".dropdown:nth-child(4) > .dropdown-toggle"));
        WaitForElement.waitUntilElementIsVisible(dropdownLocations);
        dropdownLocations.click();

        //click list locations
        locationsButton = DriverManager.getWebDriver().findElement(By.cssSelector(".open li:nth-child(2) > a"));
        locationsButton.click();

        //count all rows
        allRows = DriverManager.getWebDriver().findElements(By.tagName("tr"));
        WaitForElement.waitUntilElementIsVisible(allRows.get(0));
        int numberOfRowsAfterUpdate = allRows.size();


        assertTrue(--numberOfRowsAfterUpdate == numberOfRowsBeforeUpdate);
        assertTrue(allRows.get(allRows.size() - 1).getText().contains("XX-99-99-99"));

        //click delete butto
        WebElement deleteButton = DriverManager.getWebDriver().findElement(By.name("j_idt26:j_idt27:" + (allRows.size() - 2) + ":onlyWarehouse:j_idt38"));
        deleteButton.click();

        //click confirm
        WebElement deleteConfirmButton = DriverManager.getWebDriver().findElement(By.name("DeleteLocationForm:j_idt30"));
        WaitForElement.waitUntilElementIsVisible(deleteConfirmButton);
        deleteConfirmButton.click();


        //click dropdown
        dropdownLocations = DriverManager.getWebDriver().findElement(By.cssSelector(".dropdown:nth-child(4) > .dropdown-toggle"));
        WaitForElement.waitUntilElementIsVisible(dropdownLocations);
        dropdownLocations.click();

        //click list locations
        locationsButton = DriverManager.getWebDriver().findElement(By.cssSelector(".open li:nth-child(2) > a"));
        locationsButton.click();

        //count all rows
        allRows = DriverManager.getWebDriver().findElements(By.tagName("tr"));
        WaitForElement.waitUntilElementIsVisible(allRows.get(0));
        int numberOfRowsAfterDelete = allRows.size();

        assertTrue(numberOfRowsAfterDelete == numberOfRowsBeforeUpdate);


    }
}
