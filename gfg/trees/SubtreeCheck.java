package gfg.trees;

import gfg.com.lib.tree.TreeNode;
import gfg.com.lib.tree.BinaryTree;


public class SubtreeCheck {

    /**
     *          3
     *        /   \
     *       4     5
     *     /  \
     *    1    2
     */
    public static void makeSampleTree1(BinaryTree tree) {
        int inorder[] = { 1, 4, 2, 3, 5 };
        int preorder[] = { 3, 4, 1, 2, 5 };
        tree.buildTreeFromInorderPreorder(inorder, preorder);
    }

    /**
     *      4
     *     / \
     *    1   2
     */
    public static void makeSampleTree2(BinaryTree tree) {
        int inorder[] = { 1, 4, 2 };
        int preorder[] = { 4, 1, 2 };
        tree.buildTreeFromInorderPreorder(inorder, preorder);
    }

    /**
     * Check if t is subtree of s, or not
     */
    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.data == t.data) {
            return isSubtree(s.left, t.left) && isSubtree(s.right, t.right);
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public static void main(String[] args) {
        BinaryTree tree1 = new BinaryTree();
        makeSampleTree1(tree1);
        BinaryTree tree2 = new BinaryTree();
        makeSampleTree2(tree2);
        tree1.printInorder();
        tree2.printInorder();
        System.out.println("Is tree2 a subtree of tree1 ?");
        System.out.println(isSubtree(tree1.root, tree2.root));
    }
}
