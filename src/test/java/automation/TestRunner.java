package automation;

import automation.stepdefs.CommonStepDefs;
import cucumber.api.CucumberOptions;

import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import gherkin.deps.com.google.gson.JsonObject;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java. io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/Resources/features",
        glue = { "automation.stepdefs" },
        tags = { "~@Ignore" },
        plugin = {"pretty", "html:target/cucumber-reports/cucumber-pretty","json:target/cucumber-reports/CucumberTestReport.json","rerun:target/cucumber-reports/rerun.txt"}
        )

public class TestRunner extends AbstractTestNGCucumberTests {
    private TestNGCucumberRunner testNGCucumberRunner;
    String browser = "";

    Properties prop;
    Logger logger;
    WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void beforeTest() {
        ArrayList<JsonObject> records;

        logger = Logger.getLogger(CommonStepDefs.class);

    }

    private Properties getTestProperties() throws IOException {
        Properties properties = new Properties();
        InputStream input = null;
        try {
            input = CommonStepDefs.class.getClassLoader().getResourceAsStream("devint.properties");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        properties.load(input);
        return properties;
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {

    }

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature ) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        testNGCucumberRunner.finish();
    }
}

