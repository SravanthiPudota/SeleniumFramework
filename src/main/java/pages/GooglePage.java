package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.WaitUtils;

public class GooglePage {
   
	//initializing driver from basetest to pageclass using constructor
	WebDriver driver;
	WaitUtils wait;
	public GooglePage(WebDriver driver) {
		this.driver=driver;
		wait=new WaitUtils(driver);
		//PageFactory.initElements(driver, this);
	}
	
	public GooglePage(ThreadLocal<WebDriver> driver2) {
		// TODO Auto-generated constructor stub
	}

	//locators
	By searchBox=By.name("q");
	
	//actions
	public void search(String text) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")))
            .sendKeys(text);
    }
	
	
}
