package Assignment;

import java.util.EmptyStackException;

public class Stack<T> {
    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> top;
    private int size;

    // Constructor to initialize an empty stack
    public Stack() {
        this.top = null;
        this.size = 0;
    }

    // Method to push/add an element to the top of the stack
    public void push(T element) {
        Node<T> newNode = new Node<>(element);
        newNode.next = top; // Point new node's next to current top
        top = newNode;      // Update top to be the new node
        size++;             // Increase size of the stack
    }

    // Method to pop/remove the top element of the stack and return it
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T data = top.data;  // Retrieve data from the top node
        top = top.next;     // Move top to the next node
        size--;             // Decrease size of the stack
        return data;        // Return the popped element
    }

    // Method to peek/get the top element of the stack without removing it
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data; // Return data of the top node
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == null; // Stack is empty if top is null
    }

    // Method to get the number of elements in the stack
    public int size() {
        return size; // Return the size of the stack
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Testing stack operations
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.peek()); // Should print 30
        System.out.println("Stack size: " + stack.size()); // Should print 3

        while (!stack.isEmpty()) {
            System.out.println("Popped element: " + stack.pop());
        }

        // Trying to pop from an empty stack (will throw EmptyStackException)
        // System.out.println("Popped element: " + stack.pop());
    }
}
