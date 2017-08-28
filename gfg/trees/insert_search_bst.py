class TreeNode:
    def __init__(self, key):
        self.val = key
        self.left = self.right = None


def insert(root, data):
    """Inserts a new node with `data` as the key in the BST."""
    if root is None:
        return TreeNode(data)
    if data < root.val:
        root.left = insert(root.left, data)
    elif data > root.val:
        root.right = insert(root.right, data)
    return root


def search(root, data):
    """Searches for a node with `data` as key in the BST.

    Returns the node if found, None otherwise.
    """
    if root is None or root.val == data:
        return root
    if data < root.val:
        return search(root.left, data)
    return search(root.right, data)


def inorder(root):
    """Prints inorder traversal of binary tree (recursively)."""
    if root is None:
        return
    inorder(root.left)
    print(root.val, end=" ")
    inorder(root.right)


def main():
    keys = [100, 20, 500, 30, 25, 10]
    root = None
    for key in keys:
        root = insert(root, key)
    inorder(root)
    print()
    t = int(input("Enter number of searches: "))
    for i in range(t):
        key = int(input("Enter key to be searched: "))
        if search(root, key):
            print(key, "found")
        else:
            print(key, "not found")


if __name__ == "__main__":
    main()
