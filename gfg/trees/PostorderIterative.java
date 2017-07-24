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


public class PostorderIterative {

    /**
     *                1
     *             /     \
     *            2       3
     *          /   \    /
     *         4     5  7
     *          \
     *           6
    */
    public static Node makeSampleTree1() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.right = new Node(6);
        root.right.left = new Node(7);
        return root;
    }

    /**
     *                       1
     *                    /     \
     *                   2       3
     *                 /   \      \
     *                4     5      7
     *                     /        \
     *                    6          8
     */
    public static Node makeSampleTree2() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.right = new Node(8);
        return root;
    }

    public static void printPostorderIterative(Node root) {
        Node curr = root;
        Stack<Node> stack = new Stack<>();

        while (curr != null || !stack.empty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            if (stack.peek().right == null) {
                Node popped;
                do {
                    popped = stack.pop();
                    System.out.print(popped.data + " ");
                } while (!stack.empty() && popped == stack.peek().right);
            }
            if (!stack.empty()) {
                curr = stack.peek().right;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node root = makeSampleTree2();
        printPostorderIterative(root);
    }
}
