package PageFactory_Customer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class SearchingPage {
    // initialize driver variable
    WebDriver driver;

    // Find elements of Searching Page by Page Factory design pattern
    @FindBy(id = "check-in")
    private WebElement CheckInInput;

    @FindBy(id = "check-out")
    private WebElement CheckOutInput;

    @FindBy(name = "adult")
    private WebElement AdultInput;

    @FindBy(name = "children")
    private WebElement ChildInput;

    @FindBy(xpath = "/html/body/section[1]/div/div/div/div/div/div/form/div[2]/div[3]/div/input")
    private WebElement SearchBtn;

    // Create Constructor method with Page Factory to link the variables with locators
    public SearchingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Create Searching method
    public void Searching() {
        CheckInInput.sendKeys("10/03/2022");
        CheckOutInput.sendKeys("13/03/2022");
        AdultInput.sendKeys("10");
        ChildInput.sendKeys("8");
        SearchBtn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}
