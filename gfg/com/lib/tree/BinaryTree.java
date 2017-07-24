package gfg.com.lib.tree;

import gfg.com.lib.tree.TreeNode;

public class BinaryTree {
    public TreeNode root;
    private int preorderIndex;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    private static int search(int[] arr, int start, int end, int key) {
        for (int i = start; i <= end; ++i) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    private TreeNode buildTreeInorderPreorderUtil(int[] in, int[] pre,
        int inBeg, int inEnd) {

        if (inBeg > inEnd) {
            return null;
        }

        TreeNode node = new TreeNode(pre[this.preorderIndex++]);

        if (inBeg == inEnd) {
            return node;
        }

        int inIndex = search(in, inBeg, inEnd, node.data);
        node.left = buildTreeInorderPreorderUtil(in, pre, inBeg, inIndex - 1);
        node.right = buildTreeInorderPreorderUtil(in, pre, inIndex + 1, inEnd);

        return node;
    }

    public void buildTreeFromInorderPreorder(int[] inorder, int[] preorder) {
        this.preorderIndex = 0;
        this.root = buildTreeInorderPreorderUtil(inorder, preorder, 0, inorder.length - 1);
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
}
