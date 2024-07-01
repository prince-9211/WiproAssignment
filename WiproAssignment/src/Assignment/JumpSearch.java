package Assignment;

public class JumpSearch {
    public static int jumpSearch(int[] arr, int target) {
        int length = arr.length;
        int step = (int) Math.sqrt(length); // Optimal jump size
        int prev = 0;

        // Jumping blocks until we find a block that may contain the target
        while (arr[Math.min(step, length) - 1] < target) {
            prev = step;
            step += (int) Math.sqrt(length);
            if (prev >= length) {
                return -1; // Target is not present in the array
            }
        }

        // Performing linear search within the identified block
        while (arr[prev] < target) {
            prev++;
            if (prev == Math.min(step, length)) {
                return -1; // Target is not present in the array
            }
        }

        // If the target is found
        if (arr[prev] == target) {
            return prev;
        }

        return -1; // Target is not present in the array
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int target = 16;

        int result = jumpSearch(array, target);
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found in the array.");
        }
    }
}
