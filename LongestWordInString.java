package com.two.anubha.java.algo;
/*Longest Word
Have the function LongestWord(sen) take the sen parameter being passed and return the largest word in the string. If there are 
two or more words that are the same length, return the first word from the string with that length. Ignore punctuation and assume 
sen will not be empty.
Examples
Input: "fun&!! time"
Output: time
Input: "I love dogs"
Output: love*/
public class LongestWordInString {
	public static String LongestWord(String sen) {
	    // code goes here
		String[] subString = sen.split(" ");
		
		String longestString = "";
		
		for(int i=0; i<subString.length; i++){
			subString[i] = subString[i].replaceAll("[\t\n=\\'/!&;#$%^*()~:?,.]+", "");
			int len = longestString.length();
			if(len < subString[i].length())
				longestString = subString[i];
		}
		
	    return longestString;
   }

   public static void main (String[] args) {  
     // keep this function call here     
    
     System.out.print(LongestWord("a confusing /:sentence:/[ this is not!!!!!!!~")); 
   }
}
