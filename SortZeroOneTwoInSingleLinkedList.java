package com.two.anubha.java.algo;
/*Given a singly linked list consisting only of 0, 1, and 2, return it sorted in ascending order.

Example

For l = [2, 1, 0], the output should be
sortZeroOneTwoList(l) = [0, 1, 2];
For l = [0, 1, 0, 1, 2, 0], the output should be
sortZeroOneTwoList(l) = [0, 0, 0, 1, 1, 2].
Input/Output

[execution time limit] 3 seconds (java)

[input] linkedlist.integer l

A singly linked list of integers consisting only of 0, 1, and 2.

Guaranteed constraints:
0 ≤ list size ≤ 105,
0 ≤ element value ≤ 2.

[output] linkedlist.integer

Return l, sorted in ascending order.*/
import java.util.HashMap;
import java.util.Map;

public class SortZeroOneTwoInSingleLinkedList {
	// Singly-linked lists are already defined with this interface:
	 class ListNode<T> {
	   ListNode(T x) {
	     value = x;
	   }
	   T value;
	   ListNode<T> next;
	 }
	
	ListNode<Integer> sortZeroOneTwoList(ListNode<Integer> l) {
	    
	    ListNode<Integer> listObj = null;
	    ListNode<Integer> head = null;
	    Map<Integer, Integer> mapObj = new HashMap<>();
	    
	    ListNode<Integer> temp = l;
	        
	    while(temp != null){
	        int value = 1;
	        if(mapObj.containsKey(temp.value))
	            value = mapObj.get(temp.value) + 1;
	        mapObj.put(temp.value, value);
	        temp = temp.next;
	    }
	    
	    
	    
	    for(int j=2; j>=0; j--){
	        
	        if(mapObj.containsKey(j)){
	            int value = mapObj.get(j);
	            for(int i=0; i<value; i++){
	                head = new ListNode<Integer>(j);
	                if(listObj == null){
	                    listObj = head;
	                    listObj.next = null;
	                }else{
	                    head.next = listObj;
	                    listObj = head;
	                }
	            }
	        }
	    }
	    return head;

	}

}
