package Assignment;

import java.util.Arrays;

public class DynamicArray<T> {
    private Object[] array;
    private int size;
    private int capacity;

    // Constructor to initialize the dynamic array with a default capacity
    public DynamicArray() {
        this.capacity = 10; // initial capacity
        this.array = new Object[capacity];
        this.size = 0;
    }

    // Method to get the current size of the dynamic array
    public int size() {
        return size;
    }

    // Method to check if the dynamic array is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to get an element at a specified index
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
        }
        @SuppressWarnings("unchecked")
        T element = (T) array[index];
        return element;
    }

    // Method to set an element at a specified index
    public void set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
        }
        array[index] = element;
    }

    // Method to add an element at the end of the dynamic array
    public void add(T element) {
        if (size == capacity) {
            resizeArray(); // resize array if capacity is reached
        }
        array[size] = element;
        size++;
    }

    // Method to insert an element at a specific index
    public void insert(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
        }
        if (size == capacity) {
            resizeArray(); // resize array if capacity is reached
        }
        // Shift elements to the right to make space for the new element
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;
    }

    // Method to remove an element at a specific index
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
        }
        // Shift elements to the left to fill the gap
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
    }

    // Helper method to resize the underlying array
    private void resizeArray() {
        int newCapacity = capacity * 2;
        array = Arrays.copyOf(array, newCapacity);
        capacity = newCapacity;
    }

    // Method to print all elements in the dynamic array
    public void print() {
        System.out.print("DynamicArray: ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DynamicArray<Integer> dynArray = new DynamicArray<>();

        // Adding elements
        dynArray.add(10);
        dynArray.add(20);
        dynArray.add(30);
        dynArray.print(); // Output: DynamicArray: 10 20 30

        // Inserting element at index 1
        dynArray.insert(1, 15);
        dynArray.print(); // Output: DynamicArray: 10 15 20 30

        // Updating element at index 2
        dynArray.set(2, 25);
        dynArray.print(); // Output: DynamicArray: 10 15 25 30

        // Deleting element at index 1
        dynArray.remove(1);
        dynArray.print(); // Output: DynamicArray: 10 25 30

        // Retrieving element at index 2
        int element = dynArray.get(2);
        System.out.println("Element at index 2: " + element); // Output: Element at index 2: 30
    }
}

