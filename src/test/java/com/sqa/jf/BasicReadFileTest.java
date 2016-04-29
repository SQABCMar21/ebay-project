package com.sqa.jf;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class BasicReadFileTest {
	public static ArrayList<Object> tests = new ArrayList<Object>();
	public static StringBuilder testString = new StringBuilder();

	public static void main(String[] args) {
		// The name of the file to open.
		String fileNameOld = "temp.txt";
		String fileNameWin = "C:/Users/Jean/Desktop/temp.json";
		String fileNameMac = "/Users/Jean/Desktop/temp.json";
		//// String fileName = "../../../Desktop/temp.json";

		// This will reference one line at a time
		String line = null;
		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(fileNameWin);
			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				// TODO Evalaute the line
				gatherDataString(line);
			}
			evaluateDataString();
			// Always close files.
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileNameWin + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileNameWin + "'");
			// Or we could just do this:
			// ex.printStackTrace();
		}
		displayTests();
	}

	public static void mainNew(String args[]) {

		// String to be scanned to find the pattern.
		String line = "This order was placed for QT3000! OK?";
		String pattern = "(.*)(\\d+)(.*)";

		// Create a Pattern object
		Pattern r = Pattern.compile(pattern);

		// Now create matcher object.
		Matcher m = r.matcher(line);
		if (m.find()) {
			System.out.println("Found value: " + m.group(0));
			System.out.println("Found value: " + m.group(1));
			System.out.println("Found value: " + m.group(2));
		} else {
			System.out.println("NO MATCH");
		}
	}

	private static void displayTests() {
		System.out.println(testString.toString());

	}

	private static void evaluateDataString() {
		// String[] tests = testString.toString().split("},{");
		// for(int i = 0; i < tests.length; i++) {
		// //String[] elements = "\d";
		// "\d+"
		// }
		// String regexString = "\\"\\d+\\"";
		String myString = testString.toString();

		String pattern = "(\")(\\d+)(\")";

		// Create a Pattern object
		Pattern r = Pattern.compile(pattern);

		// Now create matcher object.
		Matcher m = r.matcher(myString);

		while (m.find()) {
			System.out.println("Found value: " + m.group(2));
		}
	}

	private static void gatherDataString(String line) {
		testString.append(line);
		// System.out.println(line);
	}
}
