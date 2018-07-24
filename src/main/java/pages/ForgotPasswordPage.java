package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public final class ForgotPasswordPage extends BasePage {

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submitButton;

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
        relativeUrl = "forgot_passwords/new";
    }

    @Override
    public boolean isInitialized() {
        return submitButton.isDisplayed();
    }
}
