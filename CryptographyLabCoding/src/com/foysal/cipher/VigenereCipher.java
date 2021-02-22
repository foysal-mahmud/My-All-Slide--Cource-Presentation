package com.foysal.cipher;

import java.util.Scanner;

public class VigenereCipher {
	
	public static String generateKey(String str, String key) 
	{ 
	    int x = str.length(); 
	  
	    for (int i = 0; ; i++) 
	    { 
	        if (x == i) 
	            i = 0; 
	        if (key.length() == str.length()) 
	            break; 
	        key+=(key.charAt(i)); 
	    } 
	    return key; 
	} 
	  
	public static String Encryption(String str, String key) 
	{ 
	    String cipher_text=""; 
	  
	    for (int i = 0; i < str.length(); i++) 
	    {
	        int x = (str.charAt(i) + key.charAt(i)) %26; 
	        x += 'A'; 
	        cipher_text+=(char)(x); 
	    } 
	    
	    return cipher_text; 
	} 
	  
	 
	public static String Decryption(String cipher_text, String key) 
	{ 
	    String original_text=""; 
	  
	    for (int i = 0 ; i < cipher_text.length() && i < key.length(); i++) 
	    { 
	        int x = (cipher_text.charAt(i) - key.charAt(i) + 26) %26; 
	        x += 'A'; 
	        original_text+=(char)(x); 
	    } 
	    
	    return original_text; 
	} 
	

	private static final Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Enter your text: ");
		String str = scan.nextLine().replaceAll(" ", "");
		str = str.toUpperCase();
		
		System.out.println("Enter key stream: ");
		String keyword = scan.nextLine();
		
		String key = generateKey(str, keyword); 
	    String cipher_text = Encryption(str, key); 
	  
	    System.out.println("Ciphertext : "+ cipher_text + "\n"); 
	  
	    System.out.println("Plain/Original Text : "+ Decryption(cipher_text, key));  
		
		
	}

}

/*

She is listening
PASCAL

output:
Ciphertext : HHWKSWXSLGNTCG

Plain/Original Text : SHEISLISTENING
 
 */
