/**
 *
 */
package com.interview.linkedLists.removeDuplicates;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author MelikeErcan
 *
 */
public class RemoveDuplicatesFromLinkedList {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Node head = initHead(10);
        System.out.println("initiated....");

        Node removed = removeDuplicatesWithoutTemp(head);
        System.out.println(removed.data);
    }

    public static Node removeDuplicatesWithoutTemp(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node first = head;
        while (first.next != null) {
            Node rest = first.next;
            int firstData = first.data;
            System.out.println("first: " + firstData);
            while (rest.next != null) {
                int restData = rest.data;
                System.out.println("rest: " + restData);
                if (firstData == restData) {
                    System.out.println("firstData == restData == " + restData);
                    head = head.deleteNode(head, firstData);
                    break;
                }
                rest = rest.next;
            }
            first = first.next;
        }
        if (first.next == null) {
            head = head.deleteNode(head, first.data);
        }
        return head;
    }

    /**
     * @param head
     * @return
     */
    public static void removeDuplicates(Node head) {
        Map<Integer, Boolean> map = new HashMap<>();
        Node previous = null;
        while (head != null) {
            Integer data = head.data;
            System.out.println("data: " + data);
            Boolean exists = map.get(data);
            if (exists == null) {
                map.put(data, true);
                previous = head;
            } else {
                previous.next = head.next;
            }
            head = head.next;
        }
    }

    private static Node initHead(int n) {
        if (n == 0) {
            return null;
        }
        Node head = new Node(0);
        System.out.println(head.data);
        for (int i = 0; i < n; i++) {
            Random rn = new Random();
            int random = rn.nextInt(6);
            System.out.println(random);
            head.appendToTail(random);
        }
        return head;
    }

}
