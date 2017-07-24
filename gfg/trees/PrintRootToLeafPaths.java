import java.util.ArrayList;

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

public class PrintRootToLeafPaths {

    /**
     *                1
     *             /     \
     *            2       3
     *          /   \    /
     *         4     5  7
     *          \
     *           6
    */
    public static Node makeSampleTree() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.right = new Node(6);
        root.right.left = new Node(7);
        return root;
    }

    public static void printArrayList(ArrayList<Integer> arr) {
        for (int item: arr) {
            System.out.print(item + " ");
        }
    }

    public static void printPaths(Node root, ArrayList<Integer> pathArr) {
        if (root == null) {
            return;
        }
        pathArr.add(root.data);
        if (root.left == null && root.right == null) {
            printArrayList(pathArr);
            System.out.println();
        }
        printPaths(root.left, pathArr);
        printPaths(root.right, pathArr);
        // delete last element from ArrayList
        pathArr.remove( pathArr.size() - 1 );
    }

    public static void printArrayUptoIndex(int[] arr, int lastIndex) {
        for (int i = 0; i <= lastIndex; ++i) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void printPathsUsingArray(Node root, int[] pathArr, int index) {
        if (root == null) {
            return;
        }
        pathArr[index] = root.data;
        if (root.left == null && root.right == null) {
            printArrayUptoIndex(pathArr, index);
            System.out.println();
        }
        printPathsUsingArray(root.left, pathArr, index + 1);
        printPathsUsingArray(root.right, pathArr, index + 1);
    }

    public static void main(String[] args) {
        Node root = makeSampleTree();

        ArrayList<Integer> arrList = new ArrayList<>();
        printPaths(root, arrList);

        int[] arr = new int[10000];
        printPathsUsingArray(root, arr, 0);
    }
}
