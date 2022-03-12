package PageFactory_Customer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmPage {

    // initialize driver variable
    WebDriver driver;

    // Find elements of Confirm page by Page Factory design pattern
    @FindBy(xpath = "/html/body/section[1]/div/div/div/div/div/div/h2")
    private WebElement ConfirmTitle;

    // Create Constructor method with Page Factory to link the variables with locators
    public ConfirmPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Create getTextConfirmTitle of Confirm page method
    public String getTextConfirmTitle() {
        return ConfirmTitle.getText();
    }
}
