#include<bits/stdc++.h>
using namespace std;

struct Node
{
    int data;
    struct Node *next;
};

void reverseUtil(Node *curr, Node *prev, Node **head);

// This function mainly calls reverseUtil()
// with prev as NULL
void reverse(Node **headRef)
{
    reverseUtil(*headRef, NULL, headRef);
}

// A simple and tail recursive function to reverse
// a linked list.  prev is passed as NULL initially.
void reverseUtil(Node *curr, Node *prev, Node **headRef)
{
    if (curr == NULL)
    {
        *headRef = prev;
        return;
    }

    /* Save curr->next node for recursive call */
    Node *next = curr->next;

    /* and update next ..*/
    curr->next = prev;

    reverseUtil(next, curr, headRef);
}

// A utility function to create a new node
Node *newNode(int key)
{
    Node *temp = new Node;
    temp->data = key;
    temp->next = NULL;
    return temp;
}

// A utility function to print a linked list
void printlist(Node *head)
{
    while(head != NULL)
    {
        cout << head->data << " ";
        head = head->next;
    }
    cout << endl;
}

void recursiveReverse(Node** head_ref)
{
    Node* first;
    Node* rest;

    /* empty list */
    if (*head_ref == NULL)
       return;

    /* suppose first = {1, 2, 3}, rest = {2, 3} */
    first = *head_ref;
    rest  = first->next;

    /* List has only one node */
    if (rest == NULL)
       return;

    /* reverse the rest list and put the first element at the end */
    recursiveReverse(&rest);
    first->next->next  = first;

    /* tricky step -- see the diagram */
    first->next  = NULL;

    /* fix the head pointer */
    *head_ref = rest;
}

// Driver program to test above functions
int main()
{
    // Node *head1 = NULL;
    Node *head1 = newNode(1);
    head1->next = newNode(2);
    head1->next->next = newNode(3);
    head1->next->next->next = newNode(4);
    head1->next->next->next->next = newNode(5);
    head1->next->next->next->next->next = newNode(6);
    head1->next->next->next->next->next->next = newNode(7);
    head1->next->next->next->next->next->next->next = newNode(8);
    cout << "Given linked list\n";
    printlist(head1);
    reverse(&head1);
    // recursiveReverse(&head1);
    cout << "\nReversed linked list\n";
    printlist(head1);
    return 0;
}
