package com.foysal.cipher;

import java.util.Scanner;

public class KeylessTranspositionCipher {

	public static void Encryption1(String text) 
	{
		String result = "";

		for (int i = 0; i < text.length(); i += 2) {
			result += text.charAt(i);
		}
		for (int i = 1; i < text.length(); i += 2) {
			result += text.charAt(i);
		}

		System.out.println(result.toUpperCase());
	}

	public static void Encryption2(String text) 
	{
		String result = "";

		int k = 0;
		while (result.length() < text.length()) {
			for (int i = k; i < text.length(); i += 4) {
				result += text.charAt(i);
			}
			k++;
		}

		System.out.println(result.toUpperCase());
	}

	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) 
	{
		System.out.println("Enter your text: ");
		String str = scan.nextLine().replaceAll(" ", "");
		str = str.toLowerCase();
		
		System.out.println("1st Method-Written column by column and transmitted row by row: ");
		Encryption1(str);
		
		System.out.println("2nd Method-Written row by row and transmitted column by column: ");
		Encryption2(str);
	}
		
}

/*

Meet me at the park


output:
MEMATEAKETETHPR

MMTAEEHREAEKTTP
 
 */
