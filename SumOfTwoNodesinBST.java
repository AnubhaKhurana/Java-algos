package com.tree.anubha.java.algo;
/*// Get sum of all elements in a binary search tree which are in range [low, high] inclusive.
//               6
//            /     \
//           4       8
//          / \     /  \
//         3  5    7   9
//        /
//       1

// Input: [3, 10] => 42
// Input: [2, 5] => 12
// Input: [8, 9] => 17
 * 
 * Second Example:
 * //.      10 
        /
 //    4
         \  
 //        7
            \
             8
 //  Input: [6,9] => 7 +8 = 15
*/

class NodeInt{
	int node;
	NodeInt left;
	NodeInt right;
	
	NodeInt(int node){
		this.node = node;
	}
	
	NodeInt(int node, NodeInt left, NodeInt right){
		this.node = node;
		this.left = left;
		this.right = right;
	}
}

public class SumOfTwoNodesinBST {	
	
	 
	private static void preOrderTraversal(NodeInt node, int[] sum, int min, int max){
		
		if(node == null)
			return;
		
		preOrderTraversal(node.left, sum, min, max);	
		if(node.node >= min && node.node <= max)
			sum[0] += node.node;		
		preOrderTraversal(node.right, sum, min, max);
		
		return;
	}

	public static NodeInt insertInBST(NodeInt node, int n){
		if(node == null)
			return new NodeInt(n);
		if(n < node.node)
			node.left = insertInBST(node.left, n);
		else if(n > node.node)
			node.right = insertInBST(node.right, n);
		
		return node;
	}
	
	public static void main(String[] args){
		NodeInt one = new NodeInt(1);
		NodeInt five = new NodeInt(5);
		NodeInt seven = new NodeInt(7);
		NodeInt nine = new NodeInt(9);
		
		NodeInt three = new NodeInt(3, one, null);
		NodeInt four = new NodeInt(4, three, five);
		NodeInt eight = new NodeInt(8, seven, nine);
		
		NodeInt rootSix = new NodeInt(6, four, eight);

		int min = 8;
		int max = 9;
		NodeInt curr = rootSix;
		
		/*NodeInt eight = new NodeInt(8);
		NodeInt seven = new NodeInt(7, null, eight);
		
		NodeInt four = new NodeInt(4, null, seven);
		NodeInt rootTen = new NodeInt(10, four, null);
		int min = 6;
		int max = 9;
		NodeInt curr = rootTen;*/
		
		/*NodeInt rootTen = insertInBST(null,  10);
		NodeInt n = insertInBST(rootTen, 4);
		n = insertInBST(n, 7);
		n = insertInBST(n, 8);
		
		int min = 6;
		int max = 9;
		NodeInt curr = rootTen;*/
		
		while(curr != null && (curr.node < min || curr.node > max)){
			if(min < curr.node)
				curr = curr.left;
			else if(min > curr.node)
				curr = curr.right;				
		}
		
		//Traverse only the needed tree
		int sum[] = {0};
		if(curr != null)
			preOrderTraversal(curr, sum, min, max);
		
		System.exit(0);
	}

}
