package com.foysal.cipher;

import java.util.Scanner;

public class AdditiveCipher {
	
	public static String Encryption(String text, int key) {
		
		String result = "";
		
		for(int i = 0; i < text.length(); i++) {
			int intValue = (text.charAt(i)+key-97)%26 +97;
			result += (char)intValue;
		}
		
		System.out.println(result.toUpperCase());
		
		return result.toUpperCase();
	}
	
	public static void Decryption(String text, int key) {
		
		String result = "";
		
		for(int i = 0; i < text.length(); i++) {
			int temp = text.charAt(i) - key - 65;
			
			while(temp < 0) {
				temp += 26;
			}
			
			result += (char)(temp%26 + 65);
		}
		
		System.out.println(result.toLowerCase());
	}
	

	private static final Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Enter your text: ");
		String str = scan.nextLine();
		
		System.out.println("Enter key: ");
		int key = scan.nextInt();
		
		System.out.println("After Encryption: ");
		String encryptedString = Encryption(str, key);
		
//		System.out.println(encryptedString);
		
		System.out.println("After Decryption: ");
		Decryption(encryptedString, key);
		
		
	}

}
