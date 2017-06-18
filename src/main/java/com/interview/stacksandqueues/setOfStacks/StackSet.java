package com.interview.stacksandqueues.setOfStacks;

import java.util.Currency;
import java.util.Stack;

public class StackSet extends Stack<MyStack>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Stack<MyStack> stackList = new Stack<>();
	
	
	public void push(int d) {
		if(stackList.isEmpty()) {
			MyStack topStack = new MyStack();
			topStack.currentSize = 1;
			topStack.limit = 6;
			topStack.stack.push(d);
			stackList.push(topStack);
		} else {
			MyStack topStack = stackList.peek();
			if(topStack.currentSize == topStack.limit) {
				MyStack item = new MyStack();
				item.currentSize = 1;
				item.limit = 6;
				item.stack.push(d);
				stackList.push(item);
			} else {
				topStack.currentSize = topStack.currentSize +1;
				topStack.stack.push(d);
			}
		}
		
	}
	
	public Integer popItem() {
		MyStack topStack = stackList.peek();
		if(topStack.currentSize == 1) {
			Integer item = topStack.stack.pop();
			stackList.pop();
			return item;
		} else {
			topStack.currentSize = topStack.currentSize -1;
			return topStack.stack.pop();
		}
	}
	
	public Integer popAt(int d) {
		if(d >= stackList.size()) {
			return null;
		} else {
			while(d > 0) {
				d = d-1;
				stackList.pop();
			}
			MyStack topStack = stackList.pop();
			return topStack.stack.pop();
					
		}
		
	}
}

