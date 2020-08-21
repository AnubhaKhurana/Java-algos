package com.xerox.dsps.test;
/*
 * Reverse Operations
You are given a singly-linked list that contains N integers. A subpart of the list is a contiguous set of even elements, bordered either by the end of the list or an odd element. For example, if the list is [1, 2, 8, 9, 12, 16], the subparts of the list are [2, 8] and [12, 16].
Then, for each subpart, the order of the elements is reversed. In the example, this would result in the new list, [1, 8, 2, 9, 16, 12].
The goal of this question is: given a resulting list, determine the original order of the elements.
Implementation detail:
You must use the following definition for elements in the linked list:
class Node {
    int data;
    Node next;
}
Signature
Node reverse(Node head)
Constraints
1 <= N <= 1000, where N is the size of the list
1 <= Li <= 10^9, where Li is the ith element of the list
Example
Input:
N = 6
list = [1, 2, 8, 9, 12, 16]
Output:
[1, 8, 2, 9, 16, 12]
 * */
import java.io.*;
import java.util.*;

// Add any extra import statements you may need here

public class ReverseOperations {

	class Node {
		int data;
		Node next;

		Node(int x) {
			data = x;
			next = null;
		}
	}

	// Add any helper functions you may need here
	
	Node reverseLinkedList(Node node) 
    { 
        Node prev = null; 
        Node current = node; 
        Node next = null; 
        while (current != null) { 
            next = current.next; 
            current.next = prev; 
            prev = current; 
            current = next; 
        } 
        node = prev; 
        return node; 
    } 
	
	Node reverseLinkedListFromIndex(Node head, int startIndex, int lastIndex){
		// revs and revend is start and end respectively 
	    // of the portion of the linked list which 
	    // need to be reversed. revs_prev is previous 
	    // of starting position and revend_next is next 
	    // of end of list to be reversed. 
	    Node revs = null;
	    Node revs_prev = null; 
	    Node revend = null;
	    Node revend_next = null; 
	    
	    int i = 0; 
	    Node current = head; 
	    while (current != null && i <= lastIndex) { 
	        if (i < startIndex) 
	            revs_prev = current; 
	  
	        if (i == startIndex) 
	            revs = current; 
	  
	        if (i == lastIndex) { 
	            revend = current; 
	            revend_next = current.next; 
	        } 
	  
	        current = current.next; 
	        i++; 
	    } 
	    revend.next = null; 
	  
	    // Reverse linked list starting with revs. 
	    revend = reverseLinkedList(revs); 
	  
	    // If starting position was not head 
	    if (revs_prev != null) 
	        revs_prev.next = revend; 	    
	    else
	        head = revend; 
	  
	    revs.next = revend_next; 
	    return head; 
	}

	Node reverse(Node head) {
		// Write your code here
		Node current = head;
		int startIndex = 0;	
		
		boolean calledReverseFunction = false;
		int i=0;
		for(; current != null; i++){
			if(current.data % 2 == 0){
				if(calledReverseFunction == false){
					startIndex = i;
					calledReverseFunction = true;
				}
				current = current.next;
				continue;
			}else{
				calledReverseFunction = false;
				if(i > startIndex){
					head = reverseLinkedListFromIndex(head, startIndex, i-1);
					startIndex = i+1;
				}
				current = current.next;
			}
		}
		if(calledReverseFunction == true){
			reverseLinkedListFromIndex(head, startIndex, i-1);
		}
		return head;
	}
		

	// These are the tests we use to determine if the solution is correct.
	// You can add your own at the bottom, but they are otherwise not editable!
	int test_case_number = 1;

	void printLinkedList(Node head) {
		System.out.print("[");
		while (head != null) {
			System.out.print(head.data);
			head = head.next;
			if (head != null)
				System.out.print(" ");
		}
		System.out.print("]");
	}

	void check(Node expectedHead, Node outputHead) {
		boolean result = true;
		Node tempExpectedHead = expectedHead;
		Node tempOutputHead = outputHead;
		while (expectedHead != null && outputHead != null) {
			result &= (expectedHead.data == outputHead.data);
			expectedHead = expectedHead.next;
			outputHead = outputHead.next;
		}
		if (!(expectedHead == null && outputHead == null))
			result = false;

		char rightTick = '\u2713';
		char wrongTick = '\u2717';
		if (result) {
			System.out.println(rightTick + " Test #" + test_case_number);
		} else {
			System.out.print(wrongTick + " Test #" + test_case_number
					+ ": Expected ");
			printLinkedList(tempExpectedHead);
			System.out.print(" Your output: ");
			printLinkedList(tempOutputHead);
			System.out.println();
		}
		test_case_number++;
	}

	Node createLinkedList(int[] arr) {
		Node head = null;
		Node tempHead = head;
		for (int v : arr) {
			if (head == null) {
				head = new Node(v);
				tempHead = head;
			} else {
				head.next = new Node(v);
				head = head.next;
			}
		}
		return tempHead;
	}

	public void run() {

		int[] arr_1 = { 1, 2, 8, 9, 12, 16 };
		int[] expected1 = { 1, 8, 2, 9, 16, 12 };
		Node head_1 = createLinkedList(arr_1);
		Node expected_1 = createLinkedList(expected1);
		Node output_1 = reverse(head_1);
		check(expected_1, output_1);

		int[] arr_2 = { 2, 18, 24, 3, 5, 7, 9, 6, 12 };
		int[] expected2 = { 24, 18, 2, 3, 5, 7, 9, 12, 6 };
		Node head_2 = createLinkedList(arr_2);
		Node expected_2 = createLinkedList(expected2);
		Node output_2 = reverse(head_2);
		check(expected_2, output_2);

		// Add your own test cases here
	    int[] arr_3 = {11, 14, 28, 34, 17, 54, 19, 78, 88, 1};
	    int[] expected3 = {11, 34, 28, 14, 17, 54, 19, 88, 78, 1};
	    Node head_3 = createLinkedList(arr_3);
	    Node expected_3 = createLinkedList(expected3);
	    Node output_3 = reverse(head_3);
	    check(expected_3, output_3);

	}

	public static void main(String[] args) {
		new ReverseOperations().run();
	}
}
