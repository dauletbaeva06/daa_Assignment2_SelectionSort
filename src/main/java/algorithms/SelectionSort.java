package algorithms;

import metrics.PerformanceTracker;

public class SelectionSort {

    private final PerformanceTracker tracker;

    public SelectionSort(PerformanceTracker tracker) {
        this.tracker = tracker;
    }

    public void sort(int[] arr) {
        int n = arr.length;
        boolean sorted;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            sorted = true;

            for (int j = i + 1; j < n; j++) {
                tracker.incrementComparisons();
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                    sorted = false;
                }
            }

            if (minIndex != i) {
                swap(arr, i, minIndex);
                tracker.incrementSwaps();
            }

            if (sorted) break;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
