package com.interview.treesandgraphs.depthList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.interview.treesandgraphs.balanced.TreeNode;

public class treeToListForDepth {
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
        Map<Integer, List<Integer>> map = toLinkedList(root);
        System.out.println(map);
        printMap(map);
    }

    private static void printMap(Map<Integer, List<Integer>> map) {
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            System.out.println("level: " + entry.getKey() + "/" + entry.getValue());

        }
    }

    private static Map<Integer, List<Integer>> toLinkedList(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Integer level = 0;
        TreeNode head = root;
        List<Integer> rootLevel = new ArrayList<>(1);
        rootLevel.add(root.getValue());
        map.put(level, rootLevel);

        while (root.getLeft() != null || root.getRight() != null) {
            level++;
            addToList(root, map, level);
            TreeNode left = root.getLeft();
            addToList(left, map, level);
            TreeNode right = root.getRight();
            addToList(right, map, level);
        }

        level = 0;
        while (head != null) {
            level++;
            addToList(head, map, level);
            TreeNode left = head.getLeft();
            addToList(left, map, level);
            TreeNode right = head.getRight();
            addToList(right, map, level);
        }
        return map;
    }

    private static void addToList(TreeNode root, Map<Integer, List<Integer>> map, Integer level) {
        List<Integer> list = map.get(level);
        if (list == null) {
            list = new ArrayList<>();
            if (root.getLeft() != null && !list.contains(root.getLeft().getValue())) {
                list.add(root.getLeft().getValue());
            }
            if (root.getRight() != null && !list.contains(root.getRight().getValue())) {
                list.add(root.getRight().getValue());
            }
            map.put(level, list);
        } else {
            if (root.getLeft() != null && !list.contains(root.getLeft().getValue())) {
                list.add(root.getLeft().getValue());
            }
            if (root.getRight() != null && !list.contains(root.getRight().getValue())) {
                list.add(root.getRight().getValue());
            }
        }
    }

    private static void addNode(TreeNode parent, TreeNode left, TreeNode right, int limit) {
        if (left == null) {
            parent.setLeft(new TreeNode(arrs2[rootSize]));
            rootSize++;
        } else if (right == null) {
            parent.setRight(new TreeNode(arrs2[rootSize]));
            rootSize++;
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
