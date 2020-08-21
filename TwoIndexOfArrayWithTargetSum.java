package com.xerox.dsps.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class TwoIndexOfArrayWithTargetSum {
	
	static int[]  callMethod(int[] array, int target){
		int[] returnVal = {-1, -1};
		Map<Integer, Integer> mapObj = new HashMap<>();
		for(int i=0; i<array.length; i++){
			int secondVal = target - array[i];
			if(secondVal > 0){

				if(mapObj.containsKey(secondVal)){
					//get the index in the map
					returnVal[0] = mapObj.get(secondVal);
					returnVal[1] = i;
					return returnVal;
				}
				mapObj.put(array[i], i);
			}
		}
		return returnVal;
	}
	
	public static void main(String[] args){
		int[] array = {3,4,2,7,9, 12};
		int ret[] = callMethod(array, 14);
		Arrays.stream(ret)
		      .forEach(System.out::println);
		System.exit(1);
	}
}

/*mapObj.entrySet().stream()
      .filter(entry -> Objects.equals(entry.getValue(), secondVal))
      .map(Map.Entry::getKey);*/