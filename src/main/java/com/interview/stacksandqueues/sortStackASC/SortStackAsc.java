package com.interview.stacksandqueues.sortStackASC;

import java.util.Arrays;
import java.util.Stack;

public class SortStackAsc {

    public static Stack<Integer> stack = new Stack<>();

    public static Stack<Integer> temp = new Stack<>();

    public static void main(String[] args) {
        // for (int i = 0; i < 5; i++) {
        // stack.push(i);
        // }

        stack.push(1);
        stack.push(5);
        stack.push(4);
        stack.push(9);
        stack.push(2);

        Stack<Integer> result = sortAsc();
        System.out.println(Arrays.toString(result.toArray()));

        stack.push(1);
        stack.push(5);
        stack.push(4);
        stack.push(9);
        stack.push(2);

        Stack<Integer> result2 = sortAscLessResource();
        System.out.println(Arrays.toString(result2.toArray()));
    }

    private static Stack<Integer> sortAscLessResource() {
        int dontPopLimit = 0;
        while (stack.size() > dontPopLimit) {
            Integer min = findMin2(stack, temp, dontPopLimit);
            stack.push(min);
            while (!temp.isEmpty()) {
                stack.push(temp.pop());
            }
            dontPopLimit++;
        }
        return stack;
    }

    private static Integer findMin2(Stack<Integer> stack, Stack<Integer> temp, int dontPopLimit) {
        Integer min = stack.pop();
        while (stack.size() > dontPopLimit) {
            Integer top = stack.peek();
            if (top < min) {
                temp.push(min);
                min = top;
            } else {
                temp.push(top);
            }
            stack.pop();
        }
        return min;
    }

    private static Stack<Integer> sortAsc() {
        Stack<Integer> result = new Stack<>();
        Stack<Integer> other = new Stack<>();
        while (!stack.isEmpty() || !temp.isEmpty()) {
            Integer min = findMin(stack, temp);
            result.push(min);
            other = stack;
            stack = temp;
            temp = other;
        }
        return result;
    }

    private static Integer findMin(Stack<Integer> stack, Stack<Integer> temp) {
        Integer min = stack.pop();
        while (!stack.isEmpty()) {
            Integer top = stack.peek();
            if (top < min) {
                temp.push(min);
                min = top;
            } else {
                temp.push(top);
            }
            stack.pop();
        }
        return min;
    }

}
