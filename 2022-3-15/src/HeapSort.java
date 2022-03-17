

public class HeapSort {
    // 先将数据建堆
    // 每次将堆顶元素和最后一个元素交换位置
    // 然后调整堆
    public static void heapSort(long[] array) {
        createBigHeap(array);
        for (int i = 0; i < array.length - 1; i++) {
            swap(array, 0, array.length - i - 1);
            shiftDown(array, array.length - i, 0);
        }
    }

    private static void createBigHeap(long[] array) {
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            shiftDown(array, array.length, i);
        }
    }

    private static void shiftDown(long[] array, int size, int index) {
        while (index * 2 + 1 < size) {
            int maxIndex = index * 2 + 1;
            int right = maxIndex + 1;
            if (right < size && array[right] > array[maxIndex]) {
                maxIndex = right;
            }
            if (array[maxIndex] < array[index]) {
                return;
            }
            swap(array, index, maxIndex);
            index = maxIndex;
        }
    }

    private static void swap(long[] array, int i, int i1) {
        long tmp = array[i];
        array[i] = array[i1];
        array[i1] = tmp;
    }

    public static void main(String[] args) {
        long[] array = {9,8,7,6,5,4,3,2,1,0};
        heapSort(array);
    }
}
