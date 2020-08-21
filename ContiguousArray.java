package com.xerox.dsps.test;
/*Contiguous Subarrays
You are given an array arr of N integers. For each index i, you are required to determine the number of contiguous subarrays that fulfills the following conditions:
The value at index i must be the maximum element in the contiguous subarrays, and
These contiguous subarrays must either start from or end on index i.
Signature
int[] countSubarrays(int[] arr)
Input
Array arr is a non-empty list of unique integers that range between 1 to 1,000,000,000
Size N is between 1 and 1,000,000
Output
An array where each index i contains an integer denoting the maximum number of contiguous subarrays of arr[i]
Example:
arr = [3, 4, 1, 6, 2]
output = [1, 3, 1, 5, 1]
Explanation:
For index 0 - [3] is the only contiguous subarray that starts (or ends) with 3, and the maximum value in this subarray is 3.
For index 1 - [4], [3, 4], [4, 1]
For index 2 - [1]
For index 3 - [6], [6, 2], [1, 6], [4, 1, 6], [3, 4, 1, 6]
For index 4 - [2]
So, the answer for the above input is [1, 3, 1, 5, 1]
*/
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
	public static void main(String[] args) {
		ContiguousArray obj = new ContiguousArray();
		int[] arr = { 9, 3, 4, 6, 5, 2 };
		
		Map<Integer, Integer> mapObj = new HashMap<>();
		for(int i=0; i<arr.length; i++){
			obj.leftContiguousSubArray(arr, i, mapObj);
			obj.rightContiguousSubArray(arr, i, mapObj);
		}
		
		Collection<Integer> values = mapObj.values();
		Integer[] targetArray = values.toArray(new Integer[values.size()]);
		
		int[] intArray = Arrays.stream(targetArray)
				               .mapToInt(Integer::intValue)
				               .toArray();
		
		mapObj.values().stream()
		      .forEach(System.out::println);
		
		
		
	}

	// Add any helper functions you may need here
	void leftContiguousSubArray(int[] arr, int index, Map<Integer, Integer> mapObj) {
		int weightOfTheIndex= 0;
		
		for (int j = index -1; j >= 0; j--) {
			if (arr[index] > arr[j])
				weightOfTheIndex++;
			else
				break;
		}

		if(mapObj.containsKey(index))
			weightOfTheIndex += mapObj.get(index);
		
		mapObj.put(index, weightOfTheIndex);
	}
	
	void rightContiguousSubArray(int[] arr, int index, Map<Integer, Integer> mapObj) {
		int weightOfTheIndex= 1;//One weight is for itself
		
		for (int j = index + 1; j < arr.length; j++) {
			if (arr[index] > arr[j])
				weightOfTheIndex++;
			else
				break;
		}

		if(mapObj.containsKey(index))
			weightOfTheIndex += mapObj.get(index);
		
		mapObj.put(index, weightOfTheIndex);
	}
}
