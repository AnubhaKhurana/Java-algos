package com.xerox.dsps.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ProductOfAllItemsInArrayExceptSelf {

	
	public int[] productOfAllExceptSelf(int[] arr){
		int[] returnArray = new int[arr.length];
		
		/*O(N2)
		 * 
		 * Map<Integer, Integer> mapObj = new HashMap<>();
		
		int productForNewElementInMap = 1;
		
		if(arr.length > 0){
			mapObj.put(0,  productForNewElementInMap);
		}
		
		for(int i=1; i<arr.length; i++){
			for(Map.Entry<Integer, Integer> entry : mapObj.entrySet()){
				int key = entry.getKey();
				int value = entry.getValue();
				
				value *= arr[i];
				mapObj.put(key, value);
			}
			productForNewElementInMap *= arr[i-1];
				
			mapObj.put(i, productForNewElementInMap);
		}
		
		for(Map.Entry<Integer, Integer> entry: mapObj.entrySet()){
			returnArray[entry.getKey()] = entry.getValue();
		}*/
		if(arr.length > 0){
		
			returnArray[0] = 1;
			
			for(int i=1; i<arr.length; i++){
				returnArray[i] *= returnArray[i-1];
			}
			
			for(int i=arr.length-2; i >= 0; i--){
				
			}
		}
		
		return returnArray;
	}
	
	public static void main(String[] args){
		int[] arr = {4, 8 , 9, 10};
		
		int[] returnArray = new ProductOfAllItemsInArrayExceptSelf().productOfAllExceptSelf(arr);
		
		Arrays.stream(returnArray)
			  .forEach(System.out::println);
		
		System.exit(0);
	}
}
