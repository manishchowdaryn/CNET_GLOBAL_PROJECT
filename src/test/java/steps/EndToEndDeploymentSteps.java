package steps;

import static org.junit.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import baseClass.BaseUtil;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.deps.net.iharder.Base64.InputStream;
import pageObjects.ChooseOptions;
import pageObjects.DescribeNeeds;
import pageObjects.FilterNavigation;
import pageObjects.Login;
import pageObjects.Logout;
import pageObjects.RequestProcess;
import reusableFunction.Abstract;

public class EndToEndDeploymentSteps extends BaseUtil {

	private static final Logger logger = Logger.getLogger(ReusableSteps.class.getName());
	
	public BaseUtil base;
	public Login Login;
	public Logout Logout;
	public FilterNavigation FilterNavigation;
	public DescribeNeeds DescribeNeeds;
	public ChooseOptions ChooseOptions;
	public RequestProcess RequestProcess;
	public Abstract Abstract;
	static String folderName;
	static WebElement element;

	Properties prop = new Properties();
	InputStream input = null;

	public EndToEndDeploymentSteps(BaseUtil base) {

		this.base = base;
		Login = new Login(base.driver);
		Logout = new Logout(base.driver);
		FilterNavigation = new FilterNavigation(base.driver);
		DescribeNeeds = new DescribeNeeds(base.driver);
		ChooseOptions = new ChooseOptions(base.driver);
		RequestProcess = new RequestProcess(base.driver);
		Abstract = new Abstract(base.driver);

	}

	@Then("^Verify whether Home page is correctly opened or not$")
	public void verify_whether_Home_page_is_correctly_opened_or_not() throws Throwable {

		// Thread.sleep(10000);
		String homePageTitle = base.driver.getTitle();
		assertEquals("Home page loading... | ServiceNow", homePageTitle);

	}

	@When("^Enter Value in Filter Navigation Field Text Box \"([^\"]*)\"$")
	public void enter_Value_in_Filter_navigation_Field_Text_Box(String searchFilterValue) throws Throwable {

		WebElement searchFilter = Abstract.waitUntilConditionSatisfy(base, FilterNavigation.searchFilter());
		searchFilter.clear();
		searchFilter.sendKeys(searchFilterValue);
		Thread.sleep(10000);

	}

	@When("^Click on Service Catalog Order Guides Link$")
	public void click_On_Service_Catalog_Order_Guides_Link() throws Throwable {

		WebElement serviceCatalogOrderGuide = Abstract.waitUntilConditionSatisfy(base,
				FilterNavigation.serviceCatalogOrderGuide());
		
		serviceCatalogOrderGuide.click();
		serviceCatalogOrderGuide.click();

	}

	@When("^Click on End To End Deployment$")
	public void click_On_End_To_End_Deployment() throws Throwable {

		WebElement endToEndDeployment = Abstract.waitUntilConditionSatisfy(base, FilterNavigation.endToEndDeployment());
		endToEndDeployment.click();

	}

	@Then("^Verify whether Try It button is enabled or not$")
	public void verify_Try_It() throws Throwable {

		WebElement tryIT = Abstract.waitUntilConditionSatisfy(base, FilterNavigation.tryIT());
		Boolean status = tryIT.isEnabled();
		Assert.assertTrue(status);

	}

	@When("^Click on Try It$")
	public void click_On_Try_It() throws Throwable {
		WebElement tryIT = Abstract.waitUntilConditionSatisfy(base, FilterNavigation.tryIT());
		tryIT.click();
	}

	@Then("^Verify whether Describe Needs page is getting displayed or not$")
	public void verifyDescribeNeeds() throws Throwable {

		WebElement describeNeedsValue = Abstract.waitUntilConditionSatisfy(base, DescribeNeeds.describeNeedsText());
		String describeNeedsValueText = describeNeedsValue.getText();
		Assert.assertEquals(describeNeedsValueText, "Describe Needs");

	}

	@When("^Click On Project LookUP$")
	public void click_On_Project_LookUP() throws Throwable {

		WebElement projectLookUP = Abstract.waitUntilConditionSatisfy(base, DescribeNeeds.projectLookUP());
		projectLookUP.click();

	}

	@When("Select Environment Information as \"([^\"]*)\"$")
	public void environmentDropdown(String environmentInformationValue) throws Exception {

		WebElement environmentInformation = Abstract.waitUntilConditionSatisfy(base,
				DescribeNeeds.environmentInformation());
		Abstract.selectTheDropDownList(base, environmentInformation, environmentInformationValue);

	}

	@When("Select Type of Environment as \"([^\"]*)\"$")
	public void typeOfEnvironment(String typeofEnvironmentValue) throws Exception {

		/*
		 * Select typeofEnvironmentValue = new
		 * Select(DescribeNeeds.typeOfEnvironment());
		 * typeofEnvironmentValue.selectByVisibleText(typeofEnvironment);
		 * Thread.sleep(2000);
		 */

		WebElement typeOfEnvironment = Abstract.waitUntilConditionSatisfy(base, DescribeNeeds.typeOfEnvironment());
		Abstract.selectTheDropDownList(base, typeOfEnvironment, typeofEnvironmentValue);

	}

	@When("Select Environment Name as \"([^\"]*)\"$")
	public void environmentName(String environmentName) {
		DescribeNeeds.environmentName().clear();
		DescribeNeeds.environmentName().sendKeys(environmentName);
	}

	@When("^Click On Cloud Platform$")
	public void click_On_Cloud_Platform() throws Throwable {

		WebElement cloudPlatformLookUP = Abstract.waitUntilConditionSatisfy(base, DescribeNeeds.cloudPlatfromLookUp());
		cloudPlatformLookUP.click();

	}

	@When("^Select Existing Key Pair Checkbox$")
	public void select_Existing_Key_Pair() throws Throwable {

		WebElement existingKeyPairElement = Abstract.waitUntilConditionSatisfy(base, DescribeNeeds.existingKeyPair());
		existingKeyPairElement.click();

	}

	@When("^Click On Select Key Pair$")
	public void click_On_Select_Key_Pair() throws Throwable {

		WebElement selectKeyPairLookUP = Abstract.waitUntilConditionSatisfy(base, DescribeNeeds.selectKeyPair());
		selectKeyPairLookUP.click();

	}

	@When("^Select WebServer Checkbox$")
	public void select_WebServer() throws Throwable {

		WebElement webServerCheckbox = Abstract.waitUntilConditionSatisfy(base, DescribeNeeds.webserverChecbox());
		webServerCheckbox.click();

	}

	@When("^Select Webserver Type as \"([^\"]*)\"$")
	public void select_webServer_Type(String webserverTypeValue) throws IOException, AWTException {

		WebElement webserverType = Abstract.waitUntilConditionSatisfy(base, DescribeNeeds.webserverType());
		Abstract.selectTheDropDownList(base, webserverType, webserverTypeValue);

	}

	@When("^Select Container Platform as \"([^\"]*)\"$")
	public void select_Container_Platform(String containerPlatformValue) throws IOException, AWTException {

		WebElement containerPlatform = Abstract.waitUntilConditionSatisfy(base, DescribeNeeds.containerPlatform());
		Abstract.selectTheDropDownList(base, containerPlatform, containerPlatformValue);

	}

	@When("^Select Database Server Checkbox$")
	public void select_Database_Server() throws Throwable {

		WebElement databaseServerCheckbox = Abstract.waitUntilConditionSatisfy(base,
				DescribeNeeds.databaseserverChecbox());
		databaseServerCheckbox.click();

	}

	@When("^Select Database Type as \"([^\"]*)\"$")
	public void select_Database_Type(String databaseserverTypeValue) throws IOException, AWTException {

		WebElement databaseServerType = Abstract.waitUntilConditionSatisfy(base, DescribeNeeds.databaseserverType());
		Abstract.selectTheDropDownList(base, databaseServerType, databaseserverTypeValue);

	}

	@When("^Select Database Container Platform as \"([^\"]*)\"$")
	public void select_Database_Container_Platform(String databasecontainerPlatformValue)
			throws IOException, AWTException {

		WebElement databasecontainerPlatform = Abstract.waitUntilConditionSatisfy(base,
				DescribeNeeds.databasecontainerPlatform());
		Abstract.selectTheDropDownList(base, databasecontainerPlatform, databasecontainerPlatformValue);

	}

	@When("^Select Application Type as \"([^\"]*)\"$")
	public void select_Application_Type(String applicationTypeValue) throws IOException, AWTException {

		WebElement applicationType = Abstract.waitUntilConditionSatisfy(base, DescribeNeeds.applicationType());
		Abstract.selectTheDropDownList(base, applicationType, applicationTypeValue);

	}

	@When("^Click on Choose Options$")
	public void click_On_Choose_Options() throws Throwable {

		WebElement chooseOptions = Abstract.waitUntilConditionSatisfy(base, DescribeNeeds.chooseOptions());
		chooseOptions.click();

	}

	@Then("^Verify whether Choose Options page is getting displayed or not$")
	public void verifyChooseOptions() throws Throwable {

		WebElement chooseOptions = Abstract.waitUntilConditionSatisfy(base, ChooseOptions.chooseOptions());
		String chooseOptionsText = chooseOptions.getText();
		assertEquals(chooseOptionsText, "Choose Options");
		Thread.sleep(5000);

	}

	@When("^Click On Server Requested LookUP$")
	public void click_On_Server_Requested() throws Throwable {

		WebElement serverRequestedLookUP = Abstract.waitUntilConditionSatisfy(base,
				ChooseOptions.serviceRequestedLookUp());
		serverRequestedLookUP.click();

	}

	@When("Enter Cluster Name as \"([^\"]*)\"$")
	public void enter_Cluster_Name(String clusterNameValue) throws Exception {

		ChooseOptions.clusterName().clear();
		ChooseOptions.clusterName().sendKeys(clusterNameValue);

	}

	@When("^Select Existing Network Checkbox$")
	public void select_Existing_Network_Checkbox() throws Throwable {

		WebElement selectNetworkexistingKeyPair = Abstract.waitUntilConditionSatisfy(base,
				ChooseOptions.selectNetworkexistingKeyPair());
		selectNetworkexistingKeyPair.click();

	}

	@When("^Click On Select Network$")
	public void click_On_Select_Network() throws Throwable {

		WebElement selectNetworkLookUP = Abstract.waitUntilConditionSatisfy(base, ChooseOptions.selectNetworkLookUP());
		selectNetworkLookUP.click();

	}

	@When("^Select Security Group Checkbox$")
	public void select_Security_Group_Checkbox() throws Throwable {

		WebElement securityGroup = Abstract.waitUntilConditionSatisfy(base, ChooseOptions.securityGroup());
		securityGroup.click();

	}

	@When("^Click On Security Group$")
	public void click_On_Security_Group() throws Throwable {

		WebElement securityGroupLookUp = Abstract.waitUntilConditionSatisfy(base, ChooseOptions.securityGroupLookUp());
		securityGroupLookUp.click();

	}

	@When("^Click On Operating System LookUP$")
	public void click_On_Operating_System() throws Throwable {

		WebElement operatingSystemLookUp = Abstract.waitUntilConditionSatisfy(base,
				ChooseOptions.operatingSystemLookUp());
		operatingSystemLookUp.click();

	}

	@When("^Click On Server Size LookUP$")
	public void click_On_Server_Size() throws Throwable {

		WebElement serverSizeLookUp = Abstract.waitUntilConditionSatisfy(base, ChooseOptions.serverSizeLookUp());
		serverSizeLookUp.click();

	}
	
	@When("^Select Additional Storage as \"([^\"]*)\" and \"([^\"]*)\"  and \"([^\"]*)\"  and \"([^\"]*)\"$")
	public void select_Additional_Storage_as_and_and_and(String storageType, String typeofStorage, String EC2MountPath,
			String bucketName) throws Throwable {
		WebElement storageTypeVar = Abstract.waitUntilConditionSatisfy(base, ChooseOptions.storageType());
		Abstract.selectTheDropDownList(base, storageTypeVar, storageType);

		if (storageType.equalsIgnoreCase("Yes")) {

			WebElement typeofStorageVar = Abstract.waitUntilConditionSatisfy(base, ChooseOptions.typeofStorage());
			Abstract.selectTheDropDownList(base, typeofStorageVar, typeofStorage);

			WebElement EC2MountPathVar = Abstract.waitUntilConditionSatisfy(base, ChooseOptions.EC2MountPath());
			EC2MountPathVar.sendKeys(EC2MountPath);

			WebElement bucketNameVar = Abstract.waitUntilConditionSatisfy(base, ChooseOptions.bucketName());
			bucketNameVar.sendKeys(bucketName);
		}
	}

	@When("Select Monitoring Information as \"([^\"]*)\"$")
	public void select_Monitoring_Information_as(String monitoringInformation) throws Exception {

		WebElement monitoringInformationVar = Abstract.waitUntilConditionSatisfy(base, ChooseOptions.monitoringInformationLoc());
		Abstract.selectTheDropDownList(base, monitoringInformationVar, monitoringInformation);
		
	}

	@When("Select Auto Scaling as \"([^\"]*)\"$")
	public void select_Auto_Scaling_as(String autoScalingType) throws Exception {

		WebElement autoScalingTypeVar = Abstract.waitUntilConditionSatisfy(base, ChooseOptions.autoScaling());
		Abstract.selectTheDropDownList(base, autoScalingTypeVar, autoScalingType);

	}
	
	
	
	

	@When("^Click On Next Tab$")
	public void click_On_Next_Tab() throws Throwable {

		WebElement nextTab = Abstract.waitUntilConditionSatisfy(base, ChooseOptions.nextTab());
		nextTab.click();
		Thread.sleep(5000);

	}

	@When("^Select Database Network Configuration Checkbox$")
	public void select_Database_Network_Configuration_Checkbox() throws Throwable {

		WebElement databaseselectNetworkexistingKeyPair = Abstract.waitUntilConditionSatisfy(base,
				ChooseOptions.databaseselectNetworkexistingKeyPair());
		databaseselectNetworkexistingKeyPair.click();

	}

	@When("^Click On Database Network Configuration Group$")
	public void click_On_Database_Network_Configuration_Group() throws Throwable {

		WebElement databaseselectNetworkLookUP = Abstract.waitUntilConditionSatisfy(base,
				ChooseOptions.databaseselectNetworkLookUP());
		databaseselectNetworkLookUP.click();

	}

	@When("^Select Database Security Group Checkbox$")
	public void select_Database_Security_Group_Checkbox() throws Throwable {

		WebElement databaseSecurityGroup = Abstract.waitUntilConditionSatisfy(base,
				ChooseOptions.databaseSecurityGroup());
		databaseSecurityGroup.click();

	}

	@When("^Click On Database Security Group$")
	public void click_On_Database_Security_Group() throws Throwable {

		WebElement databaseSecurityGroupLookUP = Abstract.waitUntilConditionSatisfy(base,
				ChooseOptions.databaseSecurityGroupLookUP());
		databaseSecurityGroupLookUP.click();

	}

	@When("^Click On Database Service Requested LookUP$")
	public void click_On_Database_Service_Requested() throws Throwable {

		WebElement databaseServiceRequestedLookUp = Abstract.waitUntilConditionSatisfy(base,
				ChooseOptions.databaseServiceRequestedLookUp());
		databaseServiceRequestedLookUp.click();

	}

	@When("Enter Database Cluster Name as \"([^\"]*)\"$")
	public void enter_Database_Cluster_Name(String databaseClusterNameValue) throws Exception {

		ChooseOptions.databaseClusterName().clear();
		ChooseOptions.databaseClusterName().sendKeys(databaseClusterNameValue);

	}

	@When("^Click On Database Operating System LookUP$")
	public void click_On_Database_Operating_System() throws Throwable {

		WebElement databaseOperatingSystemLookUp = Abstract.waitUntilConditionSatisfy(base,
				ChooseOptions.databaseOperatingSystemLookUp());
		databaseOperatingSystemLookUp.click();

	}

	@When("^Click On Check Out$")
	public void click_On_Check_Out() throws Throwable {

		WebElement checkOut = Abstract.waitUntilConditionSatisfy(base, ChooseOptions.checkOut());
		checkOut.click();
		Thread.sleep(5000);

	}

	@Then("^Verify whether Shopping Cart page is getting displayed or not$")
	public void verifyCheckOut() throws Throwable {

		WebElement shoppingCart = Abstract.waitUntilConditionSatisfy(base, ChooseOptions.shoppingCart());
		String shoppingCartText = shoppingCart.getText();
		assertEquals(shoppingCartText, "Shopping Cart");

	}

	@When("^Click on Order Now$")
	public void click_on_Order_Now() throws Throwable {

		WebElement orderNow = Abstract.waitUntilConditionSatisfy(base, ChooseOptions.orderNow());
		orderNow.click();

	}

	@Then("^Validate Successful Message is displayed or not$")
	public void validate_Successful_Message() throws Throwable {

		WebElement successMessage = Abstract.waitUntilConditionSatisfy(base, ChooseOptions.successMessage());
		String successMessageValue = successMessage.getText();
		assertEquals(successMessageValue, "Thank you, your request has been submitted");

	}

	@When("^Get the Request Number after created$")
	public void get_Request_Number() throws Throwable {

		WebElement requestNumber = Abstract.waitUntilConditionSatisfy(base, ChooseOptions.getRequestNumber());
		String requestNumberValue = requestNumber.getText();
		System.out.println(requestNumberValue);

	}

	@Then("^Click On Recently Created Requested Number$")
	public void click_On_Request_Number() throws Throwable {

		WebElement requestNumber = Abstract.waitUntilConditionSatisfy(base, ChooseOptions.getRequestNumber());
		requestNumber.click();

	}

	@When("^Click on RITM Numbers and Approve all RITM Numbers for the Request Created$")
	public void click_RITM_Numbers() throws Throwable {

		Thread.sleep(5000);

		//WebElement ritmNumber = Abstract.waitUntilConditionSatisfy(base, RequestProcess.RITMNumbers());

		List<WebElement> ritmNumberValue = base.driver.findElements(By.xpath(
				"html/body/div[2]/div[2]/div/div[1]/span/div[2]/div[4]/table[1]/tbody/tr/td/div/table/tbody/tr/td[3]/a"));
		System.out.println(ritmNumberValue.size());

		for (int i = 1; i <= ritmNumberValue.size(); i++) {

			WebElement ritmLinkText = base.driver.findElement(By.xpath(
					"html/body/div[2]/div[2]/div/div[1]/span/div[2]/div[4]/table[1]/tbody/tr/td/div/table/tbody/tr[" + i
							+ "]/td[3]/a"));
			
			Thread.sleep(5000);
			
			ritmLinkText.click();

			Thread.sleep(5000);
			
			WebElement approveTab = Abstract.waitUntilConditionSatisfy(base, RequestProcess.approveTab());
			approveTab.click();

			Thread.sleep(5000);
			
			WebElement requestButton = Abstract.waitUntilConditionSatisfy(base, RequestProcess.requestButton());
			requestButton.click();

			Thread.sleep(5000);
			
			try {

				WebElement approveState = Abstract.waitUntilConditionSatisfy(base, RequestProcess.approveDropdown());
				Abstract.selectTheDropDownList(base, approveState, "Approved");
				Thread.sleep(5000);

			} catch (UnhandledAlertException e) {

				base.driver.switchTo().alert().accept();

				// Thread.sleep(2000);

				WebElement approveState = Abstract.waitUntilConditionSatisfy(base, RequestProcess.approveDropdown());
				Abstract.selectTheDropDownList(base, approveState, "Approved");
				Thread.sleep(5000);

			}

			WebElement updateButton = Abstract.waitUntilConditionSatisfy(base, RequestProcess.updateButton());
			updateButton.click();
			Thread.sleep(5000);

			WebElement updateButton1 = Abstract.waitUntilConditionSatisfy(base, RequestProcess.updateButton());
			updateButton1.click();
			Thread.sleep(5000);

		}

		base.driver.findElement(By.id("sysverb_update")).click();
		Thread.sleep(5000);
	}

	@When("^Search Request in a CMDB Table as \"([^\"]*)\"$")
	public void search_Request_CMDB(String searchFilterValue) throws Throwable {
		FilterNavigation.searchFilterClick().click();

		WebElement searchFilter = Abstract.waitUntilConditionSatisfy(base, FilterNavigation.searchFilter());
		searchFilter.sendKeys(searchFilterValue);
		searchFilter.sendKeys(Keys.ENTER);

	}

}
