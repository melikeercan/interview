package com.interview.stacksandqueues.OneQueueWithTwoStacks;

import java.util.Stack;

public class MyQueue {
    static Stack<Integer> stack1 = new Stack<>();

    static Stack<Integer> stack2 = new Stack<>();

    public void push(int d) {
        stack1.push(d);
    }

    public Integer peek() {
        Integer top = null;
        top = fromFirstToSecond(top);
        fromSecondToFirst();
        return top;
    }

    public static Integer pop() {
        Integer top = null;
        top = fromFirstToSecond(top);
        stack2.pop();
        fromSecondToFirst();
        return top;
    }

    private static void fromSecondToFirst() {
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    private static Integer fromFirstToSecond(Integer top) {
        while (!stack1.isEmpty()) {
            top = stack1.peek();
            stack2.push(stack1.pop());
        }
        return top;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            stack1.push(i);
        }
        int topPopped = pop();
        System.out.println(topPopped);
    }

}
