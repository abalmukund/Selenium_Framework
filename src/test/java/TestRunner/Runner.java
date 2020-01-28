package TestRunner;

import java.io.File;

import org.apache.commons.lang3.SystemUtils;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;
import com.test.constants.TestConstants;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src//test//java//Features",
glue= {"StepDefinition"},
plugin = {
		//Different types of console reports:
		/*"pretty", 
		"json:target/cucumber-reports/Cucumber.json",
		"junit:target/cucumber-reports/Cucumber.xml",
		"html:target/cucumber-reports",*/
		"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html",
//		"json:target/jsonReports/cucumber-report.json"
		} 
//Monochrome reporting:
/*,monochrome = true*/
)
public class Runner {

	@AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File(TestConstants.REPORT_CONFIGURATION_FILE));
        Reporter.setSystemInfo("User Name", SystemUtils.USER_NAME);
        Reporter.setSystemInfo("Time Zone", SystemUtils.USER_TIMEZONE);
        Reporter.setSystemInfo("System OS", SystemUtils.OS_NAME + " " + SystemUtils.OS_ARCH);
        Reporter.setSystemInfo("Selenium", "3.14.0");
        Reporter.setSystemInfo("Maven", "4.0.0");
        Reporter.setSystemInfo("Java Version", SystemUtils.JAVA_VERSION);
    }
}
