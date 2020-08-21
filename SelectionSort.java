package com.xerox.dsps.test;

import java.util.Arrays;

public class SelectionSort {
	public static void main(String[] args){
		
		int[] arr = {56, 78, 23, -9, 0, 89, 4, 180, 67, 190, 203, 405};
		 
	    System.out.println("Total Iterations: " + Selectionsort(arr));
	    
	    Arrays.stream(arr)
  	  		  .forEach(System.out::println);
		System.exit(0);
	}
	
	private static int Selectionsort(int[] arr){
		int noOfIterations = 0;
		
		for(int suffixPos = 0; suffixPos != arr.length; suffixPos++){
			for (int i=suffixPos; i<arr.length; i++){
				noOfIterations++;
				if(arr[i] < arr[suffixPos]){
					//Swap them both
			          int nTemp = arr[i];
			          arr[i] = arr[suffixPos];
			          arr[suffixPos] = nTemp;
			          Arrays.stream(arr)
			    	        .forEach(x -> System.out.print(x + " "));
					  System.out.println(" ");
				}
			}
		}
		return noOfIterations;
	}
}
