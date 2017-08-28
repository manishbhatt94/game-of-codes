package gfg.com.lib.tree;

import gfg.com.lib.tree.TreeNode;

public class BST {
    public TreeNode root;

    public BST() {
        this.root = null;
    }

    public BST(TreeNode root) {
        this.root = root;
    }

    private TreeNode insertNodeUtil(TreeNode node, int key) {
        if (node == null) {
            return new TreeNode(key);
        }

        if (key < node.data) {
            node.left = insertNodeUtil(node.left, key);
        } else if (key > node.data) {
            node.right = insertNodeUtil(node.right, key);
        }

        return node;
    }

    public void insertNode(int key) {
        this.root = this.insertNodeUtil(this.root, key);
    }

    private void printInorderUtil(TreeNode node) {
        if (node == null) {
            return;
        }
        printInorderUtil(node.left);
        System.out.print(node.data + " ");
        printInorderUtil(node.right);
    }

    public void printInorder() {
        this.printInorderUtil(this.root);
        System.out.println();
    }

    private void printPreorderUtil(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        printPreorderUtil(node.left);
        printPreorderUtil(node.right);
    }

    public void printPreorder() {
        this.printPreorderUtil(this.root);
        System.out.println();
    }

    private int getTreeHeightUtil(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return (
            1 + Math.max(getTreeHeightUtil(node.left), getTreeHeightUtil(node.right))
        );
    }

    public int getTreeHeight() {
        return this.getTreeHeightUtil(this.root);
    }

    private TreeNode searchUtil(TreeNode node, int key) {
        if (node == null || node.data == key) {
            return node;
        }

        if (key < node.data) {
            return searchUtil(node.left, key);
        }
        return searchUtil(node.right, key);
    }

    public TreeNode search(int key) {
        return this.searchUtil(this.root, key);
    }

    private void populateParentPointersUtil(TreeNode node, TreeNode parentNode) {
        if (node == null) {
            return;
        }
        node.parent = parentNode;
        populateParentPointersUtil(node.left, node);
        populateParentPointersUtil(node.right, node);
    }

    public void populateParentPointers() {
        this.populateParentPointersUtil(this.root, null);
    }
}
