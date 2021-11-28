import java.util.Arrays;

public class MyArrayList {
    private long[] array;
    private int size;   // 有效数据

    public MyArrayList() {
        // 初始化
        array = new long[2];
        size = 0;
        Arrays.fill(array, Long.MIN_VALUE);
    }

    // 尾插
    public void add(long elem) {
        // 确保至少可以放一个元素
        ensureCapacity();
        array[size] = elem;
        size++;
    }

    // 任意位置插
    public void add(int index, long elem) {
        // 检查下标合法
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException(index + ":" + size);
        }
        ensureCapacity();
        // 插入一个元素
//        将原有元素从后往后移动
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = elem;
        size++;
    }

    public void delete(int index) {
        if (index < 0 || index >= this.getSize()) {
            throw new ArrayIndexOutOfBoundsException(index + ":" + this.getSize());
        }
        for (int i = index; i < this.getSize() - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        array[size] = Long.MIN_VALUE;
    }

    public int find(long elem) {
        for (int i = 0; i < this.getSize(); i++) {
            if (array[i] == elem) {
                return i;
            }
        }
       return -1;
    }

    public void change(int index, long elem) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException(index + ":" + size);
        }
        array[index] = elem;
    }

    private void ensureCapacity() {
        if (size < array.length) {
            return;
        }
        // 放不下时进行扩容
        int newLength = 2 * array.length;
        long[] newArray = Arrays.copyOf(array, newLength);
        // 填充多余元素为MIN_VALUE
        Arrays.fill(newArray, size, newArray.length, Long.MIN_VALUE);
        array = newArray;
    }
    public int getSize() {
        return size;
    }

    public void check() {
        if (array == null) {
            throw new RuntimeException();
        }
        if (array.length == 0) {
            throw new RuntimeException();
        }
        if (size < 0) {
            throw new RuntimeException();
        }
        if (size > array.length) {
            throw new RuntimeException();
        }
        for (int i = 0; i < size; i++) {
            if (array[i] == Long.MIN_VALUE) {
                throw new RuntimeException();
            }
        }
        for (int i = size; i < array.length; i++) {
            if (array[i] != Long.MIN_VALUE) {
                throw new RuntimeException();
            }
        }
    }
    public long get(int index) {
        return array[index];
    }

}
