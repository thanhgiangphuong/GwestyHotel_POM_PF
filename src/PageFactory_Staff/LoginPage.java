package PageFactory_Staff;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(name = "username")
    private WebElement UserNameInput;

    @FindBy(name = "password")
    private WebElement PassWordInput;

    @FindBy(xpath = "/html/body/div[1]/div/div/form/div[5]/button")
    private WebElement LoginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setUserName(String userName) {
        UserNameInput.sendKeys(userName);
    }

    public void setPassWord(String passWord) {
        PassWordInput.sendKeys(passWord);
    }
    public void clickLoginBtn(){
        LoginButton.click();
    }
    public void loginByStaffAcc(String usName, String passW){
        this.setUserName(usName);
        this.setPassWord(passW);
        this.clickLoginBtn();

    }
}
