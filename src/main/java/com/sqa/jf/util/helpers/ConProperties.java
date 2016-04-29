/**
 *   File Name: ConProperties.java<br>
 *
 *   Nepton, Jean-francois<br>
 *   Java Boot Camp Exercise<br>
 *   Instructor: Jean-francois Nepton<br>
 *   Created: Apr 27, 2016
 *
 */

package com.sqa.jf.util.helpers;

import java.io.*;
import java.util.*;

/**
 * ConProperties //ADDD (description of class)
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
public class ConProperties {

	// Method to load properties
	public static Properties loadProperties(String fileLocation) {
		// Create a Properties object
		Properties props = new Properties();

		try {
			// Create a FileInputStream by passing in a fileLocation
			InputStream is = new FileInputStream(fileLocation);
			// Load the properties based on a fileLocation
			props.load(is);
		} catch (FileNotFoundException e) {
			// TODO: handle exception
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Return the properties object loaded
		return props;
	}
}
