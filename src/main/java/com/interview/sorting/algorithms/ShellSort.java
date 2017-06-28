package com.interview.sorting.algorithms;

public class ShellSort {
    private int[] numbers;

    public void sort(int[] values) {
        // check for empty or null array
        if (values == null || values.length == 0) {
            return;
        }
        this.numbers = values;
        shellSort(numbers);
    }

    private void shellSort(int[] arr) {
        int n = arr.length;

        // Start with a big gap, then reduce the gap
        for (int gap = n / 2; gap > 0; gap /= 2) {
            System.out.println("gap: " + gap);
            for (int i = gap; i < n; i += 1) {
                int temp = arr[i];
                System.out.println("i: " + i + " arr[i]: " + temp);
                int j;
                for (j = i; j >= gap; j -= gap) {
                    System.out.println("j: " + j + " arr[j - gap]: " + arr[j - gap]);
                    if (arr[j - gap] <= temp) {
                        break;
                    }
                    arr[j] = arr[j - gap];
                }
                // put temp (the original a[i]) in its correct
                // location
                arr[j] = temp;
                printArray(arr);
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 38, 27, 43, 3, 9, 82, 10 };

        System.out.println("Given Array");
        printArray(arr);

        ShellSort qs = new ShellSort();
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
