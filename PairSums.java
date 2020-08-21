package com.xerox.dsps.test;
/*Pair Sums
Given a list of n integers arr[0..(n-1)], determine the number of different pairs of elements within it which sum to k.
If an integer appears in the list multiple times, each copy is considered to be different; that is, two pairs are considered different if one pair includes at least one array index which the other doesn't, even if they include the same values.
Signature
int numberOfWays(int[] arr, int k)
Input
n is in the range [1, 100,000].
Each value arr[i] is in the range [1, 1,000,000,000].
k is in the range [1, 1,000,000,000].
Output
Return the number of different pairs of elements which sum to k.
Example 1
n = 5
k = 6
arr = [1, 2, 3, 4, 3]
output = 2
The valid pairs are 2+4 and 3+3.
Example 2
n = 5
k = 6
arr = [1, 5, 3, 3, 3]
output = 4
There's one valid pair 1+5, and three different valid pairs 3+3 (the 3rd and 4th elements, 3rd and 5th elements, and 4th and 5th elements).*/
import java.io.*;
import java.util.*;
// Add any extra import statements you may need here
import java.util.HashMap;

class PairSums {

	// Add any helper functions you may need here

	int numberOfWays(int[] arr, int k) {
		// Bubble Sort first
		/*
		 * boolean bSwap = true; while(bSwap){ bSwap = true; for(int i=1;
		 * i<arr.length; i++){ if(arr[i-1] > arr[i]){ bSwap = false; int nTemp =
		 * arr[i-1]; arr[i-1] = arr[i]; arr[i] = nTemp; } } }
		 * 
		 * Arrays.stream(arr) .forEach(System.out::println);
		 */

		// Now to take care of each of the multiple occurences
		// let's work on building HAsh table
		Map<Integer, Integer> mapObj = new HashMap<Integer, Integer>();
		int value = 0;
		for (int i = 0; i < arr.length; i++) {

			Object objVal = mapObj.get(arr[i]);

			if (objVal != null)
				value = (int) objVal;
			else
				value = 0;

			mapObj.put(arr[i], value + 1);
		}

		// Print the map here
		mapObj.forEach((keyT, val) -> System.out.println(keyT + ":  " + val));

		int total = 0;
		for (Map.Entry<Integer, Integer> entry : mapObj.entrySet()) {
			int val = entry.getValue();
			int key = entry.getKey();
			if (k - key == key && val != 1)
				total += val * (val - 1);
			else if (k - key != key && mapObj.containsKey(k - key))
				total += val * mapObj.get(k - key);
			System.out.println("Total: " + total + "  Val: " + val + "   Key: "
					+ key + "   Map Coresponding : " + mapObj.get(k - key));

		}
		total /= 2;

		/*
		 * Solution approach 1 where the list shouldn't have the numbers
		 * repeated
		 * 
		 * //After the sorting is done we'll start adding int nLastIndex = 1;
		 * int nFirstIndex = 0;
		 * 
		 * int total = 0; while(nFirstIndex < arr.length - nLastIndex){ //The
		 * two indexes to add are one and two int one = nFirstIndex; int two =
		 * arr.length - nLastIndex; if(arr[one] + arr[two] > k) nLastIndex++;
		 * else if(arr[one] + arr[two] < k) nFirstIndex++; else{
		 * System.out.println(" The value is there!"); total += 1; nLastIndex++;
		 * nFirstIndex++; } }
		 */
		return total;
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
		int k_1 = 6;
		int[] arr_1 = { 1, 2, 3, 4, 3 };
		int expected_1 = 2;
		int output_1 = numberOfWays(arr_1, k_1);
		check(expected_1, output_1);

		int k_2 = 6;
		int[] arr_2 = { 1, 5, 3, 3, 3 };
		int expected_2 = 4;
		int output_2 = numberOfWays(arr_2, k_2);
		check(expected_2, output_2);

		// Add your own test cases here

	}

	public static void main(String[] args) {
		new PairSums().run();
	}
}