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


public class InorderIterative {

    public static Node makeTree() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.right = new Node(6);
        return root;
    }

    public static void printInorderIterative(Node root) {
        Node curr = root;
        Stack<Node> stack = new Stack<>();
        while (curr != null || !stack.empty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            Node temp = stack.pop();
            System.out.print(temp.data + " ");
            curr = temp.right;
        }
        System.out.println();
    }

    public static void inorderMorrisTraversal(Node root) {
        if (root == null) {
            return;
        }
        Node curr = root;

        while (curr != null) {
            if (curr.left == null) {
                System.out.print(curr.data + " ");
                curr = curr.right;
            } else {
                // find inorder predecessor of curr
                Node pred = curr.left;
                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }
                if (pred.right == null) {
                    // make the right of pred as curr
                    pred.right = curr;
                    curr = curr.left;
                } else {
                    // revert changes
                    pred.right = null;
                    System.out.print(curr.data + " ");
                    curr = curr.right;
                }
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Node root = makeTree();
        printInorderIterative(root);
        inorderMorrisTraversal(root);
    }
}
