package com.interview.treesandgraphs.algorithms;

public class TreeNode {

    private int value;

    private TreeNode left;

    private TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public boolean findNode(int n) {
        TreeNode tree = this;
        while (tree != null) {
            if (tree.getValue() == n) {
                return true;
            }
            if (n > tree.getValue()) {
                tree = tree.getRight();
            } else {
                tree = tree.getLeft();
            }
        }
        return false;
    }

    public boolean remove(int n) {
        TreeNode removeNode = this;
        TreeNode tree = removeNode;
        if (tree.getValue() == n) {
            TreeNode auxNode = new TreeNode(0);
            auxNode.setLeft(tree);
            boolean result = this.remove(n, auxNode);
            removeNode = auxNode.getLeft();
            return result;
        } else {
            return this.remove(n, null);
        }

    }

    private boolean remove(int value, TreeNode parent) {
        if (value < this.getValue()) {
            if (this.getLeft() != null) {
                return this.getLeft().remove(value, this);
            }
            return false;
        } else if (value > this.getValue()) {
            if (this.getRight() != null) {
                return this.getRight().remove(value, this);
            }
            return false;
        } else {
            if (this.getLeft() != null && this.getRight() != null) {
                this.setValue(this.getRight().minValue());
                this.getRight().remove(this.getValue(), this);
            } else if (parent.getLeft() == this) {
                parent.setLeft((this.getLeft() != null) ? this.getLeft() : this.getRight());
            } else if (parent.getRight() == this) {
                parent.setRight((this.getLeft() != null) ? this.getLeft() : this.getRight());
            }
            return true;
        }
    }

    public int minValue() {
        if (this.getLeft() == null)
            return this.getValue();
        else
            return this.getLeft().minValue();
    }

    public TreeNode insert(int n) {
        TreeNode insertNode = this;
        TreeNode tree = insertNode;

        while (tree != null) {
            if (n < tree.getValue()) {
                if (tree.getLeft() == null) {
                    tree.setLeft(new TreeNode(n));
                    break;
                } else {
                    tree = tree.getLeft();
                }
            } else {
                if (tree.getRight() == null) {
                    tree.setRight(new TreeNode(n));
                    break;
                } else {
                    tree = tree.getRight();
                }
            }
        }
        return insertNode;
    }
}
