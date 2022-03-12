package PageFactory_Customer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RoomDetailsPage {
    // initialize driver variable
    WebDriver driver;

    // Find elements of Room Detail page by Page Factory design pattern
    @FindBy(xpath = "//*[@id=\"booking\"]/input")
    private WebElement BookNowBtn;

    // Create Constructor method with Page Factory to link the variables with locators
    public RoomDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Create clickBookNowBtn method
    public void clickBookNowBtn() {
        BookNowBtn.click();
    }
}
