package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @Before
    public void setUp() {
        driver.set(new ChromeDriver());
        getDriver().get("https://www.google.com");
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    @After
    public void tearDown() {
        getDriver().quit();
        driver.remove();   
    }
}