package page.objects;

import driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class FooterPage {


    @FindBy(id = "logged-user-footer")
    private WebElement bannerAfterLoginText;

    public FooterPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public boolean isBannerAfterLoginUsername(String username){
        WaitForElement.waitUntilElementIsVisible(bannerAfterLoginText);
        String displayedUsername = bannerAfterLoginText.getText();
        return displayedUsername.contains(username);
    }

}