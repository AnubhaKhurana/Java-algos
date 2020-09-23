package com.two.anubha.java.algo;

import java.util.Stack;

public class AddtwoBinaryNumbers {
	//"101" + "11" = "1000" 
	
	  public static String addTwoBinary(String str1, String str2){
	      Stack<Character> stack = new Stack<>();
	      StringBuilder buf = new StringBuilder();
	     
	      if(str1 == null || str2 == null)
	        return "";
	    
	      if(str1.isEmpty())
	        return str2;
	      if(str2.isEmpty())
	        return str1;
	    
	      char carry = '0';
	      
	      String colonSeparatedTwoStrings = makeBothStringsOfEqualLength(str1, str2);
	      String[] twoBinaryStrings = colonSeparatedTwoStrings.split(":");
	      
	      for(int i=twoBinaryStrings[0].length()-1; i>=0; i--){
	        char num1 = twoBinaryStrings[0].charAt(i);
	        char num2 = twoBinaryStrings[1].charAt(i);
	        
	        if(carry == '1'){
	           if((num1 == '0' && num2 == '1') || (num1 == '1' && num2 == '0')){
	        	   stack.push('0');
	        	   carry = '1';
	           }else if(num1 == '1' && num2 == '1'){
	        	   stack.push('1');
	        	   carry = '1';
	           }else{
	        	   stack.push('1');
	        	   carry = '0';
	           }
	        }else if(carry == '0'){
	           if((num1 == '0' && num2 == '1') || (num1 == '1' && num2 == '0')){
	        	   stack.push('1');
	        	   carry = '0';
	           }else if(num1 == '1' && num2 == '1'){
	        	   stack.push('0');
	        	   carry = '1';
	           }else{
	        	   stack.push('0');
	        	   carry = '0';
	           }
	        }
	      }
	      
	      if(carry == '1')
	    	  stack.push('1');
	      
	      
	      while(!stack.isEmpty()){
	    	  buf.append(stack.pop());
	      }
	      
	      return buf.toString();
	  }

	private static String makeBothStringsOfEqualLength(String str1, String str2) {
		 String smallString = str2;
	     String bigString = str1;
	    
	      if(str1.length() < str2.length()){
	    	  smallString = str1;
	    	  bigString = str2;
	      }
	    
	      //Have the two strings of same length by prefixing the smaller string with zeros
	      StringBuilder tempBuf = new StringBuilder();
	      for(int i=bigString.length() - smallString.length(); i>0; i--){
	    	  tempBuf.append("0");
	      }
	      tempBuf.append(smallString);
	      
	      //Append big String after colon to return a String
	      tempBuf.append(":");
	      tempBuf.append(bigString);	      
	      
		  return tempBuf.toString();
	}
	  
	  public static void main(String[] args){
		  String binaryNum1 = "1011";
		  String binaryNum2 = "1100";
		  
		  //"101" + "11" = "1000";
	      String sumInBinary = addTwoBinary(binaryNum1, binaryNum2);
	      System.exit(0);
	  }
}
