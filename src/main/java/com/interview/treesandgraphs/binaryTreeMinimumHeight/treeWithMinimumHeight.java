package com.interview.treesandgraphs.binaryTreeMinimumHeight;

import java.util.LinkedList;
import java.util.Queue;

import com.interview.treesandgraphs.balanced.TreeNode;

public class treeWithMinimumHeight {

    private static int rootSize = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode parent = root;
        while (rootSize < 10) {
            System.out.println(rootSize);
            addNode(parent, parent.getLeft(), parent.getRight(), 10);
        }
        System.out.println(root);

        printTreeBreathFirst(root);
    }

    private static void printTreeBreathFirst(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root == null)
            return;
        queue.clear();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            System.out.print(node.getValue() + " ");
            if (node.getLeft() != null)
                queue.add(node.getLeft());
            if (node.getRight() != null)
                queue.add(node.getRight());
        }

    }

    private static void addNode(TreeNode parent, TreeNode left, TreeNode right, int limit) {
        if (left == null) {
            rootSize++;
            parent.setLeft(new TreeNode(rootSize));
        } else if (right == null) {
            rootSize++;
            parent.setRight(new TreeNode(rootSize));
        } else {
            TreeNode leftLeft = left.getLeft();
            TreeNode leftRight = left.getRight();
            TreeNode rightLeft = right.getLeft();
            TreeNode rightRight = right.getRight();
            if (rootSize < limit) {
                addNode(left, leftLeft, leftRight, limit);
            }
            if (rootSize < limit) {
                addNode(right, rightLeft, rightRight, limit);
            }
        }

    }

    public static int minimumDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.getLeft() == null && node.getRight() == null) {
            return 1;
        }
        if (node.getLeft() == null) {
            return minimumDepth(node.getRight()) + 1;
        }

        if (node.getRight() == null)
            return minimumDepth(node.getLeft()) + 1;

        return Math.min(minimumDepth(node.getLeft()), minimumDepth(node.getRight())) + 1;
    }

    public static int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int lheight = height(node.getLeft());
        int rheight = height(node.getRight());
        if (lheight > rheight) {
            return (lheight + 1);
        } else {
            return (rheight + 1);
        }
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.getLeft()), maxDepth(root.getRight()));
    }

}
