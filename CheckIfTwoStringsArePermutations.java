package com.cracking.interview.anubha.java.algo;

import java.util.Arrays;

public class CheckIfTwoStringsArePermutations {
	public static void main(String[] args) 
    {
		System.out.println(checkForPermutations("abcde1", "cba1ed"));
		System.exit(0);
    }

	private static boolean checkForPermutations(String str1, String str2) {
		if(str1.length() != str2.length())
			return false;
		
		//Assume all ASCII charcters
		int[] str1AllChars = new int[256];
		
		for(int i=0; i<str1.length(); i++){
			char c = str1.charAt(i);
			str1AllChars[c]++;
		}
		
		for(int i=0; i < str2.length(); i++){
			char s = str2.charAt(i);
			if(--str1AllChars[s] < 0)
				return false;
		}
		return true;
	}
	
	/*
	 * Not ideal to sort and compare but still a brute force algorithm
	 * 
	 * private static boolean checkForPermutations(String str1, String str2) {
		
		if(str1.length() != str2.length())
			return false;
		
		str1 = sortString(str1);
		str2 = sortString(str2);
		
		if(str1.equals(str2)) 
			return true;
		return false;
	}

	private static String sortString(String str1) {
		char[] c = str1.toCharArray();
		Arrays.sort(c);
		
		return new String(c);
	}*/
}
