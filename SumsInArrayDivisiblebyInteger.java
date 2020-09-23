package com.two.anubha.java.algo;

import java.util.HashMap;
import java.util.Map.Entry;

/*Given an array of integers. Get number of sub-arrays of length 2, that can be formed such that
 * a. The sum of a[i] + a[j] is divisible by k
 * b. i != j
 * 
 *  e.g. Input of int[] a = {1,2,3,4,5};
		int k = 3;
		
		will return 4, since there are 4 sub-arrays of {1,2}, {2,4}, {1,5}, {4,5}.
		The sum of each one of them is divisible by k=3. So total number of sub-arrays is 4.
 *  */
public class SumsInArrayDivisiblebyInteger {
	static long sumsDivisibleByK(int[] a, int k) {
		long l = 0;
		
		HashMap<Integer, Integer> mapObj = new HashMap<>();
		
		for(int i=0; i<a.length; i++){
			
			int mod = (a[i]) % k;
			
			int valueinMap = 0;
			if(mapObj.containsKey(mod))
				valueinMap = mapObj.get(mod);
			
			valueinMap++;
			mapObj.put(mod, valueinMap);
		}
		
		for(Entry<Integer, Integer> entry : mapObj.entrySet()){
			int key = entry.getKey();
			int value = entry.getValue();
			if(key == 0){
				l += value * (value -1)/2;
			}else{
				if(mapObj.containsKey(k - key)){
					int valueOfKMinusKey = mapObj.get(k - key);
					int j = value * valueOfKMinusKey/2;
					l += j;
				}
			}
		}
		return l;
	}
	
	//The following is Brute Force method 
	/*static long sumsDivisibleByK(int[] a, int k) {
		long l = 0;
		 for(int i=0; i<a.length-1; i++){
			for(int j=i+1; j<a.length; j++){
				
				int mod = (a[i] + a[j]) % k;
				if(mod == 0){
					l++;
				}
			}
		}
		
		
		return l;
	}*/
	
	public static void main(String[] args){
		int[] a = {1,2,3, 2,4,5,7};
		int k = 4;
		
		long l = sumsDivisibleByK(a, k);
		System.out.println(l);
		System.exit(0);
	}
}
