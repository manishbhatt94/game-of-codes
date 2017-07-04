#include <cstdlib>
#include <cstdio>

typedef struct node {
  int data;
  struct node *next;
} node;

// insert node at the beginning of the linked list
void push(node **headRef, int newData) {
  node *newNode = (node *) malloc(sizeof(node));
  newNode->data = newData;
  newNode->next = *headRef;
  *headRef = newNode;
}

// insert node after a given node
void insertAfter(node *prevNode, int newData) {
  if (prevNode == NULL) {
    printf("Error: prevNode cannot be NULL!");
    return;
  }
  node *newNode = (node *) malloc(sizeof(node));
  newNode->data = newData;
  newNode->next = prevNode->next;
  prevNode->next = newNode;
}

// insert node at the end of the linked list
void append(node **headRef, int newData) {
  node *newNode = (node *) malloc(sizeof(node));
  newNode->data = newData;
  newNode->next = NULL;
  node *last = *headRef;
  if (last == NULL) {
    *headRef = newNode;
    return;
  }
  while (last->next != NULL) {
    last = last->next;
  }
  last->next = newNode;
}

void swapNodes(node **headRef, int x, int y) {
  if (x == y) {
    return;
  }
  node *prevX = NULL, *currX = *headRef;
  while (currX && currX->data != x) {
    prevX = currX;
    currX = currX->next;
  }
  node *prevY = NULL, *currY = *headRef;
  while (currY && currY->data != x) {
    prevY = currY;
    currY = currY->next;
  }
  if (currX == NULL || currY == NULL) {
    return;
  }
  if (prevX != NULL) {
    prevX->next = currY;
  } else {
    *headRef = currY;
  }
  if (prevY != NULL) {
    prevY->next = currX;
  } else {
    *headRef = currX;
  }
  node *temp = currY;
  currY->next = currX->next;
  currX->next = temp;
}

void printList(node *head) {
  while (head != NULL) {
    printf("%d ", head->data);
    head = head->next;
  }
  printf("\n");
}

// delete the first occurrence of key in the linked list
void deleteNode(node **headRef, int key) {
  node *tmp = *headRef, *prev;
  if (tmp != NULL && tmp->data == key) {
    *headRef = tmp->next;
    free(tmp);
    return;
  }
  while (tmp != NULL && tmp->data != key) {
    prev = tmp;
    tmp = tmp->next;
  }
  if (tmp == NULL) {
    printf("Error in deleting: key was not found in the list.");
  }
  prev->next = tmp->next;
  free(tmp);
}

int main() {
  node *head = NULL;
  // Insert 6.  So linked list becomes 6->NULL
  append(&head, 6);

  // Insert 7 at the beginning. So linked list becomes 7->6->NULL
  push(&head, 7);

  // Insert 1 at the beginning. So linked list becomes 1->7->6->NULL
  push(&head, 1);

  // Insert 4 at the end. So linked list becomes 1->7->6->4->NULL
  append(&head, 4);

  // Insert 8, after 7. So linked list becomes 1->7->8->6->4->NULL
  insertAfter(head->next, 8);

  printf("Created Linked list is: ");
  printList(head);

  deleteNode(&head, 8);
  printList(head);

  deleteNode(&head, 1);
  printList(head);

  return 0;
}
