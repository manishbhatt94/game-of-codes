#include <cstdio>
#include <cstdlib>

struct node {
  int data;
  struct node *left;
  struct node *right;
};

bool isLeaf(struct node *n) {
  if (n == NULL) {
    return false;
  }
  if (n->left == NULL && n->right == NULL) {
    return true;
  }
  return false;
}

int func(struct node *root) {
  if (root == NULL) {
    return 0;
  }
  int sum = 0;
  if ( isLeaf(root->left) ) {
    sum = sum + root->left->data;
  }
  sum = sum + func(root->left) + func(root->right);
  return sum;
}

struct node *getNode(int data) {
  struct node *n = (struct node *) malloc(sizeof(struct node));
  n->data = data;
  n->left = NULL;
  n->right = NULL;
  return n;
}

struct node *getSampleTree() {
  struct node *one = getNode(1);
  struct node *two = getNode(2);
  struct node *three = getNode(3);
  struct node *four = getNode(4);
  struct node *five = getNode(5);
  struct node *six = getNode(6);
  struct node *seven = getNode(7);
  struct node *eight = getNode(8);
  one->left = two;
  one->right = three;
  two->left = four;
  two->right = five;
  three->right = six;
  five->left = seven;
  six->left = eight;
  return one;
}

int main() {
  struct node *root = getSampleTree();
  int sum_of_left_leaves = func(root);
  printf("%d\n", sum_of_left_leaves);

  return 0;
}
