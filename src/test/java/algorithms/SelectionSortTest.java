package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SelectionSortTest {

    @Test
    public void testEmptyArray() {
        int[] arr = {};
        SelectionSort sorter = new SelectionSort(new PerformanceTracker());
        sorter.sort(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    public void testSingleElement() {
        int[] arr = {5};
        SelectionSort sorter = new SelectionSort(new PerformanceTracker());
        sorter.sort(arr);
        assertArrayEquals(new int[]{5}, arr);
    }

    @Test
    public void testSortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        SelectionSort sorter = new SelectionSort(new PerformanceTracker());
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testUnsortedArray() {
        int[] arr = {5, 3, 1, 4, 2};
        SelectionSort sorter = new SelectionSort(new PerformanceTracker());
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testArrayWithDuplicates() {
        int[] arr = {3, 1, 2, 1, 3};
        SelectionSort sorter = new SelectionSort(new PerformanceTracker());
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 1, 2, 3, 3}, arr);
    }
}
