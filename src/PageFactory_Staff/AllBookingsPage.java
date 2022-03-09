package PageFactory_Staff;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllBookingsPage {
    WebDriver driver;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/div[3]/div/div/div[2]/div/div/div[1]/div[2]/div/label/input")
    private WebElement SearchBox;

    @FindBy(xpath = "//*[@id=\"example4\"]/tbody/tr[1]/td[8]/a/i")
    private WebElement EyeIcon;

    public AllBookingsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setSearchBox(String searchBox) {
        SearchBox.sendKeys(searchBox);
    }
    public void clickToEyeIcon(){
        EyeIcon.click();
    }
}
