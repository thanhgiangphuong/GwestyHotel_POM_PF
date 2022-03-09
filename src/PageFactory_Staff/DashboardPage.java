package PageFactory_Staff;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"remove-scroll\"]/ul/li[2]/div/div[2]/div[1]")
    private WebElement UserName;

    @FindBy(xpath = "//*[@id=\"remove-scroll\"]/ul/li[2]/div/div[2]/div[2]")
    private WebElement PositionName;

    @FindBy(xpath = "//*[@id=\"remove-scroll\"]/ul/li[7]/a/span")
    private WebElement BookingBtn;


    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getUserName() {
        return UserName.getText();
    }

    public String getPositionName() {
        return PositionName.getText();
    }

    public void clickOnBookingBtn(){
        BookingBtn.click();
    }
}
