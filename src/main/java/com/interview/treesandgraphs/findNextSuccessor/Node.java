package com.interview.treesandgraphs.findNextSuccessor;

public class Node {
    int data;

    Node left, right;

    Node parent;

    public Node(int item, Node p) {
        data = item;
        left = right = null;
        parent = p;
    }
}
