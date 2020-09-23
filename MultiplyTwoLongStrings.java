package com.two.anubha.java.algo;

import java.math.BigInteger;

public class MultiplyTwoLongStrings {
	public static void main (String[] args) {  
		String num1 = "112";
		String num2 = "23";
		
	    System.out.print(multiplyStrings(num1, num2)); 
	  }

	private static String multiplyStrings(String num1, String num2) {
		BigInteger bi = new BigInteger(num1);
		return String.valueOf(bi.multiply(new BigInteger(num2)));
	}
}
