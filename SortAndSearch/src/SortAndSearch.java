import java.util.Arrays;
import java.util.Random;

public class SortAndSearch {

    // Generate random numbers
    public static int[] generateRandomNumbers(int size) {
        Random rand = new Random();
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = rand.nextInt(1000) + 1;
        }
        return numbers;
    }

    // Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    // Selection Sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Linear Search
    public static int linearSearch(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search
    public static int binarySearch(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                return mid;
            }
            if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] sizes = {100, 500, 1000, 10000};
        for (int size : sizes) {
            System.out.println("Size: " + size);

            // Generate random numbers
            int[] numbers = generateRandomNumbers(size);

            // Sort using Bubble Sort
            int[] bubbleSortNumbers = Arrays.copyOf(numbers, numbers.length);
            long bubbleStartTime = System.nanoTime();
            bubbleSort(bubbleSortNumbers);
            long bubbleEndTime = System.nanoTime();
            long bubbleDuration = bubbleEndTime - bubbleStartTime;
            System.out.println("Bubble Sort took " + bubbleDuration + " nano seconds");

            // Sort using Selection Sort
            int[] selectionSortNumbers = Arrays.copyOf(numbers, numbers.length);
            long selectionStartTime = System.nanoTime();
            selectionSort(selectionSortNumbers);
            long selectionEndTime = System.nanoTime();
            long selectionDuration = selectionEndTime - selectionStartTime;
            System.out.println("Selection Sort took " + selectionDuration + " nano seconds");

            // Search for number 500
            long linearStartTime = System.nanoTime();
            int linearResult = linearSearch(numbers, 500);
            long linearEndTime = System.nanoTime();
            long linearDuration = linearEndTime - linearStartTime;
            System.out.println("Linear Search took " + linearDuration + " nano seconds and found at index " + linearResult);

            // Binary Search
            Arrays.sort(numbers);
            long binaryStartTime = System.nanoTime();
            int binaryResult = binarySearch(numbers, 500);
            long binaryEndTime = System.nanoTime();
            long binaryDuration = binaryEndTime - binaryStartTime;
            System.out.println("Binary Search took " + binaryDuration + " nano seconds and found at index " + binaryResult);

            System.out.println();
        }
    }
}
