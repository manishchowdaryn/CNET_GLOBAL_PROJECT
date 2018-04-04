package reusableFunction;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cucumber.listener.Reporter;

import baseClass.BaseUtil;
import ru.yandex.qatools.allure.annotations.Step;

public class Abstract extends BaseUtil {

	public static final Logger logg = LoggerFactory.getLogger(Abstract.class);
	public static String folderName;

	public BaseUtil base;

	public Abstract(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

//	public String loadProperty(String property) {
//		ResourceBundle prop;
//		String value = null;
//		try {
//			prop = ResourceBundle.getBundle("test.resources.KWATF");
//			value = prop.getString(property);
//		} catch (MissingResourceException ex) {
//			logg.info("Error loading the properties file: ", ex);
//			if (ex.getMessage().contains("NullPointer")) {
//				try {
//					logg.info("Null Pointer Exception ", ex);
//				} catch (Exception e) {
//					logg.info("Exception: ", e);
//				}
//			}
//		}
//		return value;
//	}
//
//	public boolean doesElementExist(By locator) {
//		return !base.driver.findElements(locator).isEmpty();
//
//	}
//
//	public boolean waitForElementDisplayed(By locator) throws InterruptedException {
//		boolean blnElementExist = false;
//		for (int i = 0; i < 15; i++) {
//			if (blnElementExist)
//				break;
//			if (doesElementExist(locator)) {
//				blnElementExist = true;
//				logg.info("Element Exist");
//				for (int j = 0; j < 30; j++) {
//					if (base.driver.findElement(locator).isDisplayed())
//						return true;
//					else {
//						logg.info("Element Not Displayed in Screen. Checking Again...");
//						TimeUnit.SECONDS.sleep(3);
//					}
//				}
//			} else {
//				logg.info("Element Not Exist. Checking Again...");
//				TimeUnit.SECONDS.sleep(3);
//			}
//		}
//		return false;
//	}
//
//	@Step("Method to Verify Element displaying or not")
//	public boolean isElementDisplayed(By locator) {
//		return !base.driver.findElements(locator).isEmpty();
//
//	}

	@Step("Method to select by text from drop down")
	public void selectTheDropDownList(BaseUtil base, WebElement dropDown, String text) {
		try {
			Select select = new Select(dropDown);
			select.selectByVisibleText(text);
		} catch (NoSuchElementException exc) {
			exc.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Step("Method to wait until condition is satisfied")
	public WebElement waitUntilConditionSatisfy(BaseUtil base, WebElement webElement) throws IOException, AWTException {

		try {
			FluentWait<WebDriver> waitforelement = new FluentWait<WebDriver>(base.driver)
					.withTimeout(60, TimeUnit.SECONDS).pollingEvery(2, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class);
			waitforelement.until(ExpectedConditions.elementToBeClickable(webElement));
		} catch (NoSuchElementException exc) {
			exc.printStackTrace();

		} catch (WebDriverException e) {
			e.printStackTrace();
			//Method to capture failed Screenshot
			screenshotcapture();

		}
		return webElement;
	}

//	@Step("Method to get the Drop down Elements")
//	public List<String> getDropDownElements(WebElement element) {
//		Select selectDropdown = new Select(element);
//		List<WebElement> listOptionDropdown = selectDropdown.getOptions();
//		List<String> listData = new ArrayList<>();
//		for (WebElement webElement : listOptionDropdown) {
//			listData.add(webElement.getText());
//		}
//		return listData;
//	}

//	@Step("Method to get the Drop down Elements and tap on element based on value provided")
//	public void getDropDownElementsandClick(WebElement element, String ValueSelect) {
//		base.driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
//		Select selectDropdown = new Select(element);
//		List<WebElement> listOptionDropdown = selectDropdown.getOptions();
//		for (WebElement item : listOptionDropdown) {
//			System.out.println(item.getText());
//
//			if (item.getText().contains(ValueSelect)) {
//
//				item.click();
//
//			} else {
//
//				System.out.println(ValueSelect + " is not available in the dropdown");
//			}
//		}
//
//	}

	public void screenshotcapture() throws IOException, AWTException {

		folderName = Reporter.createFolder();
		int i = Reporter.takescreenshot();
		Reporter.addScreenCaptureFromPath("./Screenshot" + i + ".jpg");
	}

}
