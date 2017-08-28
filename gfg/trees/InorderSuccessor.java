package gfg.trees;

import gfg.com.lib.tree.TreeNode;
import gfg.com.lib.tree.BinaryTree;


// Credits: http://algorithms.tutorialhorizon.com/inorder-successor-in-binary-tree/

public class InorderSuccessor {

    public static boolean nodeFound = false;
    public static TreeNode n = null;

    /**
     *           1
     *         /   \
     *       2      3
     *     /  \    / \
     *    4    5  6   7
     *        /
     *       8
     *        \
     *         9
     *          \
     *           10
     */
    public static void makeSampleTree(BinaryTree tree) {
        int inorder[] = { 4, 2, 8, 9, 10, 5, 1, 6, 3, 7 };
        int preorder[] = { 1, 2, 4, 5, 8, 9, 10, 3, 6, 7 };
        tree.buildTreeFromInorderPreorder(inorder, preorder);
    }

    public static TreeNode getLeftmostTreeNode(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static TreeNode findRecur(TreeNode root, TreeNode x) {
        if (root == null) {
            return null;
        }

        if (
            root == x ||
            (n = findRecur(root.left, x)) != null ||
            (n = findRecur(root.right, x)) != null
        ) {
            if (n != null) {
                if (root.left == n) {
                    nodeFound = true;
                    System.out.println("The In Order Successor for '" + x.data + "' is "+ root.data );
                    return null;
                }
            }
            return root;
        }

        return null;
    }

    public static TreeNode getInorderSuccessor(TreeNode root, TreeNode x) {
        nodeFound = false;
        n = null;
        if (x.right != null) {
            TreeNode temp = getLeftmostTreeNode(root.right);
            System.out.println("The In Order Successor for '" + x.data + "' is "+ temp.data);
            return null;
        }
        return findRecur(root, x);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        makeSampleTree(tree);
        tree.printInorder();
        TreeNode x = tree.search(10);
        if (x != null) {
            getInorderSuccessor(tree.root, x);
            if (!nodeFound) {
                System.out.println("The In Order Successor for '" + x.data + "' is NULL");
            }
        }
    }
}
