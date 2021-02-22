package com.foysal.cipher;

import java.util.Scanner;

public class KeyedTranspositionCipher {
	
	private static final Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Enter your text: ");
		String str = scan.nextLine().replaceAll(" ", "");
		str = str.toLowerCase();
		
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
	    
	    System.out.println("Keyed transposition Cipher: ");
	    
	    int z = 0;
	    String result = "";
	    while(result.length() < str.length())
	    {
	        String txt = "";
	        int k = num;
	        while(k > 0)
	        {
	        	if(z < str.length()) {
	        		txt += str.charAt(z);
	        	} else {
	        		txt += 'z';
	        	}
	        		
	            k--;
	            z++;
	        }

	        for(int i = 0; i < num; i++)
	        {
	            int p = key[0][i] - 1;
	            result += txt.charAt(p);
	        }
	        
	        result += " ";

	    }
	    
	    System.out.println(result.toUpperCase());
		
	}

}

/*
 
Enemy attacks tonight
5
3 1 4 5 2
1 2 3 4 5
 
 */
