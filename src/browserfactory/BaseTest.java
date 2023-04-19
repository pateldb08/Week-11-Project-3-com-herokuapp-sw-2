package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;

    public void openBrowser(String baseurl) {
        driver = new ChromeDriver();
        // launch base url
        driver.get(baseurl);
        // maxixise the window
        driver.manage().window().maximize();
        // Give Implicit time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    public void closeBrowser() {
        driver.quit();
    }
}
