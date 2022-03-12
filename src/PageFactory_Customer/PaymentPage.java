package PageFactory_Customer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
    // initialize driver variable
    WebDriver driver;

    // Find elements of Payment page by Page Factory design pattern
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

    // Create Constructor method with Page Factory to link the variables with locators
    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Create getTextCheckoutTitle method
    public String getTextCheckoutTitle() {
        return CheckoutTitle.getText();
    }

    // Create Payment method
    public void Payment() {
        CardNumber.sendKeys("1111111111111111");
        NameOnCard.sendKeys("PHUONG THANH GIANG");
        ExpiryDate.sendKeys("05/25");
        CVVNumber.sendKeys("123");
        PayNowBtn.click();
    }
}
