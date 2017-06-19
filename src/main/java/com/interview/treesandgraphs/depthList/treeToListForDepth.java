package com.interview.treesandgraphs.depthList;

import java.util.ArrayList;
import java.util.List;

import com.interview.treesandgraphs.balanced.TreeNode;

public class treeToListForDepth {
    private static int rootSize = 1;

    private static int[] arrs2 = new int[11];

    public static void main(String[] args) {
        TreeNode root = init();
        toLinkedList(root);
    }

    private static List<List<TreeNode>> toLinkedList(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }
        List<List<TreeNode>> list = new ArrayList<>();
        List<TreeNode> depthList = new ArrayList<>();
        depthList.add(root);
        list.add(depthList);

        return list;
    }

    private static void addToList(List<List<TreeNode>> list, TreeNode left, TreeNode right) {
        // TODO Auto-generated method stub
        List<TreeNode> depthList = new ArrayList<>();
        depthList.add(left);
        depthList.add(right);
        list.add(depthList);

    }

    private static TreeNode init() {
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
        return root;
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
}
