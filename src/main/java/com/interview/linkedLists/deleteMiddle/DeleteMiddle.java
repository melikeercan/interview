package com.interview.linkedLists.deleteMiddle;

import com.interview.linkedLists.removeDuplicatesFromUnsorted.Node;

public class DeleteMiddle {
	public static void main(String[] args) {
		Node first = initialize();
		Node head = first;
		printNodes(head);
		deleteTheMiddle(head);
		printNodes(head);
	}
	
	private static void deleteTheMiddle(Node first) {
		if(first == null || first.next == null) {
			return;
		}
		Node prev = null;
		Node oneUnitIterate = first;
		Node twoUnitsIterate = first;
		
		while(twoUnitsIterate.next != null && twoUnitsIterate.next.next != null) {
			prev = oneUnitIterate;
			oneUnitIterate = oneUnitIterate.next;
			twoUnitsIterate = twoUnitsIterate.next.next;
		}
		
		System.out.println("middle: " + oneUnitIterate.data);
		System.out.println("prev: " + prev.data);
		
		Node tmp = oneUnitIterate.next; // remove current
		prev.next = tmp;
		oneUnitIterate = tmp; // update current to next node
		
		
		
	}

	private static Node initialize() {
		Node firstNode =  new Node(0);
		for(int i = 1; i < 6; i++) {
			firstNode.appendToTail(i);
		}
		return firstNode;
	}
	
	private static void printNodes(Node n) {
		System.out.println(n.data);
		while(n.next != null) {
			System.out.println(n.next.data);
			n = n.next;
		}
		System.out.println("-------");
	}
}
