package PageFactory_Customer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookNowPage {
    WebDriver driver;

    @FindBy(id = "name")
    private WebElement FullName;

    @FindBy(id = "email")
    private WebElement Email;

    @FindBy(id = "phone")
    private WebElement Phone;

    @FindBy(id = "address")
    private WebElement Adress;

    @FindBy(xpath = "/html/body/section[4]/div/form/div/div[1]/div[5]/label")
    private WebElement TermCheckBox;

    @FindBy(xpath = "//*[@id=\"user\"]/div/div[1]/div[6]/input")
    private WebElement SubmitBtn;

    public BookNowPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void inputInfo(){
        FullName.sendKeys("Lê Thị Thu Hằng");
        Email.sendKeys("hangly301@gmail.com");
        Phone.sendKeys("3456426452");
        Adress.sendKeys("Đà Nẵng");
        TermCheckBox.click();
        SubmitBtn.click();
    }

}
