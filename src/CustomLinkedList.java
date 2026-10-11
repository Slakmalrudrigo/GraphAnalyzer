package src;

public class CustomLinkedList {

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public CustomLinkedList() {
        this.head = null;
        this.size = 0;
    }


    public void insert(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        System.out.println("Inserted " + value + " into Linked List.");
    }

    public boolean delete(int value) {
        if (head == null) {
            System.out.println("Linked List is empty! Cannot delete.");
            return false;
        }

        if (head.data == value) {
            head = head.next;
            size--;
            System.out.println("Deleted " + value + " from Linked List.");
            return true;
        }

        Node current = head;
        while (current.next != null && current.next.data != value) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            size--;
            System.out.println("Deleted " + value + " from Linked List.");
            return true;
        }

        System.out.println("Value " + value + " not found in Linked List.");
        return false;
    }


    public int search(int value) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.data == value) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }


    public void display() {
        if (head == null) {
            System.out.println("Linked List is empty: null");
            return;
        }
        System.out.print("Linked List: ");
        Node current = head;
        while (current != null) {
            System.out.print("[" + current.data + "] -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public int getSize() {
        return size;
    }
}
