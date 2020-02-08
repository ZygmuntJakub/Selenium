package tests;

import driver.DriverManager;
import driver.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.objects.LoginPage;
import waits.WaitForElement;

import static org.testng.Assert.assertTrue;

public class FourthTest extends TestBase {
    private WebDriver driver;
    @Test
    public void contractorTest() throws InterruptedException {
        DriverUtils.navigateToPage("https://35.234.114.2:8181/faces/common/signIn.xhtml");
        driver = DriverManager.getWebDriver();
        LoginPage loginPage = new LoginPage();
        boolean isLoggedIn = loginPage
                .typeIntoUserNameField("LRey")
                .typeIntoPasswordField("P@ssw0rd")
                .clickOnLoginButton()
                .isBannerAfterLoginUsername("LRey");
        assertTrue(isLoggedIn);

        /*click(driver.findElement(By.xpath("//div[@id='myNavbar']/ul/li[4]/a")));
        click(driver.findElement(By.cssSelector(".open li:nth-child(1) > a")));
        click(driver.findElement(By.id("RegisterContractorForm:contractorNumber")));
        driver.findElement(By.id("RegisterContractorForm:contractorNumber")).sendKeys("0000000000000");
        click(driver.findElement(By.id("RegisterContractorForm:contractorName")));
        driver.findElement(By.id("RegisterContractorForm:contractorName")).sendKeys("Aa");
        click( driver.findElement(By.id("RegisterContractorForm:street")));
        driver.findElement(By.id("RegisterContractorForm:street")).sendKeys("Test");
        click(driver.findElement(By.id("RegisterContractorForm:house")));
        driver.findElement(By.id("RegisterContractorForm:house")).sendKeys("1");
        click(driver.findElement(By.id("RegisterContractorForm:zip")));
        driver.findElement(By.id("RegisterContractorForm:zip")).sendKeys("90-100");
        click(driver.findElement(By.id("RegisterContractorForm:city")));
        driver.findElement(By.id("RegisterContractorForm:city")).sendKeys("Test");
        click(driver.findElement(By.id("RegisterContractorForm:j_idt39")));
        click(driver.findElement(By.xpath("//div[@id='myNavbar']/ul/li[4]/a")));
        click(driver.findElement(By.cssSelector(".open li:nth-child(2) > a")));
        String id = driver.findElement(By.cssSelector("tr:nth-child(1) > td:nth-child(1)")).getAttribute("textContent");
        String name = driver.findElement(By.cssSelector("tr:nth-child(1) > td:nth-child(2)")).getAttribute("textContent");
        String street = driver.findElement(By.cssSelector("tr:nth-child(1) > td:nth-child(5)")).getAttribute("textContent");
        String house = driver.findElement(By.cssSelector("tr:nth-child(1) > td:nth-child(6)")).getAttribute("textContent");
        String zip = driver.findElement(By.cssSelector("tr:nth-child(1) > td:nth-child(8)")).getAttribute("textContent");
        String city = driver.findElement(By.cssSelector("tr:nth-child(1) > td:nth-child(9)")).getAttribute("textContent");
        Assert.assertEquals(id,"0000000000000");
        Assert.assertEquals(name,"Aa");
        Assert.assertEquals(street,"Test");
        Assert.assertEquals(house,"1");
        Assert.assertEquals(zip,"90-100");
        Assert.assertEquals(city,"Test");
        click(driver.findElement(By.name("j_idt26:j_idt27:0:j_idt48")));
        click(driver.findElement(By.name("DeleteContractorForm:j_idt30")));*/
    }

    private void click(WebElement webElement){
        WaitForElement.waitUntilElementIsClickable(webElement);
        webElement.click();
    }
}
