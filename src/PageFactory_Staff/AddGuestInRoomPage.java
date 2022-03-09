package PageFactory_Staff;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddGuestInRoomPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"tab4\"]/div/div/div/div/div[1]/div/div/a")
    private WebElement AddNewBtn;

    @FindBy(xpath = "//*[@id=\"example1\"]/tbody/tr/td[3]")
    private WebElement NameCheck;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/ul/li[1]/a")
    private WebElement DetailsBtn;

    public AddGuestInRoomPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickAdNewBtn(){
        AddNewBtn.click();
    }
    public boolean checkNameExisted(){
        return NameCheck.isDisplayed();
    }
    public void clickDetailsBtn(){
        DetailsBtn.click();
    }

}
