package baseClass;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

public class BaseUtil {

	public WebDriver driver;

	private static final Logger logger = Logger.getLogger(BaseUtil.class.getName());
	
	@BeforeTest
	public void loadlog4J(){
		String log4jConfPath = System.getProperty("user.dir")+"/src/test/java/log4J.properties";
		PropertyConfigurator.configure(log4jConfPath);
	}

}
