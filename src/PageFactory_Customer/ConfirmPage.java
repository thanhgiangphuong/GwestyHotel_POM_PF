package PageFactory_Customer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmPage {
    WebDriver driver;

    @FindBy(xpath = "/html/body/section[1]/div/div/div/div/div/div/h2")
    private WebElement ConfirmTitle;

    public ConfirmPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String getTextConfirmTitle(){
        return ConfirmTitle.getText();
    }
}
