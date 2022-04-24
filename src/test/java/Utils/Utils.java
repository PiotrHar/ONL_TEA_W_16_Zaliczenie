package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Utils {

    public static WebDriver createChromeDriver() {
        return createDriver("chrome");
    }

    public static WebDriver createFirefoxDriver() {
        return createDriver("firefox");
    }

    public static WebDriver createDriver(String driverName) {

        WebDriver driver;

        if (driverName.equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver",
                    "src/main/resources/drivers/chromedriver.exe");

            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        else if (driverName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver",
                    "src/main/resources/drivers/geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        } else {
            throw new IllegalArgumentException("driverName " + driverName + " is not supported");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;
    }
}