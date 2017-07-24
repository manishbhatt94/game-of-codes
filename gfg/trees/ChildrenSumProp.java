class Node {
    int data;
    Node left;
    Node right;

    public Node() {
        this.left = this.right = null;
    }

    public Node(int data) {
        this();
        this.data = data;
    }
}

public class ChildrenSumProp {

    /**
     *                10
     *             /      \
     *            8        2
     *          /   \     /
     *         3     5   2
    */
    public static Node makeSampleTree1() {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(2);
        return root;
    }

    /**
     *                 50
     *             /        \
     *            30         2
     *          /    \      /  \
     *         3      9    1    32
     *          \    /
     *           5  4
     *               \
     *                6
    */
    public static Node makeSampleTree2() {
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(9);
        root.right.left = new Node(1);
        root.right.right = new Node(32);
        root.left.left.right = new Node(5);
        root.left.right.left = new Node(4);
        root.left.right.left.right = new Node(6);
        return root;
    }

    public static void printInorder(Node root) {
        if (root == null) {
            return;
        }
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    public static boolean doesChildrenSumPropHold(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }

        int childSum = (root.left != null ? root.left.data : 0) +
            (root.right != null ? root.right.data : 0);

        return (
            childSum == root.data &&
            doesChildrenSumPropHold(root.left) &&
            doesChildrenSumPropHold(root.right)
        );
    }

    public static void increment(Node node, int diff) {
        if (node.left != null) {
            node.left.data += diff;
            increment(node.left, diff);
        } else if (node.right != null) {
            node.right.data += diff;
            increment(node.right, diff);
        }
    }

    /**
     * @param root
     * This function changes a tree to hold the children sum property
     * (Only incrementing data values of nodes is allowed. We cannot change
     * the structure of the tree and cannot decrement value of any node)
     */
    public static void convertTree(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }

        convertTree(root.left);
        convertTree(root.right);

        int childSum = (root.left != null ? root.left.data : 0) +
            (root.right != null ? root.right.data : 0);
        int diff = childSum - root.data;

        if (diff > 0) {
            root.data += diff;
        } else if (diff < 0) {
            increment(root, -diff);
        }
    }

    public static void main(String[] args) {
        Node root1 = makeSampleTree1();
        System.out.println(doesChildrenSumPropHold(root1));

        Node root2 = makeSampleTree2();
        printInorder(root2);
        System.out.println();
        convertTree(root2);
        printInorder(root2);
        System.out.println();
    }
}
