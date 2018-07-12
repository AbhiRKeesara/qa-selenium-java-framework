package pages;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public final class SignUpPage extends BasePage {

    @FindBy(id = "user_email")
    private WebElement emailInput;

    public SignUpPage() {
        relativeUrl = "register/new";
    }

    @Override
    public boolean isInitialized() {
        return emailInput.isDisplayed();
    }
}
