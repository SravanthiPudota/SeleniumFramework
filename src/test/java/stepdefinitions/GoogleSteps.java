package stepdefinitions;

import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.*;
import pages.GooglePage;
import utils.TestListener;

public class GoogleSteps {

    GooglePage page;

    ExtentTest test = TestListener.test;

    @Given("User is on Google page")
    public void user_on_google() {
        test.info("User is on Google page");   
        page = new GooglePage(Hooks.getDriver());
    }

    @When("User enters {string} in search box")
    public void user_search(String text) {
        test.info("User enters: " + text);    
        page.search(text);
    }

    @Then("Results should be displayed")
    public void verify_results() {
        test.info("Results displayed");  
        //intensionally fail to check screenshot
       // org.testng.Assert.fail("For testing screenshot");
        System.out.println("Results displayed for search");
    }
}