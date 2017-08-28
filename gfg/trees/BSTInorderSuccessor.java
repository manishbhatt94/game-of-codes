package gfg.trees;

import gfg.com.lib.tree.TreeNode;
import gfg.com.lib.tree.BST;


public class BSTInorderSuccessor {

    public static TreeNode leftMostNode(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // Credits: http://algorithms.tutorialhorizon.com/inorder-successor-in-binary-search-tree-using-parent-link/
    // or CLRS
    public static TreeNode findInorderSuccessorUsingParents(TreeNode root, TreeNode x) {
        if (x.right != null) {
            return leftMostNode(x.right);
        }
        TreeNode y = x.parent;
        while (y != null && x == y.right) {
            x = y;
            y = y.parent;
        }
        return y;
    }

    // Credits: http://algorithms.tutorialhorizon.com/inorder-successor-in-binary-search-tree-without-using-parent-link/
    public static TreeNode findInorderSuccessor(TreeNode root, TreeNode x) {
        if (x.right != null) {
            return leftMostNode(x.right);
        }

        TreeNode succ = null;
        while (root != null) {
            if (x.data < root.data) {
                succ = root;
                root = root.left;
            } else if (x.data > root.data) {
                root = root.right;
            } else {
                return succ;
            }
        }

        return null;
    }

    /**
     *           100
     *         /     \
     *       50      150
     *      /  \     /  \
     *    20   90  120  180
     *        /
     *       55
     *        \
     *        60
     *          \
     *          75
     */
    public static void main(String[] args) {
        BST tree = new BST();

        // building BST
        int values[] = { 100, 50, 150, 20, 90, 120, 180, 55, 60, 75 };
        for (int value: values) {
            tree.insertNode(value);
        }

        // getting ref of node whose successor is to be found
        TreeNode node = tree.search(90);

        if (node != null) {
            // getting successor without parent pointers
            TreeNode succ = findInorderSuccessor(tree.root, node);
            System.out.println("The inorder successor of " + node.data + " is " +
                (succ != null ? succ.data : "NULL"));
            // getting successor with parent pointers
            tree.populateParentPointers();
            succ = findInorderSuccessorUsingParents(tree.root, node);
            System.out.println("The inorder successor of " + node.data + " is " +
                (succ != null ? succ.data : "NULL"));
        }
    }
}
