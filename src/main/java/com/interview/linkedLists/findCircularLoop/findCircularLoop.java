package com.interview.linkedLists.findCircularLoop;

import java.util.HashMap;
import java.util.Map;

import com.interview.linkedLists.removeDuplicatesFromUnsorted.Node;

public class findCircularLoop {

	public static void main(String[] args) {
		Node head = initialize();
		Node first = head;
		printNodes(first);
		Integer loopBegin = findLoop(head);
		if(loopBegin == null) {
			System.out.println("No loop");
		}
		System.out.println(loopBegin);
	}

	private static Integer findLoop(Node head) {
		Map<Integer, Boolean> values = new HashMap<Integer, Boolean>();
		while(head != null) {
			int data = head.data;
			Boolean exists = values.get(data);
			if(exists != null) {
				return data;
			} else {
				values.put(data, true);
			}
			head = head.next;
		}
		return null;
	}

	private static void printNodes(Node n) {
		System.out.println(n.data);
		while(n.next != null) {
			System.out.println(n.next.data);
			n = n.next;
		}
		System.out.println("-------");
	}
	
	private static Node initialize() {
		Node firstNode =  null;
		for(int i = 1; i < 6; i++) {
			if(firstNode == null) {
				firstNode = new Node(i);
			} else {
				firstNode.appendToTail(i);
			}
			
		}
		firstNode.appendToTail(3);
		return firstNode;
	}
}
