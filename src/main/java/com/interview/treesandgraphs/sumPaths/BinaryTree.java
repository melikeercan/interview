package com.interview.treesandgraphs.sumPaths;

public class BinaryTree {
    // Root of the Binary Tree
    Node root;

    public BinaryTree() {
        root = null;
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

    public Node leftMostChild() {
        if (this == null || this.root == null) {
            return null;
        }
        Node root = this.root;
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

}
