package com.interview.sorting.algorithms;

public class BubbleSort {
    private int[] numbers;

    public void sort(int[] values) {
        // check for empty or null array
        if (values == null || values.length == 0) {
            return;
        }
        this.numbers = values;
        bubbleSort(numbers);
    }

    private void bubbleSort(int[] arr) {
        boolean swapped = true;
        do {
            swapped = false;
            int pivotIndex = 0;
            while (pivotIndex < arr.length - 1) {
                if (arr[pivotIndex] > arr[pivotIndex + 1]) {
                    System.out.println("swapped: " + arr[pivotIndex] + " <=> " + arr[pivotIndex + 1]);
                    int temp = arr[pivotIndex];
                    arr[pivotIndex] = arr[pivotIndex + 1];
                    arr[pivotIndex + 1] = temp;
                    swapped = true;
                }
                System.out.print("pivotIndex: " + pivotIndex + "--> array ");
                printArray(arr);
                pivotIndex++;
            }
        } while (swapped);
    }

    public static void main(String[] args) {
        int arr[] = { 38, 27, 43, 3, 9, 82, 10 };

        System.out.println("Given Array");
        printArray(arr);

        BubbleSort qs = new BubbleSort();
        qs.sort(arr);
        System.out.println("Sorted Array");
        printArray(arr);
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
