import java.util.Arrays;

public class MyPriorityQueue {
    private long[] array;
    private int size;

    public MyPriorityQueue() {
        this.array = new long[16];
        this.size = 0;
    }

    public void offer(long e) {
        ensureCapacity();
        this.array[size] = e;
        this.size++;
        shiftUp(this.array, this.size - 1);
    }

    private void shiftUp(long[] array, int index) {
        while (index != 0) {
            int parent = (index - 1) / 2;
            if (this.array[index] >= this.array[parent]) {
                return;
            }
            swap(array, index, parent);
            index = parent;
        }
    }

    public int size() {
        return this.size;
    }
    public boolean isEmpty() {
        return this.size == 0;
    }

    public long peek() {
        if (this.size == 0) {
            throw new RuntimeException("队列是空的");
        }
        return this.array[0];
    }

    public long poll() {
        if (this.size == 0) {
            throw new RuntimeException("队列是空的");
        }
        long e = this.array[0];
        this.array[0] = this.array[this.size - 1];
        this.array[this.size - 1] = 0;
        this.size = this.size - 1;
        AdjustHeap(this.array, this.size, 0);
        return e;
    }

    private void AdjustHeap(long[] array, int size, int index) {
        while (2 * index + 1 < size) {
            int min = 2 * index + 1;
            int right = 2 * index + 2;
            if (right < size && array[right] < array[min]) {
                min = right;
            }
            if (array[index] <= array[min]) {
                return;
            }
            swap(array, index, min);
            index = min;
        }
    }

    private void swap(long[] array, int index, int min) {
        long tmp = array[index];
        array[index] = array[min];
        array[min] = tmp;
    }

    private void ensureCapacity() {
        if (this.size == this.array.length) {
            array = Arrays.copyOf(this.array, this.array.length * 2);
        }
    }
}
