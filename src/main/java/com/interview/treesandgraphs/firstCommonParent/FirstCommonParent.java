package com.interview.treesandgraphs.firstCommonParent;

import java.util.ArrayList;
import java.util.List;

public class FirstCommonParent {

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1, null);
        tree.root.left = new Node(2, tree.root);
        tree.root.right = new Node(3, tree.root);
        tree.root.left.left = new Node(4, tree.root.left);
        tree.root.left.right = new Node(5, tree.root.left);
        tree.root.right.left = new Node(6, tree.root.right);
        tree.root.left.left.left = new Node(7, tree.root.left.left);

        Node common = getFirstCommonSuccessor(tree.root.left.left.left, tree.root.left.right);
        System.out.println(common);
    }

    private static Node getFirstCommonSuccessor(Node n1, Node n2) {
        List<Node> n1List = new ArrayList<>();
        List<Node> n2List = new ArrayList<>();
        while (n1.parent != null) {
            n1 = n1.parent;
            n1List.add(n1);
        }

        while (n2.parent != null) {
            n2 = n2.parent;
            n2List.add(n2);
        }

        if (n1List.size() > n2List.size()) {
            for (Node n1Int : n1List) {
                for (Node n2Int : n2List) {
                    if (n1Int.equals(n2Int)) {
                        return n1Int;
                    }
                }
            }
        } else {
            for (Node n2Int : n2List) {
                for (Node n1Int : n1List) {
                    if (n1Int.equals(n2Int)) {
                        return n1Int;
                    }
                }
            }
        }

        return null;
    }

}
