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

void printList(node *head) {
  while (head != NULL) {
    printf("%d ", head->data);
    head = head->next;
  }
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

  printf("\n Created Linked list is: ");
  printList(head);

  return 0;
}
