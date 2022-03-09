package TestPage;

import BasePage.BaseSetup;
import PageFactory_Customer.*;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test_Customer extends BaseSetup {
    WebDriver driver;
    SearchingPage searchingPage;
    RoomPage roomPage;
    RoomDetailsPage roomDetailsPage;
    BookNowPage bookNowPage;
    PaymentPage paymentPage;
    ConfirmPage confirmPage;

    @BeforeClass
    public void setup() {
        driver = setDriver("http://14.176.232.213:8084/");
        searchingPage = new SearchingPage(driver);
    }
    @Test(priority = 0)
    public void SearchRoom_Successfully(){
        searchingPage.Searching();
        roomPage = new RoomPage(driver);
        String expectText = "Rooms";
        String actualText = roomPage.getTextRoomsPage().trim();
        Assert.assertEquals(actualText, expectText);
    }
    @Test(priority = 1)
    public void BookRoom_Successfully(){
        roomPage.clickViewDetailsBtn();
        roomDetailsPage = new RoomDetailsPage(driver);

        roomDetailsPage.clickBookNowBtn();
        bookNowPage = new BookNowPage(driver);

        bookNowPage.inputInfo();
        paymentPage = new PaymentPage(driver);

        String expectText = "Checkout";
        String actualText = paymentPage.getTextCheckoutTitle().trim();
        Assert.assertEquals(actualText, expectText);
    }
    @Test(priority = 2)
    public void Payment_Successfully(){
        paymentPage.Payment();
        confirmPage = new ConfirmPage(driver);
        String expectText = "Confirm";
        String actualText = confirmPage.getTextConfirmTitle().trim();
        Assert.assertEquals(actualText, expectText);
    }

    @AfterClass
    public void closeBrowser() throws InterruptedException {
        tearDown();
    }
}
