package com.xerox.dsps.test;
/*Matching Pairs
Given two strings s and t of length N, find the maximum number of possible matching pairs in strings s and t after swapping exactly two characters within s.
A swap is switching s[i] and s[j], where s[i] and s[j] denotes the character that is present at the ith and jth index of s, respectively. The matching pairs of the two strings are defined as the number of indices for which s[i] and t[i] are equal.
Note: This means you must swap two characters at different indices.
Signature
int matchingPairs(String s, String t)
Input
s and t are strings of length N
N is between 2 and 1,000,000
Output
Return an integer denoting the maximum number of matching pairs
Example 1
s = "abcd"
t = "adcb"
output = 4
Explanation:
Using 0-based indexing, and with i = 1 and j = 3, s[1] and s[3] can be swapped, making it  "adcb".
Therefore, the number of matching pairs of s and t will be 4.
Example 2
s = "mno"
t = "mno"
output = 1
Explanation:
Two indices have to be swapped, regardless of which two it is, only one letter will remain the same. If i = 0 and j=1, s[0] and s[1] are swapped, making s = "nmo", which shares only "o" with t.*/
public class MatchingAndCountingPairsWithOneSwapAllowed {
	
	boolean isPallindrom(String s){
		boolean bIsPallindrome = true;
		int len = s.length();
		for(int i=0; i< len/2;i++){
			if(s.charAt(i) != s.charAt(len-i -1 ))
				return false;
		}
		
		return bIsPallindrome;
	}
	
	int matchingPairs(String s, String t) {
		// Write your code here
		boolean exactStrings = true;
		int totalMatchingPairs = 0;
		int i = 0;
		
		//If exact Strings and s is a Pallindrom then totalMatchingPairs = t.length()
		if(isPallindrom(s))
			return s.length();
		
		/*If a pair is such that with cross-interchange the characters in s and t would be same then that should be priority over any other swap
		 * For Example:
		 * String s_3 = "abcdefgx";
			String t_3 = "axcedfgh";
		 * should swap de in s_3 for maximum number of possible matching pairs
		 * */

		for (; i < s.length(); i++) {
			if (s.charAt(i) != t.charAt(i)) {
				char lookForCharInS = t.charAt(i);
				int indexofCharInS = s.indexOf(lookForCharInS, i);
				while (indexofCharInS != -1
						&& t.charAt(indexofCharInS) == lookForCharInS)
					indexofCharInS = s.indexOf(lookForCharInS, indexofCharInS+1);
				
				if (indexofCharInS != -1 && t.charAt(indexofCharInS) == s.charAt(i)) {
					// Swap s[i] and s[indexofCharInS]
					char swapChar = s.charAt(i);

					StringBuffer strobj = new StringBuffer(s);
					strobj.setCharAt(i, s.charAt(indexofCharInS));
					strobj.setCharAt(indexofCharInS, swapChar);

					s = strobj.toString();					
					totalMatchingPairs++;
					for (int j = i+1; j < t.length(); j++) {
						if (t.charAt(j) == s.charAt(j))
							totalMatchingPairs++;
					}
					
					return totalMatchingPairs;
				}
			}else
				totalMatchingPairs++;
		}

		
		totalMatchingPairs = 0;
		i = 0;
		for (; i < s.length(); i++) {
			if (s.charAt(i) != t.charAt(i)) {
				char lookForCharInS = t.charAt(i);
				int indexofCharInS = s.indexOf(lookForCharInS, i);
				while (indexofCharInS != -1
						&& t.charAt(indexofCharInS) == lookForCharInS)
					indexofCharInS = s.indexOf(lookForCharInS, indexofCharInS+1);
				if (indexofCharInS != -1) {
					// Swap s[i] and s[indexofCharInS]
					char swapChar = s.charAt(i);

					StringBuffer strobj = new StringBuffer(s);
					strobj.setCharAt(i, s.charAt(indexofCharInS));
					strobj.setCharAt(indexofCharInS, swapChar);

					s = strobj.toString();
					totalMatchingPairs++;
					exactStrings = false;
					break;
				}// No else statement
			} else {
				totalMatchingPairs++;
			}
		}
		//If exact string and not pallindrom
		if(exactStrings){
			return t.length() - 2;
		}
		for (int j = i+1; j < t.length(); j++) {
			if (t.charAt(j) == s.charAt(j))
				totalMatchingPairs++;
		}

		return totalMatchingPairs;
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
		} else {
			System.out.print(wrongTick + " Test #" + test_case_number
					+ ": Expected ");
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

	public void run() {
	    String s_1 = "abcde";
	    String t_1 = "adcbe";
	    int expected_1 = 5;
	    int output_1 = matchingPairs(s_1, t_1);
	    check(expected_1, output_1);

	    String s_2 = "abcd";
	    String t_2 = "abcd";
	    int expected_2 = 2;
	    int output_2 = matchingPairs(s_2, t_2);
	    check(expected_2, output_2);

	    // Add your own test cases here

			String s_3 = "abcdefgx";
			String t_3 = "axcedfgh";
			int expected_3 = 6;
			int output_3 = matchingPairs(s_3, t_3);
			check(expected_3, output_3);		


			String s_4 = "abcded";
			String t_4 = "adcdef";
			int expected_4 = 5;
			int output_4 = matchingPairs(s_4, t_4);
			check(expected_4, output_4);		


			String s_5 = "aaaa";
			String t_5 = "aaaa";
			int expected_5 = 4;
			int output_5 = matchingPairs(s_5, t_5);
			check(expected_5, output_5);
	    
	    String s_6 = "abcdek";
			String t_6 = "adcdef";
			int expected_6 = 4;
			int output_6 = matchingPairs(s_6, t_6);
			check(expected_6, output_6);

	    String s_7 = "abba";
	    String t_7 = "abba";
	    int expected_7 = 4;
	    int output_7 = matchingPairs(s_7, t_7);
	    check(expected_7, output_7);



	}

	public static void main(String[] args) {
		new MatchingAndCountingPairsWithOneSwapAllowed().run();
	}
}
