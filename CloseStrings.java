package com.two.anubha.java.algo;

import java.util.HashMap;
import java.util.Map;

/*We will consider two strings close if one can be obtained from the other, using the following operations:

swap any two symbols in one of the strings,
swap occurrences of any two existing symbols in one of the strings (for example, if your string contains both as and bs, you can 
change all as to bs and all the bs to as).
Now you want to write a method that finds out whether the given strings are considered close, by the definition above.

Example

For A = "abbzccc" and B = "babzzcz", the output should be
closeNames(A, B) = true.

One possible way to transform "abbzccc" to "babzzcz" is this:

"abbzccc" (this string is className)
"babzccc" (swap positions of the first two characters)
"babczzz" (switch all c and z characters)
"babzzcz" (swap positions of the characters at indices 3 and 5; this string is now methodName)

For A = "abcbdb" and B = "bbbcca", the output should be closeNames(A, B) = false.*/
public class CloseStrings {
	
	
	public static void main(String[] args){
		String strA = "abcbdb";
		String strB = "bbdcca";
		
		boolean n = getIfClosedStrings(strA, strB);
		System.out.println(n);
		System.exit(0);
	}

	private static boolean getIfClosedStrings(String strA, String strB) {
		
		Map<Character, Integer> mapObjA = new HashMap<Character, Integer>();
		Map<Character, Integer> mapObjB = new HashMap<Character, Integer>();
		
		if(strA.length() != strB.length())
			return false;
		
		for(int i=0; i<strA.length(); i++){
			int count = 1;
			if(mapObjA.containsKey(strA.charAt(i)))
				count += mapObjA.get(strA.charAt(i));
			mapObjA.put(strA.charAt(i), count);
		}

		for(int i=0; i<strB.length(); i++){
			int count = 1;
			if(mapObjB.containsKey(strB.charAt(i)))
				count += mapObjB.get(strB.charAt(i));
			mapObjB.put(strB.charAt(i), count);
			if(!mapObjA.containsKey(strB.charAt(i))){
				return false;
			}
		}
		for(int i=0; i<strA.length(); i++){
			if(!mapObjB.containsKey(strA.charAt(i)))
				return false;
		}
		//TODO: Values of each letter(Key) in both should be same too
		return true;
	}

}
