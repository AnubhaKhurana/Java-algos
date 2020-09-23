package com.two.anubha.java.algo;

class LinkedListNode{
	int value;
	LinkedListNode next;
}
public class ReverseLinkedListRecursively {
	
	public static LinkedListNode reverse(LinkedListNode node){
		LinkedListNode newNode = null;
		
		if(node.next == null)
			return node;
		
		newNode = reverse(node.next);     
	       node.next.next = node;
	       node.next = null;    
		
		return newNode;
	}
	public static void main(String[] args){
		
		LinkedListNode node = new LinkedListNode();
		node.value = 1;
		
		LinkedListNode node1 = new LinkedListNode();
		node1.value = 2;
		node.next = node1;
		
		LinkedListNode node2 = new LinkedListNode();
		node2.value = 3;
		node1.next = node2;
		
		LinkedListNode node3 = new LinkedListNode();
		node3.value = 4;
		node2.next = node3;
		
		LinkedListNode node4 = new LinkedListNode();
		node4.value = 5;
		node3.next = node4;
		node4.next = null;
		
		LinkedListNode reverseHead = reverse(node);
		System.exit(0);
	}

}
