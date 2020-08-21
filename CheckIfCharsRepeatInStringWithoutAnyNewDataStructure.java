package com.xerox.dsps.test;

import java.util.Arrays;

public class CheckIfCharsRepeatInStringWithoutAnyNewDataStructure {
	
	public boolean run(){
		String s_1 = "anubh11";
		//If it's a ASCII string the length can not go beyond 256
		if(s_1.length() > 256)
			return false;
		
		boolean[] allAsciiChars = new boolean[256];
		Arrays.fill(allAsciiChars, Boolean.TRUE);
		for(int i=0; i<s_1.length(); i++){
			int value = s_1.charAt(i);
			
			if(allAsciiChars[value] == false)
				return false;
			allAsciiChars[value] = false;
		}
		return true;
	}

	public static void main(String[] args){
		System.out.println(new CheckIfCharsRepeatInStringWithoutAnyNewDataStructure().run());
		System.exit(0);
	}
	
}
