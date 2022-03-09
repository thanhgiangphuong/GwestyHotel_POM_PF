package PageFactory_Customer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class SearchingPage {
    WebDriver driver;

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

    public SearchingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void Searching(){
        CheckInInput.sendKeys("12/03/2022");
        CheckOutInput.sendKeys("15/03/2022");
        AdultInput.sendKeys("2");
        ChildInput.sendKeys("1");
        SearchBtn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}
