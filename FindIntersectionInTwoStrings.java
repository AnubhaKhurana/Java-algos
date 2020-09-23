package com.two.anubha.java.algo;

import java.util.Arrays;
import java.util.List;

public class FindIntersectionInTwoStrings {
	 public static String FindIntersection() {
		 String[] strArr = new String[] {"1, 3, 4, 7, 13", "1, 2, 4, 13, 15"};
		 
		// code goes here  
	    StringBuffer returnString = new StringBuffer();

	    String[] firstStr = strArr[0].split(", ");
	    String[] secStr = strArr[1].split(", ");

	    
	    int i=0;
	    int j = 0;

	    while(i < firstStr.length && j < secStr.length){
	      if(Integer.parseInt(firstStr[i]) == Integer.parseInt(secStr[j])){
	        returnString.append(firstStr[i]);
	        returnString.append(",");
	        i++;
	        j++;
	      }else if(Integer.parseInt(firstStr[i]) < Integer.parseInt(secStr[j])){
	        i++;
	      }else
	        j++;
	    }
	    
	    String ret = returnString.toString();
	    if(ret.isEmpty())
	      return "false";
	    
	    return ret.substring(0, ret.length() - 1);
	  }

	  public static void main (String[] args) {  
	    // keep this function call here  
	    System.out.print(FindIntersection()); 
	  }
}
