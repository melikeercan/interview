package com.interview.treesandgraphs.binaryTreeMinimumHeight;

import java.util.LinkedList;
import java.util.Queue;

import com.interview.treesandgraphs.balanced.TreeNode;

public class treeWithMinimumHeight {

    private static int rootSize = 1;

    private static int[] arrs2 = new int[11];

    public static void main(String[] args) {

        for (int i = 0; i < arrs2.length; i++) {
            arrs2[i] = i;
        }
        TreeNode root = new TreeNode(arrs2[0]);
        TreeNode parent = root;
        while (rootSize < arrs2.length) {
            System.out.println(rootSize);
            addNode(parent, parent.getLeft(), parent.getRight(), arrs2.length);
        }
        System.out.println(root);

        printTreeBreathFirst(root);

        System.out.println("-------");

        int[] arrs = new int[11];
        for (int i = 0; i < arrs.length; i++) {
            arrs[i] = i;
        }

        TreeNode result = addToTree(arrs, 0, arrs.length - 1);
        System.out.println(result);
        printTreeBreathFirst(result);

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
            parent.setLeft(new TreeNode(arrs2[rootSize - 1]));
        } else if (right == null) {
            rootSize++;
            parent.setRight(new TreeNode(arrs2[rootSize - 1]));
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

    private static TreeNode addToTree(int[] arr, int start, int end) {
        if (end < start) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode n = new TreeNode(arr[mid]);
        n.setLeft(addToTree(arr, start, mid - 1));
        n.setRight(addToTree(arr, mid + 1, end));
        return n;
    }

}
