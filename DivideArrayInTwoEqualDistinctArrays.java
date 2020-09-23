package com.two.anubha.java.algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

/*An even indexed array should be divided in two such that
 * a. The values shouldn't be more than one time in each divided array.
 * b. The number of values should be equally divided.
 * c. More than two values of a number in input array should return empty array.
 * 
 * Like an array of {1,2,3,4,5,7,6, 7} should return {{1,2,3,7},{4,5,6,7}}
 * 
 * There definitely can be more than one answer. Just return one answer.*/

public class DivideArrayInTwoEqualDistinctArrays {
	static int[][] divideArray(int[] a) {
		
		int n = a.length;
		int[][] retArray = new int[2][n/2];
		
		HashMap<Integer, Integer> mapObj = new HashMap<>();		
		int countInFirstArray = 0;
		int countInSecArray = 0;
		
		for(int i=0; i<a.length; i++){
			int valueinMap = 0;
			if(mapObj.containsKey(a[i]))
				valueinMap = mapObj.get(a[i]);
			
			valueinMap++;
			
			if(valueinMap > 2){
				int[][] aNull = {};
				return aNull;
			}
			mapObj.put(a[i], valueinMap);
			
			if(valueinMap == 2){
				retArray[0][countInFirstArray++] = a[i];
				retArray[1][countInSecArray++] = a[i];
			}
		}

		for(Entry<Integer, Integer> entry : mapObj.entrySet()){
			int key = entry.getKey();
			int value = entry.getValue();
			if(value == 1){
				if(countInFirstArray < countInSecArray){
					retArray[0][countInFirstArray++] = key;
				}else{
					retArray[1][countInSecArray++] = key;
				}
			}
		}
		
		return retArray;
	}
	
	public static void main(String[] args){
		//This specific test case failed
		int[] arr = {1,2,2,4,5,6,7, 7};
		
		int[][] ret = divideArray(arr);
		
		if(ret.length == 2){
			Arrays.stream(ret[0])
				  .forEach(System.out::print);
			System.out.println();
			Arrays.stream(ret[1])
			  .forEach(System.out::print);
		}
		System.exit(0);
	}
}
