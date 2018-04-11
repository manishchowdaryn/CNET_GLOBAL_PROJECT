package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import baseClass.BaseUtil;

public class DescribeNeeds {

	public BaseUtil base;
    
		public DescribeNeeds(WebDriver driver) {

			PageFactory.initElements(driver, this);
 
    	}
    
		
		@FindBy(how = How.LINK_TEXT, using = "Describe Needs")
	    public WebElement describeNeedsText;
		
     	@FindBy(how = How.XPATH, using = ".//*[@id='lookup.IO:66e3d41edbf20300a68fda11cf9619d5']")
	    public WebElement projectLookUP;
         
     	
     	
     	
     	
     	@FindBy(how = How.ID, using = "IO:67c22786db720300a68fda11cf961921")
	    public WebElement environmentInformation;
     	
     	@FindBy(how = How.ID, using = "IO:078610dedbf20300a68fda11cf961950")
	    public WebElement typeOfEnvironment;
     	
     	@FindBy(how = How.ID, using = "IO:55273ce6db720300a68fda11cf9619e1")
	    public WebElement environmentName;
     	
     	@FindBy(how = How.XPATH, using = ".//*[@id='lookup.IO:01677ca6db720300a68fda11cf9619ed']")
	    public WebElement cloudPlatfromLookUp;
     	
     	@FindBy(how = How.XPATH, using = "//LABEL[@class='radio-label'][text()='Use Existing Key Pair']")
	    public WebElement existingKeyPair;
     	
     	@FindBy(how = How.XPATH, using = ".//*[@id='lookup.IO:c0e3a5bfdbc01300a68fda11cf9619c1']")
	    public WebElement selectKeyPair;
     	
     	@FindBy(how = How.ID, using = "ni.IO:c728bc2adb720300a68fda11cf96191a_label")
	    public WebElement webserverChecbox;
     	
     	@FindBy(how = How.ID, using = "IO:4e93d0ecdbc30300a68fda11cf96199b")
	    public WebElement webserverType;
     	
     	@FindBy(how = How.ID, using = "IO:be9d675ddb434300a68fda11cf9619ca")
	    public WebElement containerPlatform;
     	
     	@FindBy(how = How.ID, using = "IO:ef75f866db720300a68fda11cf961967")
	    public WebElement applicationType;
     	
     	@FindBy(how = How.ID, using = "ni.IO:b958b0e6db720300a68fda11cf96190a_label")
	    public WebElement databaseserverChecbox;
     	
     	@FindBy(how = How.ID, using = "IO:972498ecdbc30300a68fda11cf961957")
	    public WebElement databaseserverType;
     	
     	@FindBy(how = How.ID, using = "IO:c37e239ddb434300a68fda11cf9619b6")
	    public WebElement databasecontainerPlatform;
     	
     	@FindBy(how = How.XPATH, using = ".//*[@id='next_page']")
	    public WebElement chooseOptions;
     	

     	public WebElement describeNeedsText() {
			return describeNeedsText;
		}
     	
     	
	    public WebElement projectLookUP() {
			return projectLookUP;
		}
	    
	    public WebElement environmentInformation() {
			return environmentInformation;
		}
	    
	    public WebElement typeOfEnvironment() {
			return typeOfEnvironment;
		}
	    
	    public WebElement environmentName() {
			return environmentName;
		}
	    
	    public WebElement cloudPlatfromLookUp() {
			return cloudPlatfromLookUp;
		}
	    
	    public WebElement existingKeyPair() {
			return existingKeyPair;
		}
	    
	    public WebElement selectKeyPair() {
			return selectKeyPair;
		}
	    
	    public WebElement webserverChecbox() {
			return webserverChecbox;
		}
	    
	    public WebElement webserverType() {
			return webserverType;
		}
	    
	    public WebElement containerPlatform() {
			return containerPlatform;
		}
	    
	    public WebElement applicationType() {
			return applicationType;
		}
	    
	    public WebElement databaseserverChecbox() {
			return databaseserverChecbox;
		}
	    
	    public WebElement databaseserverType() {
			return databaseserverType;
		}
	    
	    public WebElement databasecontainerPlatform() {
			return databasecontainerPlatform;
		}
	    
	
	    public WebElement chooseOptions() {
			return chooseOptions;
		}
	    
}
