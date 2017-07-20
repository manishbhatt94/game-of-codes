class Node {
  int data;
  Node next;

  public Node() {
    this.next = null;
  }

  public Node(int data) {
    this.data = data;
    this.next = null;
  }
}

class LinkedList {
  Node head;
  private Node tail;

  public LinkedList() {
    this.head = null;
    this.tail = null;
  }

  public void pushBack(int data) {
    Node newNode = new Node(data);
    if (this.head == null) {
      this.head = newNode;
      this.tail = newNode;
      return;
    }
    this.tail.next = newNode;
    this.tail = newNode;
  }

  public void printList() {
    Node temp = this.head;
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    System.out.println();
  }
}

public class MergeSortedLL {

  public static Node mergeLL(Node h1, Node h2) {
    Node dummy = new Node();
    Node tail = dummy, temp = null;
    while (true) {
      if (h1 == null) {
        tail.next = h2;
        break;
      } else if (h2 == null) {
        tail.next = h1;
        break;
      }
      if (h1.data <= h2.data) {
        // moveNode(tail.next, h1);
        temp = h1;
        h1 = h1.next;
        temp.next = tail.next;
        tail.next = temp;
      } else {
        // moveNode(tail.next, h2);
        temp = h2;
        h2 = h2.next;
        temp.next = tail.next;
        tail.next = temp;
      }
      tail = tail.next;
    }
    return dummy.next;
  }

  public static void main(String[] args) {
    LinkedList l1 = new LinkedList();
    LinkedList l2 = new LinkedList();
    LinkedList resultant = new LinkedList();
    int firstListData[] = { 5, 10, 15, 40 };
    int secondListData[] = { 2, 3, 20 };
    for (int data: firstListData) {
      l1.pushBack(data);
    }
    for (int data: secondListData) {
      l2.pushBack(data);
    }
    // calling mergeLL
    resultant.head = mergeLL(l1.head, l2.head);
    resultant.printList();
  }
}
