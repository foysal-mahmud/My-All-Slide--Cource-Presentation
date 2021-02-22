package com.foysal.cipher;

import java.util.Scanner;

public class RobinCrypto {

	
	public static int Encryption(int n, int plaintext) {
		double ciphertext = Math.pow(plaintext, 2) % n;
		System.out.println("CipherText: " + (int)ciphertext);
		return (int) ciphertext;
	}
	
	public static void Decryption(int p, int q, int ciphertext) {
		double a1 = Math.pow(ciphertext, (p+1)/4) % p;
		double a2 = (-1 * Math.pow(ciphertext, (p+1)/4)) % p;
		double b1 = Math.pow(ciphertext, (q+1)/4) % q;
		double b2 = (-1 * Math.pow(ciphertext, (q+1)/4)) % q;
		
		while(a2 < 0) {
			a2 += p;
		}
		
		while(b2 < 0) {
			b2 += q;
		}
		
		System.out.println(a1 + " " + a2 + "  " + b1 + " " + b2);
		
//		int num[] = {(int)a1, (int)a2, (int)b1, (int)b2};
//		int rem[] = {p, p, q, q};
//		
//		int plainText = chineseRemainder(num, rem);
//		
//		System.out.println("CipherText: " + plainText);
	}

	
	private static final Scanner scan = new Scanner(System.in);
	
	public static void main(String args[]) {
		
		System.out.println("Enter Plaintext: ");
		int plainText = scan.nextInt();
		
		int p, q;
		System.out.println("Choose large prime (p): ");
		p = scan.nextInt();
		System.out.println("Choose large prime (q): ");
		q = scan.nextInt();
		
		int n = p * q;
		
		System.out.println("Public key (n) = " + n );
		System.out.println("Private key (q, n) = " + q + ", " + n);
		
		int ciphertext = Encryption(n, plainText);
		
		System.out.println(ciphertext);
		
		Decryption(p, q, ciphertext);
		
	}

}

/*

Enter Plaintext: 
24
Choose large prime (p): 
23
Choose large prime (q): 
7
Public key (n) = 161
Private key (q, n) = 7, 161
CipherText: 93

 */
