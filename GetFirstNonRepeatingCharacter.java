package com.two.anubha.java.algo;
/*Given a string s consisting of small English letters, find and return the first instance of a non-repeating character in it. 
If there is no such character, return '_'.

Example

For s = "abacabad", the output should be
firstNotRepeatingCharacter(s) = 'c'.

There are 2 non-repeating characters in the string: 'c' and 'd'. Return c since it appears in the string first.

For s = "abacabaabacaba", the output should be
firstNotRepeatingCharacter(s) = '_'.

There are no characters in this string that do not repeat.*/
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class GetFirstNonRepeatingCharacter {

char firstNotRepeatingCharacter(String s) {
    Map<Character, Integer> mapObj = new HashMap<>();
    Map<Character, Integer> newMap = new HashMap<>();
    
    char retVal = '_';
    
    for(int i=0; i<s.length(); i++){
    
        int initialValue = 1;
        newMap.put(s.charAt(i), i);
        
        if(mapObj.containsKey(s.charAt(i))){
            initialValue = mapObj.get(s.charAt(i)) + 1;
            newMap.remove(s.charAt(i));
        }
            
        mapObj.put(s.charAt(i), initialValue);
    }
    
    Map.Entry<Character, Integer> min = Collections.min(newMap.entrySet(),
            Comparator.comparing(Map.Entry::getValue));/*
    
    Map.Entry<Character, Integer> min = null;
    for (Map.Entry<Character, Integer> entry : newMap.entrySet()) {
        if (min == null || min.getValue() > entry.getValue()) {
            min = entry;
         }
    }*/
    if(min != null)
        retVal = min.getKey();
        
    return retVal;
}
}
