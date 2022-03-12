package PageFactory_Staff;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddGuestInRoomPage {
    // initialize driver variable
    WebDriver driver;

    // Find elements of Add Guest In Room page by Page Factory design pattern
    @FindBy(xpath = "//*[@id=\"tab4\"]/div/div/div/div/div[1]/div/div/a")
    private WebElement AddNewBtn;

    @FindBy(xpath = "//*[@id=\"example1\"]/tbody/tr/td[3]")
    private WebElement NameCheck;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/ul/li[1]/a")
    private WebElement DetailsBtn;

    // Create Constructor method with Page Factory to link the variables with locators
    public AddGuestInRoomPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Create clickAdNewBtn method
    public void clickAdNewBtn() {
        AddNewBtn.click();
    }

    // Create checkNameExisted method
    public boolean checkNameExisted() {
        return NameCheck.isDisplayed();
    }

    // Create clickDetailsBtn method
    public void clickDetailsBtn() {
        DetailsBtn.click();
    }

}
