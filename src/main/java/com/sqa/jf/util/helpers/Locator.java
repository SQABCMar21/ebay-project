/**
 *   File Name: Locator.java<br>
 *
 *   Nepton, Jean-francois<br>
 *   Java Boot Camp Exercise<br>
 *   Instructor: Jean-francois Nepton<br>
 *   Created: Apr 21, 2016
 *
 */

package com.sqa.jf.util.helpers;

import java.util.*;

import org.openqa.selenium.*;

/**
 * Locator //ADDD (description of class)
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
public class Locator {

	public static List<WebElement> getByTagName(WebDriver driver, String tagName) {
		return driver.findElements(By.tagName(tagName));
	}

	public static List<WebElement> getCSS(WebDriver driver, String cssSelector) {
		return null;
	}

	public static List<WebElement> getLinks(WebDriver driver) {
		return getByTagName(driver, "a");
	}

	public static List<WebElement> getPictures(WebDriver driver) {
		return getByTagName(driver, "img");
	}

	public static List<WebElement> getTextElements(WebDriver driver, String text) {
		return null;
	}

}
