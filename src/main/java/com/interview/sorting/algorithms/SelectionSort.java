package com.interview.sorting.algorithms;

public class SelectionSort {
    private int[] numbers;

    public void sort(int[] values) {
        // check for empty or null array
        if (values == null || values.length == 0) {
            return;
        }
        this.numbers = values;
        selectionSort(numbers);
    }

    private void selectionSort(int[] arr) {
        int pivotIndex = 0;
        while (pivotIndex < arr.length - 1) {
            int minRestIndex = findMin(arr, pivotIndex);
            if (arr[pivotIndex] > arr[minRestIndex]) {
                int temp = arr[pivotIndex];
                arr[pivotIndex] = arr[minRestIndex];
                arr[minRestIndex] = temp;
            }
            printArray(arr);
            pivotIndex++;
        }
    }

    private int findMin(int[] arr, int pivotIndex) {
        Integer min = Integer.MAX_VALUE;
        int minIndex = 0;
        int i = pivotIndex + 1;
        for (; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
                minIndex = i;
            }
        }
        System.out.println("minIndex: " + minIndex + " value: " + arr[minIndex]);
        return minIndex;
    }

    public static void main(String[] args) {
        int arr[] = { 38, 27, 43, 3, 9, 82, 10 };

        System.out.println("Given Array");
        printArray(arr);

        SelectionSort qs = new SelectionSort();
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
