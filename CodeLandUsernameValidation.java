package com.two.anubha.java.algo;
/*
 * 
 * EASY :)
 * 
 * */
/*Codeland Username Validation
Have the function CodelandUsernameValidation(str) take the str parameter being passed and determine if the string is a valid 
username according to the following rules:

1. The username is between 4 and 25 characters.
2. It must start with a letter.
3. It can only contain letters, numbers, and the underscore character.
4. It cannot end with an underscore character.

If the username is valid then your program should return the string true, otherwise return the string false.
Examples
Input: "aa_"
Output: false
Input: "u__hello_world123"
Output: true*/
public class CodeLandUsernameValidation {
	 public static String CodelandUsernameValidation(String str) {
		 // code goes here  
		 if(str.length() < 4 || str.length() > 25) return "false";
		 
		 str = str.toLowerCase();
		 if(str.charAt(0) < 'a' -1 || str.charAt(0) > 'z' -1) return "false";
		 
		 if(str.charAt(str.length()-1) == '_') return "false";
		 
		 str = str.replaceAll("[a-zA-Z0-9_]+", "");
		 if(str.length() > 0) return "false";
		 return "true";
	 }

		  public static void main (String[] args) {  
		    // keep this function call here 
		    System.out.print(CodelandUsernameValidation("123abc444")); 
		  }
}
