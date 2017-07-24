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


class NodeWrapper {
    Node node;

    public NodeWrapper() {
        this.node = null;
    }
}


class MutableIntWrapper {
    int value;

    public MutableIntWrapper() {
        this.value = 0;
    }
}


public class MaxSumLeafRootPath {

    /**
     *               10
     *              /  \
     *            -2    7
     *           /  \
     *          8   -4
    */
    public static Node makeSampleTree() {
        Node root = new Node(10);
        root.left = new Node(-2);
        root.right = new Node(7);
        root.left.left = new Node(8);
        root.left.right = new Node(-4);
        return root;
    }

    public static void getTargetLeaf(Node root, int prevSum, MutableIntWrapper maxSumRef,
        NodeWrapper maxSumLeafRef) {

        if (root == null) {
            return;
        }

        int currSum = prevSum + root.data;

        if (root.left == null && root.right == null) {
            if (currSum > maxSumRef.value) {
                maxSumRef.value = currSum;
                maxSumLeafRef.node = root;
            }
        }

        getTargetLeaf(root.left, currSum, maxSumRef, maxSumLeafRef);
        getTargetLeaf(root.right, currSum, maxSumRef, maxSumLeafRef);
    }

    public static boolean printPath(Node root, Node leaf) {
        if (root == null) {
            return false;
        }

        if (root == leaf || printPath(root.left, leaf) ||
            printPath(root.right, leaf)) {

            System.out.print(root.data + " ");
            return true;
        }

        return false;
    }

    public static int getMaxSum(Node root) {
        if (root == null) {
            return 0;
        }

        NodeWrapper maxSumLeafRef = new NodeWrapper();
        MutableIntWrapper maxSumRef = new MutableIntWrapper();
        maxSumRef.value = Integer.MIN_VALUE;

        getTargetLeaf(root, 0, maxSumRef, maxSumLeafRef);

        printPath(root, maxSumLeafRef.node);

        return maxSumRef.value;
    }

    public static void main(String[] args) {
        Node root = makeSampleTree();
        int maxSum = getMaxSum(root);
        System.out.println();
        System.out.println("Max path sum = " + maxSum);
    }
}
