package steps;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import baseClass.BaseUtil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.ChooseOptions;
import pageObjects.DescribeNeeds;
import pageObjects.FilterNavigation;
import pageObjects.Login;
import pageObjects.Logout;
import pageObjects.RequestProcess;
import reusableFunction.Abstract;

public class ReusableSteps extends BaseUtil {

	private static final Logger logger = Logger.getLogger(BaseUtil.class.getName());
	
	public BaseUtil base;
	public Login Login;
	public Logout Logout;
	public FilterNavigation FilterNavigation;
	public DescribeNeeds DescribeNeeds;
	public ChooseOptions ChooseOptions;
	public RequestProcess RequestProcess;
	public Abstract Abstract;
	static String folderName;

	Properties prop = new Properties();
	InputStream input = null;

	public ReusableSteps(BaseUtil base) {

		this.base = base;
		Login = new Login(base.driver);
		Logout = new Logout(base.driver);
		Abstract = new Abstract(base.driver);
	}

	@Given("^Launch Browser and Navigate to CNet URL$")
	public void launch_Browser_and_Navigate_to_CNet_URL() throws Throwable {

		input = new FileInputStream("resources//config//configuration.properties");
		prop.load(input);
		base.driver.manage().window().maximize();
		base.driver.get(prop.getProperty("BaseURL"));
		logger.info("Enter CNet URL in the address bar of the browser");
		
	}

	@Then("^Verify whether Login page is correctly opened or not$")
	public void verify_whether_Login_page_is_correctly_opened_or_not() throws Throwable {

		String runTimePageTitle = base.driver.getTitle();

		String expectediMageHeaderText = "ServiceNow";

		boolean pageValidation = runTimePageTitle.equalsIgnoreCase(expectediMageHeaderText);

		if (pageValidation == false) {

			//Method to capture failed Screenshot
			Abstract.screenshotcapture();
			
			Assert.assertEquals(runTimePageTitle, expectediMageHeaderText);
			logger.info("Verify whether Login page is correctly opened or not");
		}

	}

	@Then("^Switch to MainFrame$")
	public void switch_to_MainFrame() throws Throwable {

		try {

			base.driver.switchTo().frame(Login.switch_to_Main_frame());

			logger.info("Switch to MainFrame");
			
		} catch (WebDriverException e) {

			//Method to capture failed Screenshot
			Abstract.screenshotcapture();

		}
	}

	@When("^Enter Username and Password as \"([^\"]*)\" and \"([^\"]*)\"$")
	public void enter_Username_and_Password_as_and(String Username, String Password) throws Throwable {

		WebElement userID = Abstract.waitUntilConditionSatisfy(base, Login.useridLocator());
		userID.clear();
		userID.sendKeys(Username);
		
		logger.info("Entered Username");

		WebElement password = Abstract.waitUntilConditionSatisfy(base, Login.passwordLocator());
		password.clear();
		password.sendKeys(Password);
		
		logger.info("Entered Password");

		WebElement loginButton = Abstract.waitUntilConditionSatisfy(base, Login.loginButton());
		loginButton.click();
		logger.info("Clicked on Login Button");

	}

	@Then("^Switch to Multiple Window and Select Text as \"([^\"]*)\"$")
	public void HandleMultipleWindows(String lookupValue) throws IOException, InterruptedException {
		try {
			String mainWindow = base.driver.getWindowHandle();
			String windowTitle = base.driver.getTitle();
			Set<String> allWindowHandles = base.driver.getWindowHandles();
			for (String currentWindowHandle : allWindowHandles) {
				if (!currentWindowHandle.equals(mainWindow)) {
					base.driver.switchTo().window(currentWindowHandle);
					try {
						WebDriverWait wait = new WebDriverWait(base.driver, 10);
						wait.until(ExpectedConditions.elementToBeClickable(By.linkText(lookupValue)));
						base.driver.findElement(By.linkText(lookupValue)).click();
						Thread.sleep(1500);
						logger.info("Switch to Multiple Window and Select Text as :" + lookupValue);
					} catch (NoSuchElementException exc) {
						exc.printStackTrace();
					} catch (WebDriverException e) {
						e.printStackTrace();
					}
				}
			}
			base.driver.switchTo().window(mainWindow);
		} catch (NoSuchElementException exc) {
			exc.printStackTrace();
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	@When("^Click on User Menu Dropdown$")
	public void click_on_User_Menu_Dropdown() throws Throwable {
		WebElement userMenuDropdownButton = Abstract.waitUntilConditionSatisfy(base, Logout.user_info_dropdown());
		userMenuDropdownButton.click();
		logger.info("Click on User Menu Dropdown");
	}

	@When("^Click on Logout$")
	public void click_on_Logout() throws Throwable {
		WebElement logoutButton = Abstract.waitUntilConditionSatisfy(base, Logout.logouButtont());
		logoutButton.click();
		logger.info("Click on Logout");
	}

	@Then("^Switch to Multiple Window$")
	public void switchToMultipleWindow() throws IOException, InterruptedException {
		try {
			String mainWindow = base.driver.getWindowHandle();
			String windowTitle = base.driver.getTitle();
			Set<String> allWindowHandles = base.driver.getWindowHandles();
			for (String currentWindowHandle : allWindowHandles) {
				if (!currentWindowHandle.equals(mainWindow)) {
					base.driver.switchTo().window(currentWindowHandle);
					Thread.sleep(1500);
				}
			}
			base.driver.switchTo().window(mainWindow);
			logger.info("Switch to Multiple Window");
		} catch (NoSuchElementException exc) {
			exc.printStackTrace();
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

}
