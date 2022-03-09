package TestPage;

import BasePage.BaseSetup;
import PageFactory_Staff.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test_Staff extends BaseSetup {
    WebDriver driver;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    AllBookingsPage allBookingsPage;
    BookingDetailsPage bookingDetailsPage;
    AddGuestInRoomPage addGuestInRoomPage;
    AddGuestDetailsPage addGuestDetailsPage;

    @BeforeClass
    public void setup() {
        driver = setDriver("http://14.176.232.213:8084/admin/login");
        loginPage = new LoginPage(driver);
    }

    @Test(priority = 0)
    public void TestLogin_Successfully() {
        loginPage.loginByStaffAcc("phuongthanhgiang", "123456");
        dashboardPage = new DashboardPage(driver);
        String expectText = "Phuong Thanh Giang";
        String actualText = dashboardPage.getUserName();
        Assert.assertEquals(actualText, expectText);
    }

    @Test(priority = 1)
    public void VerifyPositionName() {
        dashboardPage = new DashboardPage(driver);
        String expectText = "Receptionist";
        String actualText = dashboardPage.getPositionName();
        Assert.assertEquals(actualText, expectText);
    }

    @Test(priority = 2)
    public void VerifyBookingPending() {
        dashboardPage.clickOnBookingBtn();
        allBookingsPage = new AllBookingsPage(driver);

        allBookingsPage.setSearchBox("Pending");
        allBookingsPage = new AllBookingsPage(driver);

        allBookingsPage.clickToEyeIcon();
        bookingDetailsPage = new BookingDetailsPage(driver);

        String expectText = "MAKE CONFIRM";
        String actualText = bookingDetailsPage.getTextMakeConfirmBtn();
        Assert.assertEquals(actualText, expectText);
    }

    @Test(priority = 3)
    public void CheckIn_Successfully() {
        bookingDetailsPage = new BookingDetailsPage(driver);
        bookingDetailsPage.clickOnMakeConfirmBtn();

        bookingDetailsPage = new BookingDetailsPage(driver);
        String expectText = "STAYING";
        String actualText = bookingDetailsPage.getTextStayingBtn().trim();
        Assert.assertEquals(actualText, expectText);
        bookingDetailsPage = new BookingDetailsPage(driver);
    }

    @Test(priority = 4)
    public void AddGuestInRoom_Successfully() {
        bookingDetailsPage.clickGuestInRoomBtn();
        addGuestInRoomPage = new AddGuestInRoomPage(driver);

        addGuestInRoomPage.clickAdNewBtn();
        addGuestDetailsPage = new AddGuestDetailsPage(driver);

        addGuestDetailsPage.inputGuestInRoom();
        bookingDetailsPage = new BookingDetailsPage(driver);

        bookingDetailsPage.clickGuestInRoomBtn();
        addGuestInRoomPage = new AddGuestInRoomPage(driver);
        addGuestInRoomPage.checkNameExisted();
    }

    @Test(priority = 5)
    public void CheckOut_successfully() {
        addGuestInRoomPage.clickDetailsBtn();
        bookingDetailsPage = new BookingDetailsPage(driver);
        bookingDetailsPage.CheckOut();
        String expectText = "SUCCESS";
        String actualText = bookingDetailsPage.getTextSuccessBtn().trim();
        Assert.assertEquals(actualText, expectText);
    }

    @AfterClass
    public void closeBrowser() throws InterruptedException {
        tearDown();
    }
}
