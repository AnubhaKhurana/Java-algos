package com.two.anubha.java.algo;

public class AddTwoHexaDecimalNumbers {
	
	static int getDigitValue(Character c){
		if(c >= '0' && c <= '9')
			return c - '0';
		if(c >= 'A' && c <= 'F')
			return c + 10 - 'A';
		if(c >= 'a' && c <= 'f')
			return c + 10 - 'a';
		return -1;
	}
	
	static int convertToDigit(String binary){
		
		int sum = 0;
		for(int i=binary.length() - 1; i>=0; i--){
			int exp = binary.length() - 1 - i;
			
			int number = getDigitValue(binary.charAt(i));
			if(number == -1)
				return -1;
			
			sum += number * Math.pow(16, exp);
		}
		return sum;
	}
	
	static int  addBinaryNumbers(String bin1, String bin2){
		
		int dig1 = convertToDigit(bin1);
		int dig2 = convertToDigit(bin2);
		
		if(dig1 == -1 || dig2 == -1)
			return -1;
		
		return dig1 + dig2;
	}
	
	public static void main(String[] args){
		String bin1 = "101";
		String bin2 = "9";
		System.out.println(addBinaryNumbers(bin1, bin2));
		System.exit(0);
	}
}

