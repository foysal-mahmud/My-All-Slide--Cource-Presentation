package com.foysal.cipher;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class RSA {
	
	public static int gcd(int a, int b) {
		if (a == 0)
			return b;
		else
			return gcd(b % a, a);
	}

//	//---------------------------------------------------------------------
//	public static int  Encryption(int plainText,int e, int n) {
//		double cipherText = (Math.pow(plainText, e)) % n;
//		System.out.println("Ciphertext: " + (int)cipherText);
//		return (int)cipherText;
//	}
//	
//	public static void Decryption(int cipherText, int d, int n) {
//		double plainText = (Math.pow(cipherText, d)) % n;
//		System.out.println("PlainText: " + (int)plainText);
//	}
//	
	//----------------------------------------------------------------------

	private static final Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {

		System.out.println("Enter Plaintext for Encryption and Decryption: ");
		int plainText = scan.nextInt();
		
		int p, q;
		System.out.println("Choose large prime (p): ");
		p = scan.nextInt();
		
		System.out.println("Choose large prime (q): ");
		q = scan.nextInt();

		int n = p * q;
		int z = (p - 1) * (q - 1);
		System.out.println("The value of z = " + z);

		int e = 13;
//		for (e = 2; e < z; e++) {
//			if (gcd(e, z) == 1) // e is for public key exponent
//			{
//				break;
//			}
//		}
		System.out.println("The value of e = " + e);
	
		int d = 0;
		for (int i = 0; i <= 9; i++) {
			int x = 1 + (i * z);
			if (x % e == 0) // d is for private key exponent
			{
				d = x / e;
				break;
			}
		}
		
		System.out.println("The value of d = " + d);
		
		System.out.println("Public key (e, n) = " + e + "," + n);
		System.out.println("Private key (d) = " + d);
		
//		int cipherText = Encryption(plainText, e, n);
//		
//		Decryption(cipherText, d, n);
		
		
		 double cipherText = (Math.pow(plainText,e))%n;
		 System.out.println("Ciphertext: " + (int)cipherText);
		 
		 //converting int value of n to BigInteger
		 BigInteger N = BigInteger.valueOf(n);
		 //converting float value of c to BigInteger
		 BigInteger C = BigDecimal.valueOf(cipherText).toBigInteger();
		 
		 BigInteger decryptedText;
		 decryptedText = (C.pow(d)).mod(N);
		 System.out.println("PlainText: " + decryptedText);

	}

}


/*

The value of z = 60
The value of e = 13
The value of d = 37
Public key (e, n) = 13,77
Private key (d) = 37
Ciphertext: :26
PlainText : 5

*/