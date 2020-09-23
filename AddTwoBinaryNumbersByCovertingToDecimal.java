package com.two.anubha.java.algo;

//Add Two Binary number and return the sum as a binary number

public class AddTwoBinaryNumbersByCovertingToDecimal {
	
	static int getDigitValue(Character c){
		if(c == '0')
			return 0;
		if(c == '1')
			return 1;
		return -1;
	}
	
	static int convertToDigit(String binary){
		
		int sum = 0;
		for(int i=binary.length() - 1; i>=0; i--){
			int exp = binary.length() - 1 - i;
			
			int number = getDigitValue(binary.charAt(i));
			if(number == -1)
				return -1;
			
			sum += number * Math.pow(2, exp);
		}
		return sum;
	}
	
	static String convertDigitToBinary(int digit){
		
		/*Store the remainder when the number is divided by 2 in an array.
		Divide the number by 2
		Repeat the above two steps until the number is greater than zero.
		Print the array in reverse order now.*/
		
		StringBuffer ret = new StringBuffer();
		int[] binaryNumber = new int[32];
		
		int n = digit;
		int i=0;
		for(; n > 0; i++){
			binaryNumber[i] = n % 2;
			n = n/2;
		}
		
		while(i >= 0){
			ret.append(binaryNumber[i]);
			i--;
		}
		
		return ret.toString();
		
	}
	
	static String addBinaryNumbers(String bin1, String bin2){
		
		int dig1 = convertToDigit(bin1);
		int dig2 = convertToDigit(bin2);
		
		if(dig1 == -1 || dig2 == -1)
			return "Please check the numbers";
		
		return convertDigitToBinary(dig1 + dig2);
	}
	
	public static void main(String[] args){
		String bin1 = "11";
		String bin2 = "0";
		System.out.println(addBinaryNumbers(bin1, bin2));
		System.exit(0);
	}
}
