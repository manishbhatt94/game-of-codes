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

public class MakeDoubleTree {

    /**
     *               1
     *             /   \
     *            2     3
     *          /  \
     *         4    5
    */
    public static Node makeSampleTree() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
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

    public static void doubleTree(Node node) {
        if (node == null) {
            return;
        }
        doubleTree(node.left);
        doubleTree(node.right);
        Node duplicate = new Node(node.data);
        duplicate.left = node.left;
        node.left = duplicate;
    }

    public static void main(String[] args) {
        Node root = makeSampleTree();
        printInorder(root);
        System.out.println();
        doubleTree(root);
        printInorder(root);
        System.out.println();
    }
}
