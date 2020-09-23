package com.two.anubha.java.algo;

/*Take an input string parameter and determine if exactly 3 question marks exist between every pair of numbers that add up to 10. 
 * If so, return true, otherwise return false. Some examples test cases are below:
 * "arrb6???4xxbl5???eee5" => true
 * "acc?7??sss?3rr1??????5" => true
 * "5??aaaaaaaaaaaaaaaaaaa?5?5" => false
 * "9???1???9???1???9" => true
 * "aa6?9" => false
*/

public class QuestionMarks {
	public static String questionsMarks(String str) {
		str = str.replaceAll("[a-z]+", "");
		
		int total = 0;
		int noOfQuesMarks = 0;
		String bSatisfyCriteria = "false";
		
		for(int i=0; i<str.length(); i++){
			if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
				int j = Character.getNumericValue(str.charAt(i));
				int nSwap = 0;
				if(total != 0){
					nSwap = total;
					//noOfQuesMarks = 0;
				}
				if(i < 4)
					noOfQuesMarks = 0;
				total += j;
				if(nSwap > 0 && total != 10){
					total = j;
					noOfQuesMarks = 0;
				}
			}
			if(str.charAt(i) == '?'){
				noOfQuesMarks++;				
			}
			if(noOfQuesMarks == 3 && total == 10){
				total = 0;
				bSatisfyCriteria = "true";	
				noOfQuesMarks = 0;
				i--;
			}else if(noOfQuesMarks != 3 && total == 10){
				return "false";
			}
		}
		
		
		return bSatisfyCriteria;

	}

	public static void main(String[] args) {
		System.out.println(questionsMarks("9???1???9??1???9"));
		
		System.exit(0);
	}
}
