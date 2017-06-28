package com.interview.sorting.algorithms;

public class InsertionSort {
    private int[] numbers;

    public void sort(int[] values) {
        // check for empty or null array
        if (values == null || values.length == 0) {
            return;
        }
        this.numbers = values;
        insertionSort(numbers);
    }

    private void insertionSort(int[] arr) {
        int pivotIndex = 1;
        int[] tempArr = new int[arr.length];
        while (pivotIndex < arr.length) {
            if (arr[pivotIndex - 1] > arr[pivotIndex]) {
                System.out.println("swapped: " + arr[pivotIndex - 1] + " <=> " + arr[pivotIndex]);
                int temp = arr[pivotIndex - 1];
                arr[pivotIndex - 1] = arr[pivotIndex];
                arr[pivotIndex] = temp;
            }
            System.out.print("pivotIndex: " + pivotIndex + "--> array ");
            printArray(arr);
            tempArr[pivotIndex - 1] = arr[pivotIndex - 1];

            pivotIndex++;
            sortBackwards(tempArr, pivotIndex - 1);
        }
    }

    private void sortBackwards(int[] tempArr, int index) {
        for (int i = index - 1; i > 0; i--) {
            if (tempArr[i] < tempArr[i - 1]) {
                int temp = tempArr[i];
                tempArr[i] = tempArr[i - 1];
                tempArr[i - 1] = temp;
            }
        }
        printArray(tempArr);

    }

    public static void main(String[] args) {
        int arr[] = { 38, 27, 43, 3, 9, 82, 10 };

        System.out.println("Given Array");
        printArray(arr);

        InsertionSort qs = new InsertionSort();
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
