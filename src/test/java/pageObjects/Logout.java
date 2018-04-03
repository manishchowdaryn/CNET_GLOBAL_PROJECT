package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import baseClass.BaseUtil;

public class Logout extends BaseUtil{

    public BaseUtil base;
    
       public Logout(WebDriver driver) {

    	   PageFactory.initElements(driver, this);
    
       }

	    @FindBy(how = How.ID, using = "user_info_dropdown")
	    public WebElement user_info_dropdown;
	
	    @FindBy(how = How.LINK_TEXT, using = "Logout")
	    public WebElement logouButtont;
	    
	 
	    public WebElement user_info_dropdown() {
			return user_info_dropdown;
		}
	
	    public WebElement logouButtont() {
			return logouButtont;
		}
	    
	
   
}