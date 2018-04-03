package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import baseClass.BaseUtil;

public class Login extends BaseUtil{

    public BaseUtil base;
    
       public Login(WebDriver driver) {

    	   PageFactory.initElements(driver, this);
    
       }
       
        @FindBy(how = How.ID, using = "gsft_main")
	    public WebElement switch_to_Main_frame;
       
	    @FindBy(how = How.ID, using = "user_name")
	    public WebElement useridLocator;
	
	    @FindBy(how = How.ID, using = "user_password")
	    public WebElement passwordLocator;
	    
	    @FindBy(how = How.ID, using = "sysverb_login")
	    public WebElement loginButton;
  

	    public WebElement useridLocator() {
			return useridLocator;
		}
	
	    public WebElement passwordLocator() {
			return passwordLocator;
		}
	    
	    public WebElement loginButton() {
			return loginButton;
		}
    
	    
	    public WebElement switch_to_Main_frame() {
			return switch_to_Main_frame;
		}
 
   
}