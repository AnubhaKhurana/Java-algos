package com.xerox.dsps.test;

public class DrawIncreasingNumbers {
	public static void draw(int drawTillThisNumber){
		StringBuffer temp = new StringBuffer();
		for(int i=1; i<= drawTillThisNumber; i++){
			temp.append(i);
			System.out.println(temp.toString());
		}
	}
	
	public static void main(String [] args){
		draw(9);
		System.exit(1);
	}
}
