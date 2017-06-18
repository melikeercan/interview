package com.interview.stacksandqueues.singleArrayThreeStacks;


public class Stack {
	public Node top;
	
	public Node pop() {
		if(top == null) {
			return top;
		} else {
			int item = top.data;
			Node returnNode = new Node(item);
			top = top.next;
			return returnNode;
		}
	}
	
	public void push(int item) {
		if(top == null) {
			top = new Node(item);
		} else {
			Node t = new Node(item);
			top.next = t;
			top = t;
		}
	}
	
}
