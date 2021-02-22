package com.foysal.cipher;

import java.util.Scanner;

public class MultiplicativeCipher {
	
	public static int MultiplicativeInverseKey(int key)
	{
	    int r1,r2,r,q,t1,t2,t;
	    r1=26;
	    r2=key;
	    t1=0;
	    t2=1;
	    while(r2>0)
	    {
	        q=r1/r2;
	        r=r1-q*r2;
	        r1=r2;
	        r2=r;
	        t=t1-q*t2;
	        t1=t2;
	        t2=t;
	    }
	    if(r1==1)
	    {
	        if(t1<0)
	            t1+=26;
	        return t1;
	    }
	    return 0;
	}
	
	public static String Encryption(String text, int key) {
		
		String result = "";
		
		for(int i = 0; i < text.length(); i++) {
			int temp = text.charAt(i) - 97;
			int intValue = (temp*key)%26 + 97;
			result += (char)intValue;
		}
		
		System.out.println(result.toUpperCase());
		
		return result.toUpperCase();
	}
	
	public static void Decryption(String text, int key) {
		
		String result = "";
		
		for(int i = 0; i < text.length(); i++) {
			int temp = text.charAt(i) - 65;
			int intValue = (temp*key)%26 + 65;
			result += (char)intValue;
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
		
		int inverseKey = MultiplicativeInverseKey(key);
		
		System.out.println("After Decryption: ");
		Decryption(encryptedString, inverseKey);
		
		
	}

}
