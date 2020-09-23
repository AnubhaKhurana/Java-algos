package com.two.anubha.java.algo;
/*given pattern p, a binary string, and a string s, which contains only lowercase english letter. 
 * Return the total number of substring of s that match the pattern p if and only if for each 0 in p, 
 * the corresponding letter in s is a vowel, and for each 1 in p, the corresponding letter in s is a consonant*/

public class SubstringsWithVowelsAndConsonants {
	public static void main(String[] args){
		String p = "110";
		String s = "bbedcca";
		/*bbe and cca are the substring which satisfy the pattern. So total is 2.*/
		
		int n = getNoOfSuccessfulPatterns(p, s);
		System.out.println(n);
		System.exit(0);
	}

	private static int getNoOfSuccessfulPatterns(String p, String s) {
		String vowels = "aeiou";
		int noOfPatterns = 0;
		
		if(p.length() > s.length())
			return 0;
		
		for(int i = 0; i < s.length(); i++){
			boolean bPatternExist = true;
			
			if((p.charAt(0) == '0' && vowels.indexOf(s.charAt(i)) == -1) ||
					(p.charAt(0) == '1' && vowels.indexOf(s.charAt(i)) != -1)){
				bPatternExist = false;
			}else{
				int inc = 1;
				
				for(int k = 1; k<p.length(); k++){
					if( (i+inc == s.length()) || (p.charAt(k) == '0' && vowels.indexOf(s.charAt(i+inc)) == -1) ||
							(p.charAt(k) == '1' && vowels.indexOf(s.charAt(i + inc)) != -1)){
						bPatternExist = false;
						break;
					}
					inc++;
				}
			}
				
			if(bPatternExist)
				noOfPatterns++;
		}
		return noOfPatterns;
	}

}
