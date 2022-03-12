package PageFactory_Staff;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    // initialize driver variable
    WebDriver driver;

    // Find elements of Booking Detail page by Page Factory design pattern
    @FindBy(name = "username")
    private WebElement UserNameInput;

    @FindBy(name = "password")
    private WebElement PassWordInput;

    @FindBy(xpath = "/html/body/div[1]/div/div/form/div[5]/button")
    private WebElement LoginButton;

    // Create Constructor method with Page Factory to link the variables with locators
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Create setUserName method
    public void setUserName(String userName) {
        UserNameInput.sendKeys(userName);
    }

    // Create setPassWord method
    public void setPassWord(String passWord) {
        PassWordInput.sendKeys(passWord);
    }

    // Create clickLoginBtn method
    public void clickLoginBtn() {
        LoginButton.click();
    }

    // Create loginByStaffAcc method
    public void loginByStaffAcc(String usName, String passW) {
        this.setUserName(usName);
        this.setPassWord(passW);
        this.clickLoginBtn();
    }
}
