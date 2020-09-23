package com.two.anubha.java.algo;
/*Bracket Matcher
Have the function BracketMatcher(str) take the str parameter being passed and return 1 if the brackets are correctly matched and 
each one is accounted for. Otherwise return 0. For example: if str is "(hello (world))", then the output should be 1, but if 
str is "((hello (world))" the the output should be 0 because the brackets do not correctly match up. Only "(" and ")" will be 
used as brackets. If str contains no brackets return 1.
Examples
Input: "(coder)(byte))"
Output: 0
Input: "(c(oder)) b(yte)"
Output: 1*/
public class BracketMatcher {
	public static String BracketMatcher(String str) {
	
		int noOfOpenBrackets = 0;
		int noOfCloseBrackets = 0;
		// code goes here 
		//NoOfCloseBrackets cannot exceed no of Open brackets eg. in the color re(d))()(()
		
		for(int i=0; i<str.length(); i++){
			if(str.charAt(i) == '('){
				noOfOpenBrackets++;
			}else if(str.charAt(i) == ')'){
				noOfCloseBrackets++;
			}
			if(noOfCloseBrackets > noOfOpenBrackets)
				return "0";
		}
		if(noOfOpenBrackets == noOfCloseBrackets)
			return "1";
		
		return "0";
	}
	
	public static void main (String[] args) {  
	    // keep this function call here  
	    System.out.print(BracketMatcher("the color re(d))()(()")); 
	  }
}
