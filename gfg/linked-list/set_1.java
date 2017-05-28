class Node {
  int data;
  Node next;

  Node(int data) {
    this.data = data;
    this.next = null;
  }
}


class LinkedList {
  Node head;

  LinkedList() {
    this.head = null;
  }

  void printList() {
    Node temp = this.head;
    while (temp != null) {
      System.out.println("" + temp.data + " ");
      temp = temp.next;
    }
    System.out.println();
  }
}


public class set_1 {

  public static void main(String args[]) {

    LinkedList list = new LinkedList();
    Node head = new Node(1);
    Node second = new Node(2);
    Node third = new Node(3);
    head.next = second;
    second.next = third;

    list.head = head;

    list.printList();
  }
}
