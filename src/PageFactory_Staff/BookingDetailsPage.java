package PageFactory_Staff;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BookingDetailsPage {
    // initialize driver variable
    WebDriver driver;

    // Find elements of Booking Detail page by Page Factory design pattern
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

    @FindBys(@FindBy(css = "#initial-content > div:nth-child(3) > div > div > label"))
    private List<WebElement> RoomCheckboxes;

    @FindBy(xpath = "//*[@id=\"payment-form\"]/div[5]/div/button[2]")
    private WebElement SubmitBtn;

    @FindBy(xpath = "/html/body/div/div[2]/div[2]/div/div[2]/div[1]/div/div/div/div[1]/div[2]/a")
    private WebElement SucessBtn;

    // Create Constructor method with Page Factory to link the variables with locators
    public BookingDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Create getTextMakeConfirmBtn method
    public String getTextMakeConfirmBtn() {
        return MakeConfirmBtn.getText();
    }

    // Create clickOnMakeConfirmBtn method
    public void clickOnMakeConfirmBtn() {
        MakeConfirmBtn.click();
    }

    // Create getTextStayingBtn method
    public String getTextStayingBtn() {
        return StayingBtn.getText();
    }

    // Create clickGuestInRoomBtn method
    public void clickGuestInRoomBtn() {
        GuestInRoomBtn.click();
    }

    // Create clickOnCheckBoxes method
    public void clickOnCheckBoxes() throws InterruptedException {
        int size = RoomCheckboxes.size();
        System.out.println(size);
        for (int i = 0; i < size; i++) {
            RoomCheckboxes.get(i).click();
            Thread.sleep(2000);
        }
    }

    // Create CheckOut method
    public void CheckOut() throws InterruptedException {
        CheckOutBtn.click();
        Thread.sleep(2000);
        clickOnCheckBoxes();
        NextBtn.click();
        SubmitBtn.click();
    }

    // Create getTextSuccessBtn method
    public String getTextSuccessBtn() {
        return SucessBtn.getText();
    }

}
