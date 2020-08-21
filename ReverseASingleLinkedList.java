package com.xerox.dsps.test;

class Node{
	private  String value;
	private Node next;
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
}

public class ReverseASingleLinkedList {
	public Node run(Node head){
		
		Node prev = head;		
		Node next = head.getNext();
		Node current = head;
		
		while(next != null){
			prev = current;
			current = next;
			next = next.getNext(); 
			current.setNext(prev);
		}
		head.setNext(null);
		
		return current;
	}

	public static void main(String[] args){
		Node head = new Node();
		Node current = head;
		
		Node next = new Node();
		current.setValue("A");
		current.setNext(next);
		current = next;
		
		next = new Node();
		current.setValue("B");
		current.setNext(next);
		current = next;
		
		next = new Node();
		current.setValue("C");
		current.setNext(next);
		current = next;
		
		next = new Node();
		current.setValue("D");
		current.setNext(next);
		current = next;
		
		current.setValue("E");
		current.setNext(null);
		
		
		System.out.println(new ReverseASingleLinkedList().run(head));
		System.exit(0);
	}
}
