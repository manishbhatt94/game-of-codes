class Node {
  int data;
  Node next;

  public Node(int data) {
    this.data = data;
    this.next = null;
  }
}

class LinkedList {
  Node head;

  public LinkedList() {
    this.head = null;
  }

  public void push(int newData) {
    Node newNode = new Node(newData);
    newNode.next = this.head;
    this.head = newNode;
  }

  public void insertAfter(Node prevNode, int newData) {
    if (prevNode == null) {
      System.out.println("Error: prevNode cannot be null");
      return;
    }
    Node newNode = new Node(newData);
    newNode.next = prevNode.next;
    prevNode.next = newNode;
  }

  public void append(int newData) {
    Node newNode = new Node(newData);
    Node last = this.head;
    if (last == null) {
      this.head = newNode;
      return;
    }
    while (last.next != null) {
      last = last.next;
    }
    last.next = newNode;
  }

  public void deleteNode(int key) {
    Node tmp = this.head, prev = null;
    if (tmp != null && tmp.data == key) {
      this.head = tmp.next;
      return;
    }
    while (tmp != null && tmp.data != key) {
      prev = tmp;
      tmp = tmp.next;
    }
    if (tmp == null) {
      // key not found in list (or the list was empty)
      return;
    }
    prev.next = tmp.next;
  }

  public void print() {
    Node tmp = this.head;
    while (tmp != null) {
      System.out.print(tmp.data + " ");
      tmp = tmp.next;
    }
    System.out.println();
  }
}

public class set_3 {
  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.push(1); // 1->null
    list.push(2); // 2->1->null
    list.push(3); // 3->2->1->null
    list.print(); // 3->2->1->null
    list.append(4); // 3->2->1->4->null
    list.append(5); // 3->2->1->4->5->null
    list.insertAfter(list.head.next, 6); // 3->2->6->1->4->5->null
    list.print(); // 3->2->6->1->4->5->null
    list.deleteNode(4);
    list.print(); // 3->2->6->1->5->null
    list.deleteNode(3);
    list.print(); // 2->6->1->5->null
  }
}
