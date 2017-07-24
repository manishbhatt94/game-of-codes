#include <bits/stdc++.h>
using namespace std;

struct Node {
    int data;
    Node *left;
    Node *right;
};

Node *getNewNode(int data) {
    Node *newNode = (Node *) malloc(sizeof(Node));
    newNode->left = newNode->right = NULL;
    newNode->data = data;
    return newNode;
}

/**
 *                1
 *             /    \
 *            2      3
 *          /  \    / \
 *         4    5  6   7
*/
Node *makeSampleTree() {
    Node *root = getNewNode(1);
    root->left = getNewNode(2);
    root->right = getNewNode(3);
    root->left->left = getNewNode(4);
    root->left->right = getNewNode(5);
    root->right->left = getNewNode(6);
    root->right->right = getNewNode(7);
    return root;
}

void printVerticalSumsUtil(Node *root, int horizontalDist, map<int, int>& vsums) {
    if (root == NULL) {
        return;
    }

    if (vsums.count(horizontalDist) > 0) {
        // if key horizontalDist exists in map
        vsums[horizontalDist] += root->data;
    } else {
        vsums[horizontalDist] = root->data;
    }

    printVerticalSumsUtil(root->left, horizontalDist - 1, vsums);
    printVerticalSumsUtil(root->right, horizontalDist + 1, vsums);
}

void printVerticalSums(Node *root) {
    if (root == NULL) {
        return;
    }
    map<int, int> vertSums; // horizontal distance to vertical sum map
    printVerticalSumsUtil(root, 0, vertSums);
    for (auto elem: vertSums) {
        cout << elem.second << " ";
    }
    cout << endl;
}

int main() {
    Node *root = makeSampleTree();
    printVerticalSums(root);
    return 0;
}
