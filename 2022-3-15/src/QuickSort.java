import java.util.Arrays;

public class QuickSort {
    public static void quickSort(long[] array) {
        quickSortRange(array, 0, array.length - 1);
    }

    private static void quickSortRange(long[] array, int from, int to) {
        if (from >= to) {
            return;
        }
        int pivotIndex = partitionB(array, from, to);
        quickSortRange(array, from, pivotIndex - 1);
        quickSortRange(array, pivotIndex + 1, to);
    }

    private static int partition(long[] array, int from, int to) {
        long pivot = array[to];
        int left = from;
        int right = to;
        while (left < right) {
            while (left < right && array[left] <= pivot) {
                left++;
            }
            while (left < right && array[right] >= pivot) {
                right--;
            }
            swap(array, left, right);
        }
        swap(array, left, to);
        return left;
    }

    private static int partitionB(long[] array, int from, int to) {
        long pivot = array[to];
        int left = from;
        int right = to;
        while (left < right) {
            while (left < right && array[left] <= pivot) {
                left++;
            }
            array[right] = array[left];
            while (left < right && array[right] >= pivot) {
                right--;
            }
            array[left] = array[right];
        }
        array[left] = pivot;
        return left;
    }

    private static void swap(long[] array, int left, int right) {
        long tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

    public static void main(String[] args) {
        long[] array = {9,8,7,6,11,4,3,2,1,0};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
