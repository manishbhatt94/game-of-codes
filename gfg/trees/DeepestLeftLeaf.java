package gfg.trees;

import gfg.com.lib.tree.TreeNode;
import gfg.com.lib.tree.BinaryTree;


public class DeepestLeftLeaf {

    static TreeNode targetNode;
    static int maxDepth;

    /**
     *          1
     *        /   \
     *       2     3
     *     /      /  \
     *    4      5    6
     *           \     \
     *            7     8
     *           /       \
     *          9         10
     */
    public static void makeSampleTree(BinaryTree tree) {
        int inorder[] = { 4, 2, 1, 5, 9, 7, 3, 6, 8, 10 };
        int preorder[] = { 1, 2, 4, 3, 5, 7, 9, 6, 8, 10 };
        tree.buildTreeFromInorderPreorder(inorder, preorder);
    }

    /**
     * [getDeepestLeftLeafUtil description]
     * @param root      [description]
     * @param prevDepth [description]
     * Uses and modifies static class variables: `targetNode` and `maxDepth`
     */
    public static void getDeepestLeftLeafUtil(TreeNode root, int depth, boolean isLeftChild) {
        if (root == null) {
            return;
        }

        if (isLeftChild && root.isLeaf() && depth > maxDepth) {
            maxDepth = depth;
            targetNode = root;
            return;
        }

        getDeepestLeftLeafUtil(root.left, depth + 1, true);
        getDeepestLeftLeafUtil(root.right, depth + 1, false);
    }

    public static TreeNode getDeepestLeftLeaf(TreeNode root) {
        targetNode = null;
        maxDepth = 0;
        getDeepestLeftLeafUtil(root, 0, false);
        return targetNode;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        makeSampleTree(tree);

        TreeNode node = getDeepestLeftLeaf(tree.root);
        if (node != null) {
            System.out.println("The deepest left leaf is " + node.data);
        } else {
            System.out.println("There is no left child in this tree!");
        }
    }
}
