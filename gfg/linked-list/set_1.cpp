#include <cstdio>
#include <cstdlib>

struct Node {
  int data;
  struct Node *next;
};

void printList(struct Node *head) {

  while (head) {
    printf("%d ", head->data);
    head = head->next;
  }
  printf("\n");
}

int main() {

  struct Node *head = (struct Node *) malloc(sizeof(struct Node));
  struct Node *second = (struct Node *) malloc(sizeof(struct Node));
  struct Node *third = (struct Node *) malloc(sizeof(struct Node));

  head->data = 1;
  head->next = second;
  second->data = 2;
  second->next = third;
  third->data = 3;
  third->next = nullptr;

  printList(head);

  return 0;
}
