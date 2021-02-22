package com.foysal.cipher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ElGamalAlgo {
	
	public static List<Integer> Encryption(int e1, double e2, int p, int plainText) {
		System.out.println("Choose random integer (r) : ");
		int r = scan.nextInt();
		
		double c1 = Math.pow(e1, r) % p;
		double c2 = (plainText * Math.pow(e2, r)) % p;
		
		System.out.println("Ciphertext: " + (int)c1 + ", " + (int)c2);
		
		List<Integer> cipherText = new ArrayList<>();
		cipherText.add((int) c1);
		cipherText.add((int) c2);
		
		return cipherText;
	}
	
	public static void Decryption(int d, int p, int c1, int c2) {
		double inverse = Math.pow(c1, p-1-d);
		double plaintext = (c2 * inverse) % p;
		
		System.out.println("PlainText: " + (int)plaintext);
	}
	
	private static final Scanner scan = new Scanner(System.in);
	
	public static void main(String args[]) {
		
		System.out.println("Enter Plaintext: ");
		int plainText = scan.nextInt();
		
		int p, e1, d;
		System.out.println("Choose large prime (p): ");
		p = scan.nextInt();
		
		System.out.println("Choose a value of (d): ");
		d = scan.nextInt();
		
		System.out.println("Choose a value of (e1): ");
		e1 = scan.nextInt();
		
		double e2 = Math.pow(e1, d) % p;
		
		System.out.println("Public key (e1, e2, p) = " + e1 + "," + (int)e2 + "," + p);
		System.out.println("Private key (d) = " + d);
		
		List<Integer> cipherText = Encryption(e1, e2, p, plainText);
		
		Decryption(d, p, cipherText.get(0), cipherText.get(1));
		
	}

}

/*

Enter Plaintext: 
7
Choose large prime (p): 
11
Choose a value of (d): 
3
Choose a value of (e1): 
2
Public key (e1, e2, p) = 2,8,11
Private key (d) = 3
Choose random integer (r) : 
4

output:
Ciphertext: 5, 6
PlainText: 7

 */
