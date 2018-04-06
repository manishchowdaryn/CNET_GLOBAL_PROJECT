package runner;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

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
		"resources/features" }, monochrome = true, glue = "steps", tags = "@EndToEndDeploymentFlow", plugin = {
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
		
		ExtentProperties extentProperties = ExtentProperties.INSTANCE;
		String reportPath = extentProperties.getReportPath().replace("report.html", "");

		String sourceFile = System.getProperty("user.dir") + "\\" + reportPath;
		File srcDir = new File(sourceFile);

		String destinationFile = System.getProperty("user.dir") + "\\ExtentReport\\CurrentReport";
		File destinationDir = new File(destinationFile);

		PrintWriter writer = new PrintWriter(System.getProperty("user.dir") + "\\ExtentReport\\currentReport.bat", "UTF-8");
		writer.println("xcopy /s /y " + sourceFile + "*.* " + destinationDir);
		writer.close();

	}
}
