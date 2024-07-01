package Assignment;

public class LinkedList<T> {

    private Node<T> head;
    private int size;

    // Node class to represent elements in the linked list
    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // Constructor to initialize an empty linked list
    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    // Method to add an element at the beginning of the linked list
    public void addFirst(T element) {
        Node<T> newNode = new Node<>(element);
        newNode.next = head;
        head = newNode;
        size++;
    }

    // Method to add an element at the end of the linked list
    public void addLast(T element) {
        Node<T> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    // Method to add an element at a specific position in the linked list
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
        }
        if (index == 0) {
            addFirst(element);
        } else if (index == size) {
            addLast(element);
        } else {
            Node<T> newNode = new Node<>(element);
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }
    }

    // Method to remove the first element from the linked list
    public T removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot remove from an empty list.");
        }
        T removedData = head.data;
        head = head.next;
        size--;
        return removedData;
    }

    // Method to remove the last element from the linked list
    public T removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot remove from an empty list.");
        }
        if (size == 1) {
            return removeFirst();
        } else {
            Node<T> current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            T removedData = current.next.data;
            current.next = null;
            size--;
            return removedData;
        }
    }

    // Method to remove an element at a specific position from the linked list
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
        }
        if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            T removedData = current.next.data;
            current.next = current.next.next;
            size--;
            return removedData;
        }
    }

    // Method to get the element at a specific position in the linked list
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    // Method to display all elements in the linked list
    public void display() {
        Node<T> current = head;
        System.out.print("LinkedList: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Method to check if the linked list is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to get the size of the linked list
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        // Adding elements to the list
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.display(); // Output: LinkedList: 10 20 30

        // Removing an element from the list
        list.remove(1);
        list.display(); // Output: LinkedList: 10 30

        // Adding an element at a specific position
        list.add(1, 15);
        list.display(); // Output: LinkedList: 10 15 30

        // Getting an element from the list
        int element = list.get(2);
        System.out.println("Element at index 2: " + element); // Output: Element at index 2: 30
    }
}


