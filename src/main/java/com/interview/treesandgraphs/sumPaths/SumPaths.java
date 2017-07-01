package com.interview.treesandgraphs.sumPaths;

import java.util.ArrayList;
import java.util.List;

public class SumPaths {
    static List<List<Integer>> masterList = new ArrayList<>();

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        tree.root = new Node(10, null);
        tree.root.left = new Node(5, tree.root);
        tree.root.right = new Node(30, tree.root);
        tree.root.left.left = new Node(3, tree.root.left);
        tree.root.left.right = new Node(8, tree.root.left);
        tree.root.right.left = new Node(20, tree.root.right);
        tree.root.right.right = new Node(45, tree.root.right);
        tree.root.left.left.left = new Node(2, tree.root.left.left);
        tree.root.left.left.right = new Node(4, tree.root.left.left);
        tree.root.left.right.left = new Node(7, tree.root.left.right);
        tree.root.left.right.right = new Node(9, tree.root.left.right);

        listSumPaths(tree.root);
    }

    private static void listSumPaths(Node root) {
        List<Node> leaves = new ArrayList<>();
        getLeaves(root, leaves);

        getPaths(leaves);
        System.out.println(masterList);
        List<List<Integer>> sums = sums(20);
        System.out.println("==========");
        System.out.println(sums);
    }

    private static List<List<Integer>> sums(int sumVal) {
        List<List<Integer>> sums = new ArrayList<>();
        for (List<Integer> valueList : masterList) {

            int index = 0;
            while (!valueList.isEmpty() && index < valueList.size()) {
                int sum = 0;
                List<Integer> subs = valueList.subList(index, valueList.size());
                System.out.println("current list: " + subs);
                for (int i = 0; i < subs.size(); i++) {
                    sum += subs.get(i);
                    if (sum == sumVal) {
                        sums.add(valueList.subList(0, i + 1));
                    } else if (sum > sumVal) {
                        break;
                    }
                }
                index++;
            }

        }
        return sums;
    }

    private static void getPaths(List<Node> leaves) {
        for (Node leaf : leaves) {
            List<Integer> values = new ArrayList<>();
            while (leaf != null) {
                values.add(leaf.data);
                leaf = leaf.parent;
            }
            masterList.add(values);
        }

    }

    private static void getLeaves(Node root, List<Node> leaves) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leaves.add(root);
        } else {
            getLeaves(root.left, leaves);
            getLeaves(root.right, leaves);
        }

    }

}
