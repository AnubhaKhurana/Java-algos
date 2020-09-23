package com.tree.anubha.java.algo;
/*Given a binary tree, get the average value at each level of the tree*/
import java.util.ArrayList;
import java.util.List;

class Node{
	int node;
	Node left;
	Node right;
	
	Node(int value){
		this.node = value;
	}
	
	Node(int node, Node left, Node right){
		this.node = node;
		this.left = left;
		this.right = right;
	}
}

public class AverageOfEachLevelIntree {
	public static int height(Node node){
		
		if(node == null)
			return 0;
		if(node.left == null && node.right == null)
			return 1;
		else{
			int leftHt = height(node.left);
			int rightHt = height(node.right);
			
			if(leftHt > rightHt)
				return leftHt + 1;
			return rightHt +1;
		}
	}
	//BFS
	
	public static void getAllLevelNodeValues(Node node, int level, List<Integer> valuesAtALevel){
		if(node == null) return;
		
		if(level == 1)
			valuesAtALevel.add(node.node);
		else{
			getAllLevelNodeValues(node.left, level-1, valuesAtALevel);
			getAllLevelNodeValues(node.right, level-1, valuesAtALevel);
		}
	}
	public static List<Integer> getAverageAtEachLevel(Node node){
		List<Integer> list = new ArrayList<Integer>();
		
		int height = height(node);
		for(int i=0; i<height; i++){

			List<Integer> valuesAtALevel = new ArrayList<>();
			getAllLevelNodeValues(node, i+1, valuesAtALevel);
			
			int sum = 0;
			for(int j=0; j<valuesAtALevel.size(); j++){
				sum += valuesAtALevel.get(j);
			}
			
			int average = sum/valuesAtALevel.size();
			list.add(average);
		}
		return list;
	}
	public static void main(String[] args){
	    Node twoAgain = new Node(2);  
		Node six = new Node(6, twoAgain, null); 
		Node two = new Node(2, null, six);  
		Node ten = new Node(10); 		
		Node seven = new Node(7, ten, two); 
		Node sixAgain = new Node(6);
		Node nine = new Node(9, null, sixAgain);
		Node root = new Node(4, seven, nine); 
		
		System.out.println(getAverageAtEachLevel(root));
		System.exit(0);
	}

}
