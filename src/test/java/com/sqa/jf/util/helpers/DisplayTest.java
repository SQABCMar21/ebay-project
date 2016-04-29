/**
 *   File Name: DisplayTest.java<br>
 *
 *   Nepton, Jean-francois<br>
 *   Java Boot Camp Exercise<br>
 *   Instructor: Jean-francois Nepton<br>
 *   Created: Apr 4, 2016
 *
 */

package com.sqa.jf.util.helpers;

import org.testng.annotations.*;

/**
 * DisplayTest //ADDD (description of class)
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
public class DisplayTest {

	static String testName = "JF Display Tests";
	static String userName;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		userName = AppBasics.welcomeUserAndGetUsersName(testName);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		AppBasics.farewellUser(userName, testName);
	}

	/**
	 * Test method for
	 * {@link com.sqa.jf.util.helpers.Display#display2DArray(int[][])}.
	 */
	@Test
	public void testDisplay2DArray() {
		int[][] matrix = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 } };
		Display.display2DArray(matrix);
	}

	/**
	 * Test method for
	 * {@link com.sqa.jf.util.helpers.Display#displayArray(int[])}.
	 */
	@Test(enabled = false)
	public void testDisplayArray() {
		int[] numbers = { 1, 2, 3, 4, 5 };
		Display.displayArray(numbers);
	}

}
