package com.interview.linkedLists.nthLastInLinkedList;

import com.interview.linkedLists.removeDuplicatesFromUnsorted.Node;

public class nthLast {
	public static void main(String[] args) {
		Node first = initialize();
		Node nthLast = returnNthLasth(first, 3);
		System.out.println(nthLast.data);
	}

	private static Node initialize() {
		int i = 0;
		Node firstNode =  new Node(i);
		for(; i < 15; i++) {
			firstNode.appendToTail(i);
		}
		return firstNode;
	}
	
	public static Node returnNthLasth(Node first, int n) {
		if(first == null || first.next == null || first.next.next == null) {
			return null;
		}
		Node initalPointer = first;
		Node laterPointer = first.next.next;
		
		while(laterPointer != null) {
			initalPointer = initalPointer.next;
			laterPointer = laterPointer.next;
		}
		return initalPointer;
	}
}
