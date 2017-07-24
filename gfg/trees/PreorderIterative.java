import java.util.Stack;

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


public class PreorderIterative {

    /**
     *                1
     *             /     \
     *            2       3
     *          /   \    /
     *         4     5  7
     *          \
     *           6
    */
    public static Node makeTree() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.right = new Node(6);
        root.right.left = new Node(7);
        return root;
    }

    public static void printPreorderIterative(Node root) {
        Node curr = root;
        Stack<Node> stack = new Stack<>();
        while (curr != null || !stack.empty()) {
            while (curr != null) {
                System.out.print(curr.data + " ");
                stack.push(curr);
                curr = curr.left;
            }
            Node temp = stack.pop();
            curr = temp.right;
        }
        System.out.println();
    }

    public static void printInorder(Node root) {
        if (root == null) {
            return;
        }
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    public static void printReverseInorder(Node root) {
        if (root == null) {
            return;
        }
        printReverseInorder(root.right);
        System.out.print(root.data + " ");
        printReverseInorder(root.left);
    }

    public static void main(String[] args) {
        Node root = makeTree();
        printPreorderIterative(root);
        printInorder(root);
        System.out.println();
        printReverseInorder(root);
        System.out.println();
    }
}
