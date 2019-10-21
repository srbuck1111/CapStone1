/*
 * Author: Sean Buck
 */

package co.grandcircus;

import java.util.Scanner;

public class PigLatinTranslator {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int wordCount = 0;
		
		String ans = "n";
		String input = null;
		
		String[] words;
		
		do {
			
		System.out.println("Enter your sentence:");
		input = scan.nextLine();
		System.out.println();

		words = toWordArray(input);
		
		String word = "";
		
		for (String i : words) {

			wordCount++;
			
			i = i.toLowerCase();
			
			if (isOnlyLetter(i)) {
			
			word = toPig(i, getVowel(i)) + " ";

			} else {
				
			word = i + " ";	
				
			}
			
			if (wordCount == 1) {
				
				word = firstLetterToCapital(word) + " ";
				
			}
			
			System.out.print(word);
			
		}
		
		System.out.println("\n\nAgain? (y/n)\n");
		ans = scan.nextLine();
		
		System.out.println();
		
		} while (ans.equalsIgnoreCase("y"));
		
		scan.close();

	}

	public static boolean isOnlyLetter(String word) {
		
		for (int i = 0; i < word.length(); i++) {
			
			char letter = word.charAt(i);
			
			if (!Character.isLetter(letter) & letter != '\'') {
				
				return false;
				
			}
			
		}
		
		return true;
		
	}
	
	public static String firstLetterToCapital(String word) {
		
		String[] wordArr = word.toLowerCase().split("", 2);
		
		wordArr[0] = wordArr[0].toUpperCase();
		
		word = wordArr[0] + wordArr[1];
		
		return word;
		
	}

	public static String[] toWordArray(String sentence) {

		String[] words = sentence.split(" ");

		return words;

	}

	public static char getVowel(String word) {

		char letter = ' ';

		for (int i = 0; i < word.length(); i++) {

			letter = word.charAt(i);

			if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u') {

				break;

			}

		}

		return letter;

	}

	public static String toPig(String word, char letter) {
		
		String[] wordArr;
		
		String pigWord = null;

		wordArr = word.split(Character.toString(letter), 2);
		
		if (wordArr[0].length() > 0) {

			wordArr[1] = letter + wordArr[1];
			
			pigWord = wordArr[1] + wordArr[0] + "ay";
			
		} else {

			wordArr[1] = letter + wordArr[1];
			
			pigWord = wordArr[1] + wordArr[0] + "way";
			
		}
		
		return pigWord;

	}

}
