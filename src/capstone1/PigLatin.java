package capstone1;

import java.util.Scanner;

public class PigLatin {
	
	public static Scanner scnr = new Scanner(System.in);
	
	public static void main (String[] args) {
		boolean keepRunning = true;

		System.out.println("Welcome to the Pig Latin Translator!");

		do {
			System.out.println("Please enter a word:");

			String userInput = scnr.nextLine();

			String lowerCaseInput = userInput.toLowerCase();		
			
			System.out.println(wordToPigLatin(lowerCaseInput));			
			
			keepRunning = Validator.getYesNo(scnr, "Translate again? (yes/no): ");

		} while (keepRunning);

		scnr.close();
	}

	private static String wordToPigLatin(String word) {
		String pigLatin = "";
		boolean isvowel = firstCharisVowel(word.charAt(0));
		
		if (isvowel) {
			pigLatin += word + "way";
		} else {
			String consonantcluster = getConsonants(word);
			pigLatin += word.substring(word.indexOf(consonantcluster) + consonantcluster.length()) + consonantcluster
					+ "ay";
		}
		
		return pigLatin;
	}

	private static String getConsonants(String in) {
		String consonants = "";
		for (int i = 0; i < in.length(); i++) {
			char current_char = in.charAt(i);
			if (firstCharisVowel(current_char)) {
				break;
			} else {
				consonants += current_char;
			}
		}
		return consonants;
	}
	
	public static boolean isLowerVowel(char in) {
		return "aeiou".indexOf(in) != -1;
	}

	private static boolean firstCharisVowel(char firstcharacter) {

		boolean isvowel = false;
		String vowels = "aeiou";
		for (int i = 0; i < vowels.length(); i++) {
			char character = vowels.charAt(i);
			if (character == firstcharacter) {
				isvowel = true;
				break;
			}
		}

		return isvowel;
	}

}