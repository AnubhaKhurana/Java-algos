package com.cracking.interview.anubha.java.algo;


import java.util.Arrays;

/*Write an algorithm such that if an element in a MxN matrix is zero, it's entire row and column are set to zero*/
public class SetEntireRowZeroInMatrix {
	public static void setRowsColumnsZero(int[][] matrix){
		boolean[] row = new boolean[matrix.length];
		boolean[] column = new boolean[matrix[0].length];
		
		Arrays.fill(row, false);
		Arrays.fill(column, false);
		
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[0].length; j++){
				if(matrix[i][j] == 0){
					row[i] = true;
				    column[j] = true;
				}
			}
		}
		
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[0].length; j++){
				if(row[i] == true || column[j] == true){
					matrix[i][j] = 0;
				}					
			}
		}
		
		
	}
	
	public static void main(String[] args){
		
		int[][] matrix = {{1, 2, 3, 4}, {1, 2, 0, 4}, {0, 2, 3, 4}, {1, 2, 3, 4}};
		
		for(int i=0; i<matrix[0].length; i++){
			Arrays.stream(matrix[i])
		      .forEach(System.out::print);
			System.out.println();
		}
		
		setRowsColumnsZero(matrix);
		
		for(int i=0; i<matrix[0].length; i++){
			Arrays.stream(matrix[i])
		      .forEach(System.out::print);
			System.out.println();
		}
		
		System.exit(0);
	}
}
