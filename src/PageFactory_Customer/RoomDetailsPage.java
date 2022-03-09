package PageFactory_Customer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RoomDetailsPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"booking\"]/input")
    private WebElement BookNowBtn;

    public RoomDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickBookNowBtn(){
        BookNowBtn.click();
    }
}
