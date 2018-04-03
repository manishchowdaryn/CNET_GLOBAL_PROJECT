package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import baseClass.BaseUtil;

public class RequestProcess {

	public BaseUtil base;
    
		public RequestProcess(WebDriver driver) {

			PageFactory.initElements(driver, this);
 
    	}
    
     	@FindBy(how = How.XPATH, using = "html/body/div[2]/div[2]/div/div[1]/span/div[2]/div[4]/table[1]/tbody/tr/td/div/table/tbody/tr/td[3]/a")
	    public WebElement RITMNumbers;
       
     	@FindBy(how = How.XPATH, using = "//div[@id='tabs2_list']/span[2]/span/span[2]")
	    public WebElement approveTab;
     	
     	@FindBy(how = How.XPATH, using = "//a[text()='Test User']//preceding::a[1]")
	    public WebElement requestButton;
     	
     	@FindBy(how = How.XPATH, using = ".//*[@id='sysapproval_approver.state']")
	    public WebElement approveDropdown;
     	
     	@FindBy(how = How.XPATH, using = ".//*[@id='sysverb_update']") 
	    public WebElement updateButton;
     	
     	
	    public WebElement RITMNumbers() {
			return RITMNumbers;
		}
	    
	    public WebElement approveTab() {
			return approveTab;
		}
	    
	    public WebElement requestButton() {
			return requestButton;
		}
	    
	    public WebElement approveDropdown() {
			return approveDropdown;
		}
	    
	    public WebElement updateButton() {
			return updateButton;
		}
	   
	    
	   
}
