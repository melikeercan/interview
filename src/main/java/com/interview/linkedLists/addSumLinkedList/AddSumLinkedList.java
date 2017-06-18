package com.interview.linkedLists.addSumLinkedList;

import com.interview.linkedLists.removeDuplicatesFromUnsorted.Node;

public class AddSumLinkedList {

	public static void main(String[] args) {
		Node firstList = initialize1();
		Node secondList = initalize2();
		
		int output = calculateSum(firstList, secondList);
		System.out.println("output:" + output);

		
		Node diffLength1 = initializeDiff1();
		Node diffLength2 = initializeDiff2();
		int diffOutput = calculateSumDiff(diffLength1, diffLength2);
		System.out.println("diffOutput:" + diffOutput);
	}
	
	

	private static int calculateSumDiff(Node firstList, Node secondList) {
		Node first = firstList;
		Node second = secondList;
		
		int firstListLength = 0;
		while(first != null) {
			firstListLength++;
			first = first.next;
		}
		System.out.println(firstListLength);
		
		int secondListLength = 0;
		while(second != null) {
			secondListLength++;
			second = second.next;
		}
		System.out.println(secondListLength);
		
		if(firstListLength > secondListLength) {
			int diff = firstListLength - secondListLength;
			while(diff > 0) {
				secondList.appendToTail(0);
				diff--;
			}
		} else if (secondListLength > firstListLength) {
			int diff = secondListLength - firstListLength;
			while(diff > 0) {
				firstList.appendToTail(0);
				diff--;
			}
		}
		return calculateSum(firstList, secondList);
	}



	private static int calculateSum(Node firstList, Node secondList) {
		int sum = 0;
		int length = 0;
		Node result = null;
		while(firstList != null) {
			sum = (firstList.data + secondList.data);
			if(result == null) {
				result = new Node(sum);
			} else {
				result.appendToTail(sum);
			}
			length++;
			firstList = firstList.next;
			secondList = secondList.next;
		}
		printNodes(result);
		int multiply = 1;
		
		int output = 0;
		for(int i = 0; i < length; i++) {
			output += result.data * multiply;
			multiply *= 10;
			result = result.next;
		}
		return output;
	}

	private static void printNodes(Node n) {
		System.out.println(n.data);
		while(n.next != null) {
			System.out.println(n.next.data);
			n = n.next;
		}
		System.out.println("-------");
	}

	private static Node initalize2() {
		Node node =  new Node(5);
		node.appendToTail(9);
		node.appendToTail(2);
		return node;
	}

	private static Node initialize1() {
		Node node =  new Node(3);
		node.appendToTail(1);
		node.appendToTail(5);
		return node;
	}
	
	private static Node initializeDiff1() {
		Node node =  new Node(3);
		node.appendToTail(1);
		node.appendToTail(5);
		return node;
	}

	private static Node initializeDiff2() {
		Node node =  new Node(9);
		node.appendToTail(5);
		return node;
	}
}
