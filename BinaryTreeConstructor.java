package com.tree.anubha.java.algo;

import java.util.HashMap;
import java.util.Map;

/*Tree Constructor
Have the function TreeConstructor(strArr) take the array of strings stored in strArr, which will contain pairs of integers 
in the following format: (i1,i2), where i1 represents a child node in a tree and the second integer i2 signifies that it is the 
parent of i1. For example: if strArr is ["(1,2)", "(2,4)", "(7,2)"], then this forms the following tree:
			4
			|
	2
	|
1		7

which you can see forms a proper binary tree. Your program should, in this case, return the string true because a valid binary 
tree can be formed. If a proper binary tree cannot be formed with the integer pairs, then return the string false. All of the integers within the tree will be unique, which means there can only be one node in the tree with the given integer value.
Examples
Input: new String[] {"(1,2)", "(2,4)", "(5,7)", "(7,2)", "(9,5)"}
Output: true
Input: new String[] {"(1,2)", "(3,2)", "(2,12)", "(5,2)"}
Output: false*/
public class BinaryTreeConstructor {
	
	 public static String TreeConstructor(String[] strArr) {
	    
		 // code goes here 
		 int noOfNodes = strArr.length;
		 
		 Map<String, Integer> parentMap = new HashMap<>();
		 Map<String, Integer> childMap = new HashMap<>();
		 
		 
		 for(int i=0; i<noOfNodes; i++){
			 strArr[i] = strArr[i].substring(1, strArr[i].length()-1);
			 String[] childParent = strArr[i].split(",");
			 
			 //Child				 
			 int value = 0;
			 String toLookFor = childParent[0];
			 if(childMap.containsKey(toLookFor)){
				 value = childMap.get(toLookFor);
				 if(value == 1) //One can not have two parents
					 return "false";
			 }
			 childMap.put(toLookFor, value + 1);
			 
			 //Parent
			 value = 0;
			 toLookFor = childParent[1];
			 if(parentMap.containsKey(toLookFor)){
				 value = parentMap.get(toLookFor);
				 if(value == 2) //Not more than two children are allowed
					 return "false";
			 }
			 parentMap.put(childParent[1], value + 1);
			
		 }
		 
	     return "true";
	 }

	  public static void main (String[] args) {  
	    System.out.print(TreeConstructor( new String[] {"(2,3)", "(1,2)", "(4,9)", "(9,3)", "(12,9)", "(6,4)"})); 
	  }


}
