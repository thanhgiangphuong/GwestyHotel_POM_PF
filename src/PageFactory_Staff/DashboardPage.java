package PageFactory_Staff;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
    // initialize driver variable
    WebDriver driver;

    // Find elements of Booking Detail page by Page Factory design pattern
    @FindBy(xpath = "//*[@id=\"remove-scroll\"]/ul/li[2]/div/div[2]/div[1]")
    private WebElement UserName;

    @FindBy(xpath = "//*[@id=\"remove-scroll\"]/ul/li[2]/div/div[2]/div[2]")
    private WebElement PositionName;

    @FindBy(xpath = "//*[@id=\"remove-scroll\"]/ul/li[7]/a/span")
    private WebElement BookingBtn;

    // Create Constructor method with Page Factory to link the variables with locators
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Create getUserName method
    public String getUserName() {
        return UserName.getText();
    }

    // Create getPositionName method
    public String getPositionName() {
        return PositionName.getText();
    }

    // Create clickOnBookingBtn method
    public void clickOnBookingBtn() {
        BookingBtn.click();
    }
}
