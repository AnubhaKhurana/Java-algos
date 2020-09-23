package com.two.anubha.java.algo;
/*Our challenge is to now find the middle node in a linked list. */

class Node2{
	private String value;
	private Node2 next;
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Node2 getNext() {
		return next;
	}
	public void setNext(Node2 next) {
		this.next = next;
	}
	
}
public class MiddleElementInSingleLinkedList {
	
	
	private static String getMiddleElementByTakingTwoPointers(Node2 head){
		Node2 doubleJumpNode = head;
		Node2 singleJumpNode = head;
		
		while(doubleJumpNode != null && doubleJumpNode.getNext() != null){
			singleJumpNode = singleJumpNode.getNext();
			if(doubleJumpNode.getNext() != null){
				doubleJumpNode = doubleJumpNode.getNext().getNext();
			}
		}
		
		return singleJumpNode.getValue();
	}
	
	public static void main(String[] args){
		
		Node2 head = new Node2();
		Node2 current = head;
		
		Node2 next = new Node2();
		current.setValue("A");
		current.setNext(next);
		current = next;
		
		next = new Node2();
		current.setValue("B");
		current.setNext(next);
		current = next;
		
		next = new Node2();
		current.setValue("C");
		current.setNext(next);
		current = next;
		
		next = new Node2();
		current.setValue("D");
		current.setNext(next);
		current = next;
		
		next = new Node2();
		current.setValue("E");
		current.setNext(next);
		current = next;
		
		next = new Node2();
		current.setValue("F");
		current.setNext(next);
		current = next;
		
		current.setValue("G");
		current.setNext(null);
		
		String value = getMiddleElementByTakingTwoPointers(head);
		System.out.println(value);
		System.exit(0);
	}
}
