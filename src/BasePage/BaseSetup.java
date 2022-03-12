package BasePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

// Open driver, open webservice, close driver => use for all objects
public class BaseSetup {
    private WebDriver driver;
    String driverPath = "C:\\chromedriver.exe";

    // Getter
    public WebDriver getDriver() {
        return driver;
    }

    // Setter
    public WebDriver setDriver(String appURL) {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(appURL);
        driver.manage().window().maximize();
        return driver;
    }

    // Close driver method
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
