package Assignment;


public class MergeSort {
    
    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};
        
        System.out.println("Original Array:");
        printArray(array);
        
        mergeSort(array, 0, array.length - 1);
        
        System.out.println("\nSorted Array:");
        printArray(array);
    }
    
    // Merge sort function
    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;
            
            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
    
    // Merge two subarrays of arr[]
    public static void merge(int[] arr, int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
        
        // Create temporary arrays
        int[] L = new int[n1];
        int[] R = new int[n2];
        
        // Copy data to temporary arrays L[] and R[]
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
        
        // Merge the temporary arrays
        
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
        
        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        
        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        
        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    
    // Function to print an array
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}

