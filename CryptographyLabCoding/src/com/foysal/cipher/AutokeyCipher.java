package com.foysal.cipher;

import java.util.Scanner;

public class AutokeyCipher {
	
	public static String Encryption(String text, int key) {
		
		String result = "";
		
		for(int i = 0; i < text.length(); i++) {
			int temp = text.charAt(i) - 97;
			
			if(i == 0) {
				result += (char)((temp+key)%26 + 97);
			}
			else {
				result += (char)((temp + text.charAt(i-1) - 97)%26 + 97);
			}
		}
		
		System.out.println(result.toUpperCase());
		
		return result.toUpperCase();
	}
	
	public static void Decryption(String text, int key) {
		
		String result = "";
		
		int temp2=0, temp3, next;

	    for(int i=0; i<text.length(); i++)
	    {
	        int temp = text.charAt(i)-65;

	        if(i==0)
	        {
	            temp2 = ((temp - key) % 26);
	            result += (char)(temp2 + 65);
	        }
	        else
	        {
	            temp3=(temp-temp2);

	            while(temp3<0)
	                temp3+=26;

	            next=(temp3%26);
	            temp2=next;
	            result += (char) (next + 65);
	        }
	    }
		
		System.out.println(result.toLowerCase());
	}
	

	private static final Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Enter your text: ");
		String str = scan.nextLine().replaceAll(" ", "");
		str = str.toLowerCase();
		
		System.out.println("Enter key: ");
		int key = scan.nextInt();
		
		System.out.println("After Encryption: ");
		String encryptedString = Encryption(str, key);
		
//		System.out.println(encryptedString);
		
		System.out.println("After Decryption: ");
		Decryption(encryptedString, key);
		
		
	}

}
