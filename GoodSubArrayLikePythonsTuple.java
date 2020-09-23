package com.two.anubha.java.algo;
/*Given a list of integers, count the number of 'good tuples' that can be created. A 'good tuple' is defined as consecutive triplets having exactly 2 duplicate elements.
For eg.
nums = [4,4,6,1,2,2,2,3]
Here good tuples are: [4,4,6], [1,2,2], [2,2,3] because here in nums[i-1], nums[i], nums[i+1] exactly 2 numbers are equal, however [2,2,2] isn't a good tuple because nums[i-1]==num[i]==nums[i+1].
Count of good tuples is 3.

Another example:
nums = {4,6,4,1,3,4}
Here there is only one good tuple: [4,6,4]. Count of good tuples is 1.*/
public class GoodSubArrayLikePythonsTuple {
	
	public static void main(String[] args){
		int arr[] = {4,6,4,1,3,4};
		int n = getNumberOfGoodSubArrays(arr);
		System.out.println(n);
		System.exit(0);
	}

	private static int getNumberOfGoodSubArrays(int[] arr) {
		
		int n = 0;
		
		if(arr.length < 3)
			return 0;
		
		for(int i=2; i<arr.length; i++){
			if( (arr[i] == arr[i-1] && arr[i] != arr[i-2]) || 
					(arr[i] == arr[i-2] && arr[i] != arr[i-1]) ||
					(arr[i-1] == arr[i-2] && arr[i-1] != arr[i])){
				n++;
			}
		}
		
		return n;
	}
}
