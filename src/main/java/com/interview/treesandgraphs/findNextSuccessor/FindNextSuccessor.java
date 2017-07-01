package com.interview.treesandgraphs.findNextSuccessor;

public class FindNextSuccessor {

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1, null);
        tree.root.left = new Node(2, tree.root);
        tree.root.right = new Node(3, tree.root);
        tree.root.left.left = new Node(4, tree.root.left);
        tree.root.left.right = new Node(5, tree.root.left);
        tree.root.right.left = new Node(6, tree.root.right);
        tree.root.left.left.left = new Node(7, tree.root.left.left);

        // Node x = tree.leftMostChild();
        // System.out.println(x.data);

        Node node = inorderSucc(tree.root.left);
        System.out.println(node.data);
    }

    private static Node inorderSucc(Node node) {
        if (node != null) {
            Node p = null;
            if (node.parent == null || node.right != null) {
                p = leftMostChild(node.right);
            } else {
                while ((p = node.parent) != null) {
                    if (p.left == node) {
                        break;
                    }
                    node = p;
                    System.out.println(node.data);
                }
            }
            return p;
        }
        return null;
    }

    public static Node leftMostChild(Node node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
