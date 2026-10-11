package src;

import java.util.Arrays;

public class CustomArray {
    private int[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 20;

    public CustomArray() {
        this.array = new int[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public boolean insert(int value) {
        if (size >= array.length) {
            // Resize array dynamically
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[size++] = value;
        return true;
    }

    public boolean delete(int value) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return false; // Value not found
        }

        // Shift elements to the left
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return true;
    }

    public void display() {
        if (size == 0) {
            System.out.println("Array is empty: []");
            return;
        }
        System.out.print("Array elements [" + size + "]: [");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + (i < size - 1 ? ", " : ""));
        }
        System.out.println("]");
    }

    public PerformanceRecord linearSearch(int target) {
        long startTime = System.nanoTime();
        int steps = 0;
        int foundIndex = -1;

        for (int i = 0; i < size; i++) {
            steps++;
            if (array[i] == target) {
                foundIndex = i;
                break;
            }
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        String details = (foundIndex != -1) ? "Found at index " + foundIndex : "Not Found";

        return new PerformanceRecord("Search", "Linear Search", steps, duration, details);
    }

    public PerformanceRecord binarySearch(int target) {
        // Create a sorted copy for valid Binary Search demonstration
        int[] sortedCopy = Arrays.copyOf(array, size);
        Arrays.sort(sortedCopy);

        long startTime = System.nanoTime();
        int steps = 0;
        int low = 0;
        int high = size - 1;
        int foundIndex = -1;

        while (low <= high) {
            steps++;
            int mid = low + (high - low) / 2;
            if (sortedCopy[mid] == target) {
                foundIndex = mid;
                break;
            } else if (sortedCopy[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        String details = (foundIndex != -1) ? "Found in sorted array at pos " + foundIndex : "Not Found";

        return new PerformanceRecord("Search", "Binary Search", steps, duration, details);
    }

    public int getSize() {
        return size;
    }

    public int[] getElements() {
        return Arrays.copyOf(array, size);
    }
}
