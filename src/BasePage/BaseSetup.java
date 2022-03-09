package BasePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseSetup {
    private WebDriver driver;
    String driverPath = "C:\\chromedriver.exe";

    // Getter
    public WebDriver getDriver() {
        return driver;
    }
    // Setter
//    @BeforeClass
    public WebDriver setDriver(String appURL) {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(appURL);
        driver.manage().window().maximize();
        return driver;
    }
    //    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
