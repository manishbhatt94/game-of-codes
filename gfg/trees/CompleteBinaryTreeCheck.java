// Question Link:
// Iterative: http://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-complete-tree-or-not/
// Recursive: http://www.geeksforgeeks.org/check-whether-binary-tree-complete-not-set-2-recursive-solution/

package gfg.trees;

import java.util.Queue;
import java.util.LinkedList;

import gfg.com.lib.tree.TreeNode;
import gfg.com.lib.tree.BinaryTree;


public class CompleteBinaryTreeCheck {

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
    public static void makeSampleTree1(BinaryTree tree) {
        int inorder[] = { 4, 2, 1, 5, 9, 7, 3, 6, 8, 10 };
        int preorder[] = { 1, 2, 4, 3, 5, 7, 9, 6, 8, 10 };
        tree.buildTreeFromInorderPreorder(inorder, preorder);
    }

    /**
     *             1
     *           /   \
     *          2     3
     *        /  \    /\
     *       4    5  6  7
     *      / \  /
     *     8  9 10
     */
    public static void makeSampleTree2(BinaryTree tree) {
        int inorder[] = { 8, 4, 9, 2, 10, 5, 1, 6, 3, 7 };
        int preorder[] = { 1, 2, 4, 8, 9, 5, 10, 3, 6, 7 };
        tree.buildTreeFromInorderPreorder(inorder, preorder);
    }

    public static boolean isCompleteTree(BinaryTree tree) {
        if (tree.root == null) {
            return true;
        }
        boolean flag = false;   // non-full node found
        Queue<TreeNode> q = new LinkedList<>();
        q.add(tree.root);

        while (!q.isEmpty()) {
            TreeNode temp = q.poll();

            if (temp.left != null) {
                if (flag == true) {
                    return false;
                }
                q.add(temp.left);
            } else {
                flag = true;
            }

            if (temp.right != null) {
                if (flag == true) {
                    return false;
                }
                q.add(temp.right);
            } else {
                flag = true;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        BinaryTree tree1 = new BinaryTree();    // not-complete binary tree
        BinaryTree tree2 = new BinaryTree();    // complete binary tree

        makeSampleTree1(tree1);
        makeSampleTree2(tree2);

        if (isCompleteTree(tree1)) {
            System.out.println("tree1 is a complete tree");
        } else {
            System.out.println("tree1 is not a complete tree");
        }

        if (isCompleteTree(tree2)) {
            System.out.println("tree2 is a complete tree");
        } else {
            System.out.println("tree2 is not a complete tree");
        }
    }
}
