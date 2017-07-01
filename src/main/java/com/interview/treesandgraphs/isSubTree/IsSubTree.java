package com.interview.treesandgraphs.isSubTree;

public class IsSubTree {

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1, null);
        tree.root.left = new Node(2, tree.root);
        tree.root.right = new Node(3, tree.root);
        tree.root.left.left = new Node(4, tree.root.left);
        tree.root.left.right = new Node(5, tree.root.left);
        tree.root.right.left = new Node(6, tree.root.right);
        tree.root.left.left.left = new Node(7, tree.root.left.left);

        Boolean isSubTree = isSubTree(tree.root.left, tree.root.left.left.left);
        System.out.println(isSubTree);
    }

    private static Boolean isSubTree(Node left, Node right) {
        if (right == null) {
            return false;
        }
        return subTree(left, right);
    }

    private static Boolean subTree(Node left, Node right) {
        if (left == null) {
            return false;
        }
        if (left.data == right.data) {
            if (matchTree(left, right)) {
                return true;
            }
        }
        return subTree(left.left, right) || subTree(left.right, right);
    }

    private static boolean matchTree(Node left, Node right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }

        if (left.data != right.data) {
            return false;
        }
        return (matchTree(left.left, right.left) && matchTree(left.right, right.right));
    }

}
