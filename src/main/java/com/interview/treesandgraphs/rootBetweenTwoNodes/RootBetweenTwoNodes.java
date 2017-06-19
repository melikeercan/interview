package com.interview.treesandgraphs.rootBetweenTwoNodes;

import java.util.Iterator;
import java.util.List;

public class RootBetweenTwoNodes {

    public static void main(String[] args) {
        Node node1 = new Node(1);

        Node node2 = new Node(2);
        node1.addLink(node2);

        Node node3 = new Node(3);
        node2.addLink(node3);

        Node node4 = new Node(4);
        node3.addLink(node4);

        node4.addLink(node3);

        node3.addLink(node2);

        boolean isLoop = isLoop(node2, node4);
        System.out.println(isLoop);

        System.out.println(".....");

        Node node1a = new Node(1);

        Node node2a = new Node(2);
        node1a.addLink(node2a);

        Node node3a = new Node(3);

        Node node4a = new Node(4);
        node2a.addLink(node4a);

        node4a.addLink(node3a);

        node3a.addLink(node2a);
        boolean isLoop2 = isLoop(node2a, node4a);
        System.out.println(isLoop2);
    }

    private static boolean isLoop(Node begin, Node end) {
        if (begin == null || end == null) {
            return false;
        }
        List<Node> beginLinks = begin.links;
        if (beginLinks == null) {
            return false;
        }
        boolean fromAToB = fromAToB(begin, end);
        System.out.println("fromAToB: " + fromAToB + " begin: " + begin.data + " end: " + end.data);
        if (fromAToB) {
            return fromAToB(end, begin);
        }
        return false;
    }

    private static boolean fromAToB(Node begin, Node end) {
        System.out.println("----" + begin.data + " " + end.data);
        List<Node> beginLinks = begin.links;
        if (begin.equals(end)) {
            return true;
        }
        if (beginLinks == null) {
            return false;
        }
        Iterator<Node> beginLinksIt = beginLinks.iterator();
        while (beginLinksIt.hasNext()) {
            Node beginLink = beginLinksIt.next();
            boolean result = fromAToB(beginLink, end);
            beginLinksIt.remove();
            return result;
        }
        return false;
    }

}
