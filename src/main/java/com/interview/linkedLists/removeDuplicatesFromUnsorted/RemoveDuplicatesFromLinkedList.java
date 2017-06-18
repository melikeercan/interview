package com.interview.linkedLists.removeDuplicatesFromUnsorted;

import java.util.Hashtable;

/**
 * @author MelikeErcan
 * 262 940 26 168 NURIYE KOC      DR BARAN ORTOPEDIST
 */
public class RemoveDuplicatesFromLinkedList {

	public static void main(String[] args) {
//		Node initialNodesRandom = initNodesRandom(5);
		Node initialNodesGiven = initNodesGiven(5);
		Node n = initialNodesGiven;
		printNodes(n);
		System.out.println(":::::");
//		deleteDuplicates(n);
		deleteDups2(n);
		printNodes(n);
	}
	
	public static void deleteDuplicates(Node n) {
		Hashtable<Integer, Boolean> table = new Hashtable<Integer, Boolean>();
		Node previous = null;
		while (n != null) {
			if(table.contains(n.data)) {
				previous.next = n.next;
			} else {
				table.put(n.data, true);
				previous = n;
			}
			n = n.next;
		}
	}
	
	private static void printNodes(Node n) {
		System.out.println(n.data);
		while(n.next != null) {
			System.out.println(n.next.data);
			n = n.next;
		}
	}

	private static Node initNodesGiven(int listLength) {
		Node firstNode =  new Node(3);
		firstNode.appendToTail(4);
		firstNode.appendToTail(3);
		firstNode.appendToTail(2);
		firstNode.appendToTail(3);
		firstNode.appendToTail(1);
		return firstNode;
	}
	
	public static void deleteDups2(Node head) {
		if (head == null) 
			return;
		Node previous = head;
		Node current = previous.next;
		while (current != null) {
			Node runner = head;
			while (runner != current) {
				if (runner.data == current.data) {
					Node tmp = current.next; // remove current
					previous.next = tmp;
					current = tmp; // update current to next node
					break; // all other dups have already been removed
				}
				runner = runner.next;
			}
			if (runner == current) { // current not updated - update now 
				previous = current;
				current = current.next;
			}
		}
	}

//	private static Node initNodesRandom(int listLength) {
//		//random.nextInt(max - min + 1) + min between 1-5
//		Random rm = new Random();
//		int firstValue = rm.nextInt(5 - 1 + 1);
//		Node firstNode =  new Node(firstValue);
//		for(int i = 0; i < listLength; i++) {
//			int value = rm.nextInt(5 - 1 + 1);
//			firstNode.appendToTail(value);
//		}
//		return firstNode;
//	}

}
