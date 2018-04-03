package runner;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.gherkin.model.Scenario;
import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = {
		"resources/features" }, monochrome = true, glue = "steps", tags = "@EndToEndDeploymentFlow, @WebserverType,@DatabaseServiceType", plugin = {
				"html:target/site/cucumber-report-html", "json:target/cucumber.json",
				"pretty:target/cucumber-pretty.txt", "usage:target/cucumber-usage.json",
				"com.cucumber.listener.ExtentCucumberFormatter:" })

public class RunCukes extends AbstractTestNGCucumberTests {

	@BeforeClass
	public static void setup() {
		ExtentProperties extentProperties = ExtentProperties.INSTANCE;
		extentProperties.getReportPath();
	}

	@AfterClass
	public static void teardown() throws IOException, AWTException {
		Reporter.loadXMLConfig(new File("extent-config.xml"));
		Reporter.setSystemInfo("user", System.getProperty("user.name"));
		Reporter.setSystemInfo("os", "Windows 7");
	}

}
