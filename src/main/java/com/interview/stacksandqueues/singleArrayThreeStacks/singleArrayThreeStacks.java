package com.interview.stacksandqueues.singleArrayThreeStacks;

public class singleArrayThreeStacks {

	private int stackSize = 100;
	private int[] buffer = new int [stackSize * 3];
	private int[] stackPointer = {0, 0, 0}; // stack pointers to track top elem
	
	public static void main(String[] args) {
		
		
	}
	
	public void push(int stackNum, int value) {
		 /* Find the index of the top element in the array + 1, and
		  * increment the stack pointer */
		int index = stackNum * stackSize + stackPointer[stackNum] + 1;
		stackPointer[stackNum]++;
		buffer[index] = value;
	}
	
	int pop(int stackNum) {
		int index = stackNum * stackSize + stackPointer[stackNum];
		stackPointer[stackNum]--;
		int value = buffer[index];
		buffer[index]=0;
		return value;
	}
	
	int peek(int stackNum) {
		int index = stackNum * stackSize + stackPointer[stackNum];
		return buffer[index];
	}
	
	boolean isEmpty(int stackNum) {
		return stackPointer[stackNum] == stackNum*stackSize;
	}

}
