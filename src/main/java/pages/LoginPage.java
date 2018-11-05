package pages;

import base.BasePage;
import ngelements.NGButton;
import ngelements.NGTextBlock;
import ngelements.NGTextInput;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import utilities.UserType;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//*[contains(@type, 'email')]")
    private NGTextInput emailInput;

    @FindBy(xpath = "//*[contains(@type, 'password')]")
    private NGTextInput passwordInput;

    @FindBy(xpath = "//*[contains(@type, 'submit')]")
    private NGButton logInButton;

    @FindBy(xpath = "//*[contains(@class, 'styled__ForgetPasswordLink-sc-1mxkpa2-1')]")
    private NGButton forgotYourPasswordButton;

    @FindBy(xpath = "//*[contains(@class, 'Button__ButtonAnchor-sc-1emfup8-1')]")
    private NGButton createAnAccountButton;

    @FindBy(xpath = "(//*[contains(@class, 'Input__Error-sc-1cfdsff-3')])[1]")
    private NGTextBlock emailErrorMessage;

    @FindBy(xpath = "(//*[contains(@class, 'Input__Error-sc-1cfdsff-3')])[2]")
    private NGTextBlock passwordErrorMessage;

    public LoginPage(WebDriver driver) {
        super(driver, "/login");
    }

    @Override
    public boolean isInitialized() {
        return forgotYourPasswordButton.isDisplayed();
    }

    public void logIn(String email, String password) {
        provideEmail(email);
        providePassword(password);
        clickLogInButton();
    }

    public void logIn(UserType userType) {
        String email = "";

        switch (userType) {
            case ADMIN:
                email = propertiesLoader.getAdminEmail();
                break;
            case BO:
                email = propertiesLoader.getBOEmail();
                break;
            case FD:
                email = propertiesLoader.getFDEmail();
                break;
            case BASIC:
                email = propertiesLoader.getBasicUserEmail();
                break;
            case BO_NO_RESTAURANTS:
                email = propertiesLoader.getBONoRestaurantsEmail();
                break;
            case FD_NO_RESTAURANTS_AND_REVIEWS:
                email = propertiesLoader.getFDNoRestaurantsAndReviewsEmail();
                break;
            default:
                log.error("Given user type: \"" + userType.toString() + "\" does not have a defined email!");
        }

        logIn(email, propertiesLoader.getCommonPassword());
    }

    public void provideEmail(String email) {
        emailInput.sendVulnerableData(email);
    }

    public void providePassword(String password) {
        passwordInput.sendVulnerableData(password);
    }

    public void clickLogInButton() {
        logInButton.click();
    }

    public void clickForgotYourPasswordButton() {
        forgotYourPasswordButton.click();
    }

    public void clickCreateAnAccountButton() {
        createAnAccountButton.click();
    }

    public String getEmailErrorMessage() {
        return emailErrorMessage.getText();
    }

    public String getPasswordErrorMessage() {
        return passwordErrorMessage.getText();
    }
}
