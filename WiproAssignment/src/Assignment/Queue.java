package Assignment;

import java.util.NoSuchElementException;

public class Queue<T> {
    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> front; // Front of the queue (for dequeue)
    private Node<T> rear;  // Rear of the queue (for enqueue)
    private int size;      // Size of the queue

    // Constructor to initialize an empty queue
    public Queue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    // Method to add/enqueue an element to the rear of the queue
    public void enqueue(T element) {
        Node<T> newNode = new Node<>(element);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode; // Update rear to be the new node
        size++;         // Increase size of the queue
    }

    // Method to remove/dequeue the element at the front of the queue and return it
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot dequeue from an empty queue.");
        }
        T data = front.data;  // Retrieve data from the front node
        front = front.next;   // Move front to the next node
        if (front == null) {
            rear = null; // If front becomes null, set rear to null as well
        }
        size--;               // Decrease size of the queue
        return data;          // Return the dequeued element
    }

    // Method to peek/get the element at the front of the queue without removing it
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot peek into an empty queue.");
        }
        return front.data; // Return data of the front node
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return size == 0; // Queue is empty if size is 0
    }

    // Method to get the number of elements in the queue
    public int size() {
        return size; // Return the size of the queue
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();

        // Testing queue operations
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Front element: " + queue.peek()); // Should print 10
        System.out.println("Queue size: " + queue.size());    // Should print 3

        while (!queue.isEmpty()) {
            System.out.println("Dequeued element: " + queue.dequeue());
        }

        // Trying to dequeue from an empty queue (will throw NoSuchElementException)
        // System.out.println("Dequeued element: " + queue.dequeue());
    }
}

