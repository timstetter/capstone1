package capstone1;
import java.util.Scanner;

public class Validator {

	public static String getString(Scanner scnr, String prompt) {
		System.out.print(prompt);
		String input = scnr.nextLine();
		return input;
	}

	/**
	 * Prompt the user until they enter a valid integer.
	 */
	public static int getInt(Scanner scnr, String prompt) {
		boolean inputIsInvalid = true;
		int input = 0; // <-- we have to put something here to make Java happy.

		do {
			System.out.print(prompt);
			if (scnr.hasNextInt()) {
				input = scnr.nextInt();
				scnr.nextLine(); // <-- clear remainder of line.
				inputIsInvalid = false;
			} else {
				scnr.nextLine(); // <-- clear out bad input
				System.out.println("You must enter a valid integer. Try again");
			}
		} while (inputIsInvalid);
		return input;
	}

	/**
	 * Prompt the user until they enter a valid double.
	 */
	public static double getDouble(Scanner scnr, String prompt) {
		System.out.print(prompt);

		do {
			if (scnr.hasNextDouble()) {
				double input = scnr.nextDouble();
				scnr.nextLine(); // <-- clear remainder of line.
				return input;
			} else {
				System.out.println("You must enter a valid number. Try again");
				System.out.print(prompt);
				scnr.nextLine(); // <-- clear bad input
			}
		} while (true);
	}

	/**
	 * Prompt the user until they enter a valid integer between min and max
	 * inclusive.
	 */
	public static int getIntInRange(Scanner scnr, String prompt, int min, int max) {
		boolean withIn = false;
		int input = getInt(scnr, prompt);

		while (withIn == false) {

			if (input <= max && input >= min) {
				withIn = true;
			} else {
				withIn = false;
				System.out.println("Your number was not within the range " + min + " to " + max + ". Try again.");
				input = getInt(scnr, prompt);
			}
		}
		return input;
	}

	/**
	 * Prompt the user until they enter a valid integer equal to or greater than
	 * min.
	 */
	public static int getIntAtOrAbove(Scanner scnr, String prompt, int min) {
		boolean flag = true;
		int input = 0;
		while (flag) {
			input = getInt(scnr, prompt);
			if (input >= min) {
				flag = false;
			} else {
				System.out.println("Your number must not be less than " + min + ". Try again.");
			}
		}
		return input;
	}

	public static boolean getYesNo(Scanner scnr, String prompt) {
		boolean flag = true;
		boolean isValid = false;
		while (flag) {
			String s = getString(scnr, prompt);
			if (s.equalsIgnoreCase("yes")) {
				isValid = true;
				flag = false;
			} else if (s.equalsIgnoreCase("no")) {
				isValid = false;
				flag = false;
			} else {
				System.out.println("You must enter yes/no");
			}
		}
		return isValid;
	}

}