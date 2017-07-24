package gfg.com.lib.tree;

public class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
        this.left = this.right = null;
    }

    public TreeNode(int data) {
        this();
        this.data = data;
    }

    public boolean isLeaf() {
        if (this == null) {
            return false;
        }
        if (this.left == null && this.right == null) {
            return true;
        }
        return false;
    }
}
