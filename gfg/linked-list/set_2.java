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

  public void print() {
    Node tmp = this.head;
    while (tmp != null) {
      System.out.print(tmp.data + " ");
      tmp = tmp.next;
    }
    System.out.println();
  }
}

public class set_2 {
  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.push(1);
    list.push(2);
    list.push(3);
    list.print();
    list.append(4);
    list.append(5);
    list.insertAfter(list.head.next, 6);
    list.print();
  }
}
