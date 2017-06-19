package com.interview.treesandgraphs.balanced;

public class checkIfBalanced {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(3);
        root.setLeft(left1);
        root.setRight(right1);
        TreeNode left1left = new TreeNode(4);
        left1.setLeft(left1left);
        TreeNode leftend = new TreeNode(5);
        left1left.setLeft(leftend);
        int max = maxDepth(root);
        System.out.println(max);

        int min = minDepth(root);
        System.out.println(min);

        boolean isBalanced = isBalanced(root);
        System.out.println(isBalanced);
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.getLeft()), maxDepth(root.getRight()));
    }

    private static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.min(minDepth(root.getLeft()), minDepth(root.getRight()));
    }

    public static boolean isBalanced(TreeNode root) {
        return (maxDepth(root) - minDepth(root) <= 1);
    }

}
