package com.interview.treesandgraphs.depthList;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    // Root of the Binary Tree
    Node root;

    public BinaryTree() {
        root = null;
    }

    /* function to print level order traversal of tree */
    void printLevelOrder() {
        int h = height(root);
        int i;
        List<List<Integer>> masterList = new ArrayList<>();
        for (i = 1; i <= h; i++) {
            System.out.println("i: " + i);
            List<Integer> intList = new ArrayList<>();
            printGivenLevel(root, i, intList);
            masterList.add(intList);
        }
        System.out.println("===========");
        System.out.println(masterList);
    }

    /*
     * Compute the "height" of a tree -- the number of nodes along the longest path from the root node down to the
     * farthest leaf node.
     */
    int height(Node root) {
        if (root == null)
            return 0;
        else {
            /* compute height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);

            /* use the larger one */
            if (lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }

    /* Print nodes at the given level */
    void printGivenLevel(Node root, int level, List<Integer> intList) {
        System.out.println("level: " + level);
        if (root == null)
            return;
        if (level == 1) {
            System.out.println(root.data + " ");
            intList.add(root.data);
            System.out.println(intList);
        } else if (level > 1) {

            printGivenLevel(root.left, level - 1, intList);
            printGivenLevel(root.right, level - 1, intList);
        }
    }

    /* Driver program to test above functions */
    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.left.left.left = new Node(7);

        System.out.println("Level order traversal of binary tree is ");
        tree.printLevelOrder();
    }
}
