package pages;

import base.BasePage;
import ngelements.NGButton;
import ngelements.NGTextBlock;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class EditProfileBecomeADetectivePage extends BasePage {

    @FindBy(xpath = "//h1[contains(text(), 'Become a Detective')]")
    private NGTextBlock sectionTitle;

    @FindBy(xpath = "//button[contains(text(), 'Apply to become a Detective')]")
    private NGButton applyToBecomeADetectiveButton;

    public EditProfileBecomeADetectivePage(WebDriver driver) {
        super(driver, "/profile?section=becomeFoodDetective");
    }

    @Override
    public boolean isInitialized() {
        return (sectionTitle.isDisplayed() || applyToBecomeADetectiveButton.isDisplayed());
    }

    public void clickApplyToBecomeADetectiveButton() {
        applyToBecomeADetectiveButton.click();
    }
}
