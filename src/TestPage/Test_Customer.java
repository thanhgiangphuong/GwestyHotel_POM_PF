package TestPage;

import BasePage.BaseSetup;
import PageFactory_Customer.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test_Customer extends BaseSetup {
    // initialize objetc variables
    WebDriver driver;
    SearchingPage searchingPage;
    RoomPage roomPage;
    RoomDetailsPage roomDetailsPage;
    BookNowPage bookNowPage;
    PaymentPage paymentPage;
    ConfirmPage confirmPage;

    // Call setup method from BaseSetup class
    @BeforeClass
    public void setup() {
        driver = setDriver("http://14.176.232.213:8084/");
        searchingPage = new SearchingPage(driver);
    }

    // Verify customer searchs room successfully with valid data
    @Test(priority = 0)
    public void SearchRoom_Successfully() {
        // Call searching method from SearchingPage class
        searchingPage.Searching();
        // Return to RoomPage
        roomPage = new RoomPage(driver);
        // Get text and compare
        String expectText = "Rooms";
        String actualText = roomPage.getTextRoomsPage().trim();
        Assert.assertEquals(actualText, expectText);
    }

    // Verify customer book room successfully with valid data
    @Test(priority = 1)
    public void BookRoom_Successfully() {
        // Call clickViewDetailsBtn method from RoomPage class
        roomPage.clickViewDetailsBtn();
        // Return to Room Detail Page
        roomDetailsPage = new RoomDetailsPage(driver);
        // Call clickBookNowBtn method from RoomDetailsPage class
        roomDetailsPage.clickBookNowBtn();
        // Return to Book Now page
        bookNowPage = new BookNowPage(driver);
        // Call inputInfo method from BookNowPage class
        bookNowPage.inputInfo();
        // Return to Payment Page
        paymentPage = new PaymentPage(driver);
        // Get text and compare
        String expectText = "Checkout";
        String actualText = paymentPage.getTextCheckoutTitle().trim();
        Assert.assertEquals(actualText, expectText);
    }

    // Verify customer do payment successfully with valid data
    @Test(priority = 2)
    public void Payment_Successfully() {
        // Call Payment method from PaymentPage class
        paymentPage.Payment();
        // Return to Confirm Page
        confirmPage = new ConfirmPage(driver);
        // Get text and compare
        String expectText = "Confirm";
        String actualText = confirmPage.getTextConfirmTitle().trim();
        Assert.assertEquals(actualText, expectText);
    }

    // Call close driver method from BaseSetup class to end the problem
    @AfterClass
    public void closeBrowser() throws InterruptedException {
        tearDown();
    }
}
