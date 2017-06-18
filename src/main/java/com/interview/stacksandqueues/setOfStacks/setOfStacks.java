package com.interview.stacksandqueues.setOfStacks;

public class setOfStacks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackSet set = new StackSet();
		for(int i = 0; i < 10; i++) {
			set.push(i);
		}
		
		System.out.println(set.stackList.size());
		System.out.println("-----");
		for(int i = 0; i < 10; i++) {
			Integer value = set.popItem();
			System.out.println("value:" + value);
		}
		
		StackSet setPopAt = new StackSet();
		for(int i = 0; i < 10; i++) {
			setPopAt.push(i);
		}
		
		Integer val = setPopAt.popAt(3);
		System.out.println("val:" + val);
		
//		Integer val2 = setPopAt.popAt(0);
//		System.out.println("val2:" + val2);
		
		Integer val3 = setPopAt.popAt(1);
		System.out.println("val3:" + val3);
	}

}
