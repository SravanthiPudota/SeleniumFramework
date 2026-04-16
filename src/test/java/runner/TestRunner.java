package runner;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@Listeners(utils.TestListener.class)
@CucumberOptions(
    features = "src/test/java/features",
    glue = "stepdefinitions",
    plugin = {"pretty", "html:target/cucumber-report.html"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
	// 🔥 THIS IS THE KEY FOR PARALLEL
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}