package com.two.anubha.java.algo;

import java.util.Arrays;

public class SetRowColumnZeroWithoutExtraSpace {
    public static void setZeroes(int[][] matrix) {
        int noOfRows = matrix.length;
        int noOfColumns = matrix[0].length;
        
        StringBuilder strRowOrColumnToBeSet = new StringBuilder();
        
        for(int i=0; i<noOfRows; i++){
            for(int j=0; j<noOfColumns; j++){
                
                if(matrix[i][j] == 0){
                    if(j == 0){
                        matrix[0][0] = 0;
                        if(i != 0)
                        	strRowOrColumnToBeSet.append("column");
                        else
                        	strRowOrColumnToBeSet.append("rowcolumn");
                    }else if(i == 0){
                        matrix[0][0] = 0;
                        strRowOrColumnToBeSet.append("row");
                    }else{
                    	matrix[i][0] = 0;
                    	matrix[0][j] = 0;
                    }
                }
            }
        }
        
        String str = strRowOrColumnToBeSet.toString();
         for(int i=1; i<noOfRows; i++){
             if(matrix[i][0] == 0){
                 //Make the whole row zero
                for(int j =1; j<noOfColumns; j++){
                    matrix[i][j] = 0;
                }                 
             }
         }
         for(int j=1; j<noOfColumns; j++){
             if(matrix[0][j] == 0){
                 //Make the whole column zero
                for(int i =1; i<noOfRows; i++){
                    matrix[i][j] = 0;
                }                 
             }
         }
         
         if(matrix[0][0] == 0){
             if(str.contains("row")){
                 for(int j =1; j<noOfColumns; j++){
                     matrix[0][j] = 0;
                 }
             }
             if(str.contains("column")){
                 for(int i =1; i<noOfRows; i++){
                     matrix[i][0] = 0;
                 }                
             }
         }
    }
	
	public static void main(String[] args){
		
		int[][] matrix = {{0, 2, 3, 4}, {1, 2, 3, 4}, {0, 2, 3, 4}, {1, 2, 3, 4}};
		
		for(int i=0; i<matrix[0].length; i++){
			Arrays.stream(matrix[i])
		      .forEach(System.out::print);
			System.out.println();
		}
		
		setZeroes(matrix);
		System.out.println();
		for(int i=0; i<matrix[0].length; i++){
			Arrays.stream(matrix[i])
		      .forEach(System.out::print);
			System.out.println();
		}
		
		System.exit(0);
	}

}
