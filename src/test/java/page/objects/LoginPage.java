package page.objects;

import driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class LoginPage {
    @FindBy(name = "j_username")
    private WebElement usernameField;

    @FindBy(name = "j_password")
    private WebElement passwordField;

    @FindBy(css = "input:nth-child(2)")
    private WebElement signOnButton;


    public LoginPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }
    public LoginPage typeIntoUserNameField(String username) {
        WaitForElement.waitUntilElementIsVisible(usernameField);
        usernameField.sendKeys(username);
        return this;
    }

    public LoginPage typeIntoPasswordField(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }

    public FooterPage clickOnLoginButton() {
        signOnButton.click();
        return new FooterPage();
    }
}