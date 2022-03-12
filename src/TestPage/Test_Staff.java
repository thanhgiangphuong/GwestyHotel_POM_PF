package TestPage;

import BasePage.BaseSetup;
import PageFactory_Staff.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test_Staff extends BaseSetup {
    // initialize objetc variables
    WebDriver driver;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    AllBookingsPage allBookingsPage;
    BookingDetailsPage bookingDetailsPage;
    AddGuestInRoomPage addGuestInRoomPage;
    AddGuestDetailsPage addGuestDetailsPage;

    // Call setup method from BaseSetup class
    @BeforeClass
    public void setup() {
        driver = setDriver("http://14.176.232.213:8084/admin/login");
        loginPage = new LoginPage(driver);
    }

    // Verify staff login to system successfully with valid account
    @Test(priority = 0)
    public void TestLogin_Successfully() {
        // Call loginByStaffAcc method from LoginPage class and transfer parameters
        loginPage.loginByStaffAcc("phuongthanhgiang", "123456");
        // Return to Dashboard Page
        dashboardPage = new DashboardPage(driver);
        // Get text and compare
        String expectText = "Phuong Thanh Giang";
        String actualText = dashboardPage.getUserName();
        Assert.assertEquals(actualText, expectText);
    }

    // Verify the position of staff is correct
    @Test(priority = 1)
    public void VerifyPositionName() {
        // Get text and compare
        String expectText = "Receptionist";
        String actualText = dashboardPage.getPositionName();
        Assert.assertEquals(actualText, expectText);
    }

    // Verify the bookings display afer searching are the pending booking, not check in yet
    @Test(priority = 2)
    public void VerifyBookingPending() {
        // Call clickOnBookingBtn method from DashboardPage class
        dashboardPage.clickOnBookingBtn();
        // Return to All Booking Page
        allBookingsPage = new AllBookingsPage(driver);
        // Call setSearchBox method from AllBookingsPage class
        allBookingsPage.setSearchBox("Pending");
        // Call clickToEyeIcon method from AllBookingsPage class
        allBookingsPage.clickToEyeIcon();
        // Return to Booking Detail Page
        bookingDetailsPage = new BookingDetailsPage(driver);
        // Get text and compare
        String expectText = "MAKE CONFIRM";
        String actualText = bookingDetailsPage.getTextMakeConfirmBtn();
        Assert.assertEquals(actualText, expectText);
    }

    // Verify staff make check in for booking successfully
    @Test(priority = 3)
    public void CheckIn_Successfully() {
        // Call clickOnMakeConfirmBtn method from BookingDetailsPage class
        bookingDetailsPage.clickOnMakeConfirmBtn();
        // Get text and compare
        String expectText = "STAYING";
        String actualText = bookingDetailsPage.getTextStayingBtn().trim();
        Assert.assertEquals(actualText, expectText);
    }

    // Verify staff add guest in room successfully with valid data
    @Test(priority = 4)
    public void AddGuestInRoom_Successfully() {
        // Call clickGuestInRoomBtn from BookingDetailsPage class
        bookingDetailsPage.clickGuestInRoomBtn();
        // Return to Add Guest In Room page
        addGuestInRoomPage = new AddGuestInRoomPage(driver);
        // Call clickAdNewBtn method from AddGuestInRoomPage class
        addGuestInRoomPage.clickAdNewBtn();
        // Retturn to Add Guest Detail Page
        addGuestDetailsPage = new AddGuestDetailsPage(driver);
        // Call inputGuestInRoom method from AddGuestDetailsPage class
        addGuestDetailsPage.inputGuestInRoom();
        // Return to Booking Details Page
        bookingDetailsPage = new BookingDetailsPage(driver);
        // Call clickGuestInRoomBtn method from BookingDetailsPage class
        bookingDetailsPage.clickGuestInRoomBtn();
        // Return to Add Guest In Room page
        addGuestInRoomPage = new AddGuestInRoomPage(driver);
        // Call checkNameExisted method from AddGuestInRoomPage class to verify add guest successfully
        addGuestInRoomPage.checkNameExisted();
    }

    // Verify staff check out successfully
    @Test(priority = 5)
    public void CheckOut_successfully() throws InterruptedException {
        // Call clickDetailsBtn method from AddGuestInRoomPage class
        addGuestInRoomPage.clickDetailsBtn();
        // Return to Booking Details Page
        bookingDetailsPage = new BookingDetailsPage(driver);
        // Wait 2 seconds to the system loading
        Thread.sleep(2000);
        // Call CheckOut method from BookingDetailsPage class
        bookingDetailsPage.CheckOut();
        // Get text and compare
        String expectText = "SUCCESS";
        String actualText = bookingDetailsPage.getTextSuccessBtn().trim();
        Assert.assertEquals(actualText, expectText);
    }

    // Call close driver method from BaseSetup class
    @AfterClass
    public void closeBrowser() throws InterruptedException {
        tearDown();
    }
}
