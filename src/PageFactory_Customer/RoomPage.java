package PageFactory_Customer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RoomPage {
    WebDriver driver;

    @FindBy(xpath = "/html/body/section[1]/div/div/div/div/div/div/h2")
    private WebElement RoomsPage;

    @FindBy(xpath = "/html/body/section[2]/div/div/div[1]/div/div[2]/div/a")
    private WebElement ViewDetailsBtn;

    public RoomPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String getTextRoomsPage(){
        return RoomsPage.getText();
    }
    public void clickViewDetailsBtn(){
        ViewDetailsBtn.click();
    }

}
