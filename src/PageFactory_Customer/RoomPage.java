package PageFactory_Customer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RoomPage {
    // initialize driver variable
    WebDriver driver;

    // Find elements of Room Page by Page Factory design pattern
    @FindBy(xpath = "/html/body/section[1]/div/div/div/div/div/div/h2")
    private WebElement RoomsPage;

    @FindBy(xpath = "/html/body/section[2]/div/div/div[1]/div/div[2]/div/a")
    private WebElement ViewDetailsBtn;

    // Create Constructor method with Page Factory to link the variables with locators
    public RoomPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Create getTextRoomsPage method
    public String getTextRoomsPage() {
        return RoomsPage.getText();
    }

    // Create clickViewDetailsBtn method
    public void clickViewDetailsBtn() {
        ViewDetailsBtn.click();
    }
}
