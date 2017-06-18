package com.interview.stacksandqueues.min;

public class FindMin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackWithMin swm = initalize();
		
		NodeWithMin peek = swm.peek();
		System.out.println(peek.min);
		System.out.println(peek.value);
	}

	private static StackWithMin initalize() {
		StackWithMin stack = new StackWithMin();
		stack.push(3);
		stack.push(5);
		stack.push(7);
		stack.push(4);
		return stack;
	}

}
