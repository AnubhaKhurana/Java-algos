package com.two.anubha.java.algo;
/*Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Example:

MyQueue queue = new MyQueue();

queue.push(1);
queue.push(2);  
queue.peek();  // returns 1
queue.pop();   // returns 1
queue.empty(); // returns false
Notes:

You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).*/

import java.util.Stack;

public class QueueImplementation {
	 /** Initialize your data structure here. */
	Stack<Integer> stack1;
	Stack<Integer> stack2;
	
    public QueueImplementation() {
    	stack1 = new Stack<>();
    	stack2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        
        	while(!stack1.isEmpty()){
        		int i = stack1.pop();
        		stack2.push(i);
        	}
        	stack1.push(x);
        	while(!stack2.isEmpty()){
        		int i = stack2.pop();
        		stack1.push(i);
        	}
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
    	if(!empty()){
    		return stack1.pop();
    	}
    	return -1;
    }
    
    /** Get the front element. */
    public int peek() {
    	if(!empty()){
    		return stack1.peek();
    	}
    	return -1;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(stack1.isEmpty())
        	return true;
        
        return false;
    }
}
