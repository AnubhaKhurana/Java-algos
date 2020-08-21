package com.xerox.dsps.test;

class Node1{
	private  String value;
	private Node1 next;
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Node1 getNext() {
		return next;
	}
	public void setNext(Node1 next) {
		this.next = next;
	}
}

public class ReverseASingleLinkedListBetweenIndices {
	public Node1 run(Node1 head, int nStartIndex, int nLastIndex){
		
		Node1 prev = head;		
		Node1 next = head.getNext();
		Node1 current = head;
		Node1 previousToPrev = head;
		Node1 nextOfFirstIndex = next;
		
		int currentIndex = 0;
		while(currentIndex < nStartIndex && next != null){
			currentIndex++;
			previousToPrev = current;
			current = next;
			next = next.getNext();
		}
		
		nextOfFirstIndex = current;
		
		while(currentIndex < nLastIndex && next != null){
			currentIndex++;
			prev = current;
			current = next;
			next = next.getNext(); 
			current.setNext(prev);
		}
		previousToPrev.setNext(current);
		nextOfFirstIndex.setNext(next);
		
		if(nStartIndex == 0)
			return current;
		
		return head;
	}

	public static void main(String[] args){
		Node1 head = new Node1();
		Node1 current = head;
		
		Node1 next = new Node1();
		current.setValue("A");
		current.setNext(next);
		current = next;
		
		next = new Node1();
		current.setValue("B");
		current.setNext(next);
		current = next;
		
		next = new Node1();
		current.setValue("C");
		current.setNext(next);
		current = next;
		
		next = new Node1();
		current.setValue("D");
		current.setNext(next);
		current = next;
		
		current.setValue("E");
		current.setNext(null);
		
		
		System.out.println(new ReverseASingleLinkedListBetweenIndices().run(head, 0, 2));
		System.exit(0);
	}

}
