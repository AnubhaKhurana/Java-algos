package com.xerox.dsps.test;

class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode final1 = null;
        if(l1 == null)
            if(l2 == null)
                return null;
        
        int carry = 0;
        ListNode firstNodeResult = null;
        ListNode previosNode = null;
        int i = 0;
        while(l1 != null){
            int fVal = l1.val;
            int sVal = 0;
            if(l2 != null)
                sVal = l2.val;
            int totalVal = fVal + sVal + carry;
            int nodeVal = totalVal % 10;
            carry = totalVal/10;
            previosNode = final1;
            final1 = new ListNode(nodeVal, null);
            if(i == 0)
            	firstNodeResult = final1;
            if(previosNode != null)
            	previosNode.next = final1;
            l1 = l1.next;
            if(l2 != null)
               l2 = l2.next;
            i ++;
        }
              
        while(l2 != null){
        	previosNode = final1;  
        	int totalVal = l2.val + carry;
            int nodeVal = totalVal % 10;
            carry = totalVal/10;
            final1 = new ListNode(nodeVal, null);
            if(previosNode != null)
            	previosNode.next = final1;
            l2 = l2.next;
        }
        if(carry > 0){
        	previosNode = final1;    
            final1 = new ListNode(carry, null);
            if(previosNode != null)
            	previosNode.next = final1;
        }
        return firstNodeResult;
        
    }
    
    public static void main(String[] args){
    	ListNode l1 = new ListNode(0, null);/*
    	ListNode l11 = new ListNode(4, l1);
    	ListNode l12 = new ListNode(2, l11);*/
    	

    	ListNode l23 = new ListNode(2, null);
    	ListNode l2 = new ListNode(7, l23);
    	ListNode l21 = new ListNode(8, l2);
    	ListNode l22 = new ListNode(5, l21);
    	
    	ListNode l3 = addTwoNumbers(l1, l22);
    	ListNode temp = l3;
    	do{
    		System.out.println(temp.val + "    ");
    		temp = temp.next;
    	}while(temp.next != null);
    	System.out.println(temp.val + "    ");
    }
}
