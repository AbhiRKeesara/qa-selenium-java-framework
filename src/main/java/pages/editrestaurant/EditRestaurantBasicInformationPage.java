package pages.editrestaurant;

import base.BasePage;
import ngelements.NGButton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import sections.EditRestaurantColumnSection;
import sections.editrestaurant.BasicInformationSection;

import java.util.List;

public class EditRestaurantBasicInformationPage extends BasePage {

    private BasicInformationSection basicInformationSection = new BasicInformationSection(driver);
    private EditRestaurantColumnSection columnSection = new EditRestaurantColumnSection(driver);

    @FindBy(xpath = "//div[contains(@class, 'Header')]/div[contains(@class, 'ePrPrn')]")
    private NGButton restaurantsDropdownButton;

    @FindBy(xpath = "//*[contains(@role, 'option')]")
    private List<NGButton> dropdownOptions;

    public EditRestaurantBasicInformationPage(WebDriver driver) {
        super(driver, "/edit-restaurant");
    }

    @Override
    public boolean isInitialized() {
        return (basicInformationSection.isInitialized() && columnSection.isInitialized());
    }

    public boolean findAndSelectRestaurant(String restaurant) {
        expandRestaurantsDropdown();

        for (NGButton option :
                dropdownOptions) {
            if (option.getText().equals(restaurant)) {
                option.click();
                return true;
            }
        }

        return false;
    }

    public void expandRestaurantsDropdown() {
        restaurantsDropdownButton.click();
    }

    public BasicInformationSection getBasicInformationSection() {
        return this.basicInformationSection;
    }

    public EditRestaurantColumnSection getColumnSection() {
        return this.columnSection;
    }
}