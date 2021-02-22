package com.foysal.cipher;

import java.util.Scanner;

public class ColumnarTranspositionCipher {
	
	public static String Encryption(String text, int num, int key[][]) 
	{
		String[] result = new String[num];

		int k=0, j=0;
		
		while(k < text.length()) {
			result[j] = "";
			for(int i=0; i<num; i++) 
			{
//				System.out.println("k = " + k + " " + text.charAt(k));
//				result[j] += text.charAt(k);
//				k++;
//				
				if(k < text.length()) {
					result[j] += text.charAt(k);
					k++;
				} else {
					result[j] += 'z';
				}
			}
			//System.out.println(result[j]);
			j++;
		}
		
		String final_str = "";
	    for(int i = 0; i< num; i++) 
	    {
	    	int des = key[0][i]; //3
	    	//System.out.println(des);
	    	for(int p = 0; p<j; p++) {
	    		final_str += result[p].charAt(des - 1);
	    	}
	    }
		
		return final_str.toUpperCase();
	}
	
	
	public static void Decryption(String text, int num, int key[][]) 
	{
		String[] result = new String[num];

		int len = text.length() / num;
		for(int i=0; i< len; i++) 
		{
			result[i] = "";
			for (int j = i; j < text.length(); j += len) {
				result[i] += text.charAt(j);
			}
		}	
		
		for(int p=0; p<4; p++)
			System.out.println(result[p]);
		
		
		
		String final_str = "";
	   
	    for(int p = 0; p<len; p++) 
	    {
	    	for(int i = 0; i< num; i++) 
	    	{
		    	int des = 0;
		    	for(int x = 0; x < num; x++) {
		    		if(key[1][i] == key[0][x])
		    			des = key[1][x]; //2
		    	}
	    	
	    		final_str += result[p].charAt(des - 1);
	    	}
	    }
		
		System.out.println(final_str.toLowerCase());
	}
	
	private static final Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Enter your text: ");
		String prevStr = scan.nextLine().replaceAll(" ", "");
		prevStr = prevStr.toLowerCase();
		
		
		System.out.println("Enter the total characters number in a group: ");
		int num = scan.nextInt();

		System.out.println("Enter Encryption and Decryption permutation key: ");
		int key[][] = new int[2][num];

	    for(int i = 0; i < 2; i++)
	    {
	    	for(int j=0; j<num; j++) {
	    		key[i][j] = scan.nextInt();
	    	}
	    }
	    
	    String result = Encryption(prevStr, num, key);
	    
	    System.out.println("After Encryption: " + result);
	    
	    Decryption(result, num, key);
	   
	}

}
/*
 
Enemy attacks tonight
5
3 1 4 5 2
1 2 3 4 5
 
 */
