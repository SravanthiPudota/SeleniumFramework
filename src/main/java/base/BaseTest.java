package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.ConfigReader;

public class BaseTest {

    public WebDriver driver;
    ConfigReader config;

    @BeforeMethod
    public void setup() {

        config = new ConfigReader();

        String browser = "chrome";
        String url = "https://www.google.com";

        System.out.println("Browser: " + browser);
        System.out.println("URL: " + url);

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.get(url);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}