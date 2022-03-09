package PageFactory_Staff;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddGuestDetailsPage {
    WebDriver driver;

    @FindBy(id = "name")
    private WebElement FullName;

    @FindBy(id = "sample3")
    private WebElement Gender;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/div[2]/div/div/form/div/div[2]/div/div/ul/li[1]")
    private WebElement MalePick;

    @FindBy(id = "dateOfBirth")
    private WebElement DateOfBirth;

    @FindBy(xpath = "/html/body/div[2]/div/div[1]/div[3]/div[1]/table/tbody/tr[2]/td[3]/a")
    private WebElement DateOfBirthPicker;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/button[4]")
    private WebElement OKPicker;

    @FindBy(name = "roomNum")
    private WebElement Room;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/div[2]/div/div/form/div/div[4]/div/div/ul/li")
    private WebElement RoomPick;

    @FindBy(id = "text7")
    private WebElement Address;

    @FindBy(id = "sample1")
    private WebElement IDchose;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/div[2]/div/div/form/div/div[6]/div/div/ul/li[1]")
    private WebElement IDCard;

    @FindBy(id = "text5")
    private WebElement IDNumber;

    @FindBy(xpath = "//*[@id=\"guest\"]/div/div[8]/button[1]/span")
    private WebElement SubmitBtn;

    public AddGuestDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void inputGuestInRoom(){
        FullName.sendKeys("Le Thu Thu Hang");

        Gender.click();
        MalePick.click();

        DateOfBirth.click();
        DateOfBirthPicker.click();
        OKPicker.click();

        Room.click();
        RoomPick.click();

        Address.sendKeys("Da Nang");

        IDchose.click();
        IDCard.click();
        IDNumber.sendKeys("123456789");

        SubmitBtn.click();

    }
}
