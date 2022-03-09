package PageFactory_Customer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
    WebDriver driver;

    @FindBy(xpath = "/html/body/section[1]/div/div/div/div/div/div/h2")
    private WebElement CheckoutTitle;

    @FindBy(id = "cardNumber")
    private WebElement CardNumber;

    @FindBy(id = "ownerName")
    private WebElement NameOnCard;

    @FindBy(name = "expiry")
    private WebElement ExpiryDate;

    @FindBy(id = "cvvcode")
    private WebElement CVVNumber;

    @FindBy(xpath = "//*[@id=\"cardForm\"]/div[6]/input[2]")
    private WebElement PayNowBtn;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String getTextCheckoutTitle(){
        return CheckoutTitle.getText();
    }
    public void Payment(){
        CardNumber.sendKeys("1111111111111111");
        NameOnCard.sendKeys("PHUONG THANH GIANG");
        ExpiryDate.sendKeys("05/25");
        CVVNumber.sendKeys("123");
        PayNowBtn.click();
    }
}
