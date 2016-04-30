/**
 *   File Name: BasicAutoTest.java<br>
 *
 *   Nepton, Jean-francois<br>
 *   Java Boot Camp Exercise<br>
 *   Instructor: Jean-francois Nepton<br>
 *   Created: Apr 20, 2016
 *
 */

package com.sqa.jf;

import java.util.*;

import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.opera.*;
import org.openqa.selenium.safari.*;
import org.testng.*;
import org.testng.annotations.*;

import com.sqa.jf.util.helpers.*;

/**
 * BasicAutoTest //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Nepton, Jean-francois
 * @version 1.0.0
 * @since 1.0
 *
 */
public class BasicAutoTest {

	private static String baseURL;

	private static Properties devProps;

	private static String devPropsLocation = "src/main/resources/dev.properties";

	private static WebDriver driver;

	private static Properties sharedMapUI;

	private static String sharedMapUILocation = "src/main/resources/shared-map-ui.properties";

	@DataProvider(name = "UserAccountInfo")
	public static Object[][] getLoginData() {
		// Create a 2D Object with only one level (for one test)
		Object[][] data = new Object[1][];
		// Create a test with 2 elements for username and password
		Object[] test = { devProps.get("username"), devProps.get("password") };
		// Set the array of parameters to be the first element (and only) for
		// the data
		data[0] = test;
		//// System.out.println("Username:" + data[0][0] + " Password:" +
		//// data[0][1]);
		return data;
	}

	@BeforeClass(enabled = false, groups = "chrome")
	public static void setupChrome() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://gmail.com");
		Thread.sleep(1000);
	}

	@BeforeClass(groups = "firefox", dependsOnMethods = "loadProperties")
	public static void setupFirefox() throws InterruptedException {
		driver = new FirefoxDriver();
		driver.get(devProps.getProperty("baseURL"));
	}

	@BeforeClass(enabled = false, groups = "opera")
	public static void setupOpera() throws InterruptedException {
		System.setProperty("webdriver.opera.driver", "drivers/operadriver.exe");
		driver = new OperaDriver();
		driver.get("http://gmail.com");
		Thread.sleep(1000);
	}

	@BeforeClass(enabled = false, groups = "safari")
	public static void setupSafari() throws InterruptedException {
		driver = new SafariDriver();
		driver.get("http://gmail.com");
		Thread.sleep(1000);
	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { 1, "a" }, new Object[] { 2, "b" }, };
	}

	@BeforeClass
	public void loadProperties() {
		sharedMapUI = ConProperties.loadProperties(sharedMapUILocation);
		devProps = ConProperties.loadProperties(devPropsLocation);
	}

	@Test(dataProvider = "dp", priority = 50)
	public void test(Integer n, String s) {
		System.out.println("Test " + n);
	}

	@Test(dataProvider = "UserAccountInfo")
	public void testLogin(String username, String password) throws InterruptedException {
		String expectedString = "Hi Jean-francois!";
		clickSignin();
		enterCredentialsAndLogin(username, password);
		String actualSignInText = retrieveWelcomeMessage();
		Assert.assertEquals(expectedString, actualSignInText);
	}

	/**
	 * @return
	 */
	private String retrieveWelcomeMessage() {
		WebElement signInLink = driver.findElement(By.id("gh-ug"));
		String actualSignInText = signInLink.getText();
		return actualSignInText;
	}

	/**
	 *
	 */
	private void clickSignin() {
		WebElement signInBtn;
		signInBtn = driver.findElement(By.xpath(sharedMapUI.getProperty("signInBtn")));
		signInBtn.click();
	}

	/**
	 * @param username
	 * @param password
	 */
	private void enterCredentialsAndLogin(String username, String password) {
		WebElement usernameFld;
		WebElement passwordFld;
		usernameFld = driver.findElement(By.xpath(sharedMapUI.getProperty("usernameFld")));
		passwordFld = driver.findElement(By.xpath(sharedMapUI.getProperty("passwordFld")));
		usernameFld.sendKeys(username);
		passwordFld.sendKeys(password);
		passwordFld.submit();
	}

	private boolean isElementPresent(By by) {
		try {
			this.driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}