import java.util.Arrays;

public class SelectSort {
    public static void selectSort(long[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = getMinIndex(array, i);
            swap(array, minIndex, i);
        }
    }

    private static int getMinIndex(long[] array, int fromIndex) {
        int minIndex = fromIndex;
        for (int i = fromIndex + 1; i < array.length; i++) {
            if (array[minIndex] > array[i]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    private static void swap(long[] array, int minIndex, int i) {
        long tmp = array[minIndex];
        array[minIndex] = array[i];
        array[i] = tmp;
    }

    public static void selectSort2(long[] array) {
        for (int i = 0; i < array.length; i++) {
            int maxIndex = getMaxIndex(array, array.length - i);
            swap(array, maxIndex, array.length - i - 1);
        }
    }

    private static int getMaxIndex(long[] array, int toIndex) {
        int maxIndex = 0;
        for (int i = 1; i < toIndex; i++) {
            if (array[maxIndex] < array[i]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void selectSort4(long[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            swap(array, minIndex, i);
        }
    }

    public static void selectSort3(long[] array) {
        for (int i = 0; i < array.length; i++) {
            int maxIndex = 0;
            for (int j = 1; j < array.length - i; j++) {
                if (array[maxIndex] < array[j]) {
                    maxIndex = j;
                }
            }
            swap(array, maxIndex, array.length - i - 1);
        }
    }

    public static void main(String[] args) {
        long[] array = {10,9,8,7,6,5,4,3,2,1,0};
        selectSort4(array);
        System.out.println(Arrays.toString(array));
    }
}
