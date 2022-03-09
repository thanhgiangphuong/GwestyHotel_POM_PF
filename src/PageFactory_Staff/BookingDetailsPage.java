package PageFactory_Staff;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingDetailsPage {
    WebDriver driver;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/a")
    private WebElement MakeConfirmBtn;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/div[2]/div[1]/div/div/div/div[1]/div[4]/button")
    private WebElement StayingBtn;

    @FindBy(xpath = "//*[@id=\"nav\"]/li[4]/a")
    private WebElement GuestInRoomBtn;

    @FindBy(xpath = "//*[@id=\"menu-btn\"]/div[3]/a")
    private WebElement CheckOutBtn;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[4]/div/div/div[2]/div/div/form/div/div[4]/div/button[2]")
    private WebElement NextBtn;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[4]/div/div/div[2]/div/div/form/div/div[3]/div/div")
    private WebElement RoomCheckbox;

    @FindBy(xpath = "//*[@id=\"payment-form\"]/div[5]/div/button[2]")
    private WebElement SubmitBtn;

    @FindBy(xpath = "/html/body/div/div[2]/div[2]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/a")
    private WebElement SucessBtn;

    public BookingDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String getTextMakeConfirmBtn(){
        return  MakeConfirmBtn.getText();
    }
    public void clickOnMakeConfirmBtn(){
        MakeConfirmBtn.click();
    }
    public String getTextStayingBtn(){
        return StayingBtn.getText();
    }
    public void clickGuestInRoomBtn(){
        GuestInRoomBtn.click();
    }
    public void CheckOut(){
        CheckOutBtn.click();
        RoomCheckbox.click();
        NextBtn.click();
        SubmitBtn.click();
    }
    public String getTextSuccessBtn(){
        return SucessBtn.getText();
    }

}
