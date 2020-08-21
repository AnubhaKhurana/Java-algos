package com.xerox.dsps.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*
 * Minimum Length Substrings
You are given two strings s and t. You can select any substring of string s and rearrange the characters of the selected substring. Determine the minimum length of the substring of s such that string t is a substring of the selected substring.
Signature
int minLengthSubstring(String s, String t)
Input
s and t are non-empty strings that contain less than 1,000,000 characters each
Output
Return the minimum length of the substring of s. If it is not possible, return -1
Example
s = "dcbefebce"
t = "fd"'
output = 5
Explanation:
Substring "dcbef" can be rearranged to "cfdeb", "cefdb", and so on. String t is a substring of "cfdeb". Thus, the minimum length required is 5.
 * 
 * */
public class MinumumLengthSubstring {
	int minLengthSubstring(String s, String t) {
		
	    // Write your code here
		//int minimumLengthSubString = -1;
		
	    if(t.length() == 0)
	      return -1;
		
		Map<Character, Integer> mapObj = new HashMap<>();
		
		for(int i=0; i<t.length(); i++){
			int value = 0;
			if(mapObj.containsKey(t.charAt(i))){
				value = mapObj.get(t.charAt(i));
			}
			mapObj.put(t.charAt(i), value + 1);
		}
		
		int firstIndex = -1;
		int lastIndex = -1;
		int totalNoOfCharsInT = 0;
		
		for(int i=0; i<s.length(); i++){
			if(totalNoOfCharsInT == t.length())
				return lastIndex - firstIndex + 1;
			if(mapObj.containsKey(s.charAt(i))){
				totalNoOfCharsInT++;
				if(firstIndex == -1)
					firstIndex = i;
				if(i > 0 && i > lastIndex)
					lastIndex = i;
				if(mapObj.size() == 0){
					return lastIndex - firstIndex + 1;
				}
				char charInMap = s.charAt(i);
				int value = mapObj.get(charInMap);
				if(value == 1)
					mapObj.remove(charInMap);
				else{					
					mapObj.put(charInMap, value - 1);					
				}
			}
		}
		return -1;
		
		/*int indexInS = -1;
		int startingIndex = 0;
		for(int i=0; i<t.length(); i++){
			indexInS = s.indexOf(t.charAt(i), indexInS + 1);
			if(i==0)
				startingIndex = indexInS;
			if(indexInS == -1)
				return -1;
		}
		minimumLengthSubString = indexInS - startingIndex + 1;*/
	    
	  }
	  // These are the tests we use to determine if the solution is correct.
	  // You can add your own at the bottom, but they are otherwise not editable!
	  int test_case_number = 1;
	  void check(int expected, int output) {
	    boolean result = (expected == output);
	    char rightTick = '\u2713';
	    char wrongTick = '\u2717';
	    if (result) {
	      System.out.println(rightTick + " Test #" + test_case_number);
	    }
	    else {
	      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
	      printInteger(expected); 
	      System.out.print(" Your output: ");
	      printInteger(output);
	      System.out.println();
	    }
	    test_case_number++;
	  }
	  void printInteger(int n) {
	    System.out.print("[" + n + "]");
	  }
	  public void run() throws IOException {
	    String s_1 = "dcbefebce";
	    String t_1 = "fd";
	    int expected_1 = 5;
	    int output_1 = minLengthSubstring(s_1, t_1);
	    check(expected_1, output_1);

	    String s_2 = "bfbeadbcbcbfeaaeefcddcccbbbfaaafdbebedddf";
	    String t_2 = "cbccfafebccdccebdd";
	    int expected_2 = -1;
	    int output_2 = minLengthSubstring(s_2, t_2);
	    check(expected_2, output_2);

	    // Add your own test cases here
	    
	  }
	  public static void main(String[] args) throws IOException {
	    new MinumumLengthSubstring().run();
	  }
}
