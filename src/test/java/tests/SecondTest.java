package tests;

import driver.DriverManager;
import driver.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import page.objects.LoginPage;
import waits.WaitForElement;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class SecondTest extends TestBase {

    private WebDriver driver;

    private final String productID = "000000";
    private final String productDesc = "This is test product";
    private final String productPrice = "100.00";
    private final String productWeight = "100";

    @Test
    public void productTest() throws InterruptedException {
        DriverUtils.navigateToPage("https://35.234.114.2:8181/faces/common/signIn.xhtml");
        driver = DriverManager.getWebDriver();

        //Logowanie użytkownika
        LoginPage loginPage = new LoginPage();
        boolean isLoggedIn = loginPage
                .typeIntoUserNameField("LRey")
                .typeIntoPasswordField("P@ssw0rd")
                .clickOnLoginButton()
                .isBannerAfterLoginUsername("LRey");
        assertTrue(isLoggedIn);

        //Otworzenie listy produktow i ich policzenie
        driver.findElement(By.linkText("Produkt")).click();
        driver.findElement(By.linkText("Lista produktów")).click();
        int startRows = DriverManager.getWebDriver().findElements(By.tagName("tr")).size();

        //Utworzenie nowego produktu
        driver.findElement(By.linkText("Produkt")).click();
        driver.findElement(By.linkText("Utwórz nowy produkt")).click();
        driver.findElement(By.id("CreateProductForm:productSymbol")).click();
        driver.findElement(By.id("CreateProductForm:productSymbol")).sendKeys(productID);
        driver.findElement(By.id("CreateProductForm:description")).click();
        driver.findElement(By.id("CreateProductForm:description")).sendKeys(productDesc);
        driver.findElement(By.id("CreateProductForm:price")).click();
        driver.findElement(By.id("CreateProductForm:price")).sendKeys(productPrice);
        driver.findElement(By.cssSelector("tr:nth-child(4)")).click();
        driver.findElement(By.id("CreateProductForm:weight")).sendKeys(productWeight);
        driver.findElement(By.id("CreateProductForm:easilyDamage:1")).click();
        driver.findElement(By.name("CreateProductForm:j_idt35")).click();

        //Otworzenie listy i ponowne przeliczenie
        driver.findElement(By.linkText("Produkt")).click();
        driver.findElement(By.linkText("Lista produktów")).click();
        int afterInsertRows = DriverManager.getWebDriver().findElements(By.tagName("tr")).size();

        //Sprawdzenie czy liczba produktow zwiekszyla sie o 1
        assertTrue(startRows == afterInsertRows-1);

        //Otworzenie okna edycji dodane produktu
        WebElement productTable = driver.findElement(By.className("table"));
        List<WebElement> productList = productTable.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
        productList.get(0).findElements(By.tagName("input")).get(1).click();

        // Sprawdzenie czy wszystkie parametry produktu zgadzaja sie z wpisanymi
        String readID = driver.findElement(By.id("EditProductForm:productSymbol")).getAttribute("value");
        assertTrue(readID.equals(productID));
        String readDesc = driver.findElement(By.id("EditProductForm:description")).getAttribute("value");
        assertTrue(readDesc.equals(productDesc));
        String readPrice =  driver.findElement(By.id("EditProductForm:price")).getAttribute("value");
        assertTrue(readPrice.equals(productPrice));
        String readWeight = driver.findElement(By.id("EditProductForm:weight")).getAttribute("value");
        assertTrue(readWeight.equals(productWeight));
        String readDelicate = driver.findElement(By.id("EditProductForm:easilyDamage:1")).getAttribute("value");
        assertTrue(readDelicate.equals("true"));

        // Otworzenie ponownie listy produktow i usuniecie dodane produktu
        driver.findElement(By.linkText("Produkt")).click();
        driver.findElement(By.linkText("Lista produktów")).click();
        productTable = driver.findElement(By.className("table"));
        productList = productTable.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
        productList.get(0).findElements(By.tagName("input")).get(2).click();
        driver.findElement(By.name("DeleteProductForm:j_idt30")).click();

        // Ponowne przeliczenie produktow u upewnienie sie, ze ich liczba jest rowna liczbe przed rozpoczeciem testu
        int endRows = DriverManager.getWebDriver().findElements(By.tagName("tr")).size();
        assertTrue(startRows == endRows);
    }
}
