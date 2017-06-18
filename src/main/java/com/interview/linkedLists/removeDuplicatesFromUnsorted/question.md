Linked Lists

1.1 Write code to remove duplicates from an unsorted linked list.
FOLLOW UP
How would you solve this problem if a temporary buffer is not allowed?


package com.interview.linkedlists.removeDuplicatesFromUnsorted;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RemoveDuplicates {

	public static void main(String[] args) {
		LinkedListNode head = initList();
		removeDuplicates(head);
	}
	
	private static void addLast(LinkedListNode head, LinkedListNode tail, LinkedListNode newNode) {
		if (newNode == null)
            return;
      else {
            newNode.next = null;
            if (head == null) {
                  head = newNode;
                  tail = newNode;
            } else {
                  tail.next = newNode;
                  tail = newNode;
            }
      }
	}

	private static LinkedListNode initList() {
		Random rn = new Random();
		int random = rn.nextInt(10);
		LinkedListNode head = new LinkedListNode(random);
		LinkedListNode tail = head;
		int randomOther = rn.nextInt(10);
		LinkedListNode newNode = new LinkedListNode(randomOther);
		for(int i = 0; i < 10; i++) {
			addLast(head, tail, newNode);
		}
		return head;
	}

	public static LinkedListNode removeDuplicates(LinkedListNode head) {
		
		if(head == null || head.next == null) {
			return head;
		} 
		LinkedListNode after = head;
		System.out.println("prev");
		LinkedListNode temp = head;
		while(temp.next != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
		System.out.println("map");
		Map<Integer, Integer> map = new HashMap<>();
		
		while(head.next != null) {
			int currentData = head.data;
			System.out.println(currentData);
			Integer contains = map.get(currentData);
			if(contains == null) {
				System.out.println("does not contain: " + contains);
				map.put(currentData, currentData);
				head = head.next;
			} else {
				System.out.println("contains: " + contains);
				head = head.next.next;
			}
		}
		
		
		System.out.println("after");
		while(after.next != null) {
			System.out.println(after.data);
			after = after.next;
		}
		
		return head;
		
	}
}
