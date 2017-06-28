package com.interview.treesandgraphs.algorithms;

public class BinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.insert(15);
        root.insert(25);
        root.insert(10);
        root.insert(12);
        root.insert(18);
        root.insert(19);
        root.insert(16);
        root.insert(17);

        System.out.println(root.getValue());

        boolean isFound = root.findNode(17);
        System.out.println(isFound);

        System.out.println(root.getValue());

        root.remove(18);
        System.out.println(root.getValue());
        // TreeNode result = root.delete(20);
        // System.out.println(result.getValue());
    }

}
