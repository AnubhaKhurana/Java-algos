package com.xerox.dsps.test;

import java.util.Arrays;

public class BubbleSort {
	
	public static void main(String[] args){
		
		int[] arr = {56, 78, 23, -9, 0, 89, 4, 180, 67, 190, 203, 405};
		 //Bubble Sort (Bubble Sort1 is a better algorithm, since it doesn't iterate if the swapping is not happening
	    System.out.println("Total Iterations: " + BubbleSort(arr));
	    
	    Arrays.stream(arr)
  	  		  .forEach(System.out::println);
	}
	
	public static int BubbleSort(int[] arr){
		int noOfIterations = 0;
		int noOfSwaps = 0;
		for(int i=arr.length-1; i>0; i--){
			noOfIterations++;
			for(int j=0; j<i; j++){
				noOfIterations++;
				if(arr[j] > arr[j+1]){
					noOfSwaps++;
			          int nTemp = arr[j+1];
			          arr[j+1] = arr[j];
			          arr[j] = nTemp;					
				}
			}
			Arrays.stream(arr)
	    	  .forEach(x -> System.out.print(x + " "));
			System.out.println(" ");
		}
	    System.out.println("No of Swaps: " + noOfSwaps);
		return noOfIterations;
	}
	
	public static int BubbleSort1(int[] arr){
		int noOfIterations = 0;
		int noOfSwaps = 0;
		boolean bSwap = true;
	    while(bSwap){
	      bSwap = false;
	      if(noOfSwaps == 15)
	    	  System.out.println("Number of Iterations by now are: " + noOfIterations);
	      noOfIterations++;
	      for(int i=1; i<arr.length; i++){
	    	noOfIterations++;
	        if(arr[i-1] > arr[i]){
	          bSwap = true;
	          noOfSwaps++;
	          int nTemp = arr[i-1];
	          arr[i-1] = arr[i];
	          arr[i] = nTemp;
	          System.out.println("Swaps happening: " + arr[i] + " " + arr[i-1]);
	        }
	      }
	    }
	    System.out.println("No of Swaps: " + noOfSwaps);
	    return noOfIterations;
	}
	
}
