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
import org.openqa.selenium.firefox.*;
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
public class LocatorTests {

	static WebDriver driver;

	@BeforeClass
	public static void setupFirefox() throws InterruptedException {
		driver = new FirefoxDriver();
	}

	@Test(priority = 1)
	public void test1() {
		String pageTitle = "MSN.com - Hotmail, Outlook, Skype, Bing, Latest News, Photos & Videos";
		driver.get("http://msn.com");
		Assert.assertEquals(driver.getTitle(), pageTitle, "Page load does not seem successful.");
	}

	@Test(priority = 2)
	public void test2() {
		List<WebElement> links = Locator.getLinks(this.driver);
		int i = 1;
		for (WebElement link : links) {
			String text = link.getText();
			if (text.isEmpty()) {
				text = "Non-text Element (" + i + ")";
				i++;
			}
			System.out.println(link.getText() + " - " + link.getAttribute("href"));
		}
	}
}