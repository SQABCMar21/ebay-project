/**
 *   File Name: MyMathTests.java<br>
 *
 *   Nepton, Jean-francois<br>
 *   Java Boot Camp Exercise<br>
 *   Instructor: Jean-francois Nepton<br>
 *   Created: Apr 13, 2016
 *
 */

package com.sqa.jf.util.helpers.math;

import static org.testng.Assert.*;

import org.testng.annotations.*;

import com.sqa.jf.util.helpers.*;

/**
 * MyMathTests //ADDD (description of class)
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

public class PowerTests {

	@DataProvider(name = "Power Data")
	public static Object[][] getPowerData() {
		Object[][] data = { { 2.0, 2.0, 4.0 }, { 5.0, 2.0, 25.0 }, { 4.0, 3.0, 64.0 }, { 1.0, 0.0, 1.0 },
				{ 3.0, 1.0, 3.0 }, { 2.0, 1.5, 3.25 } };
		return data;
	}

	@Test(dataProvider = "Power Data")
	public void testPowerNumbers(double num, double power, double expectedResult) {
		double actualResult;
		actualResult = MyMath.powerNumber(num, power);
		String message = String.format("The result of %.0f to the power of %.0f is %.0f", num, power, actualResult);
		System.out.println(message);
		// TestNG PArams: Actual, Expected, Delta, Message
		assertEquals(actualResult, expectedResult, 0, message);

	}
}
