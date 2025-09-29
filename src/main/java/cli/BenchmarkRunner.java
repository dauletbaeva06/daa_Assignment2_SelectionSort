package cli;

import algorithms.SelectionSort;
import metrics.PerformanceTracker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class BenchmarkRunner {

    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000};
        String csvFile = "docs/performance-results.csv";

        try (FileWriter writer = new FileWriter(csvFile)) {
            writer.write("InputSize,Comparisons,Swaps,ExecutionTime(ns)\n");

            for (int size : sizes) {
                int[] arr = generateRandomArray(size);
                PerformanceTracker tracker = new PerformanceTracker();
                SelectionSort sorter = new SelectionSort(tracker);

                tracker.startTimer();
                sorter.sort(arr);
                tracker.stopTimer();

                writer.write(size + "," +
                        tracker.getComparisons() + "," +
                        tracker.getSwaps() + "," +
                        tracker.getExecutionTime() + "\n");
            }

            System.out.println("Benchmark completed. Results saved to " + csvFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int[] generateRandomArray(int n) {
        Random rand = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(10000);
        }
        return arr;
    }
}
