import java.util.Arrays;

public class MyArrayList {
    private int[] array;
    private int size;

    // 初始化
    public MyArrayList() {
        array = new int[2];
        size = 0;
        Arrays.fill(array, Integer.MIN_VALUE);
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
            if (array[i] == Integer.MIN_VALUE) {
                throw new RuntimeException();
            }
        }
        for (int i = size; i < array.length; i++) {
            if (array[i] != Integer.MIN_VALUE){
                throw new RuntimeException();
            }
        }
    }

    // 任意位置插入数据
    public void add(int pos, int data) {
        if (pos < 0 || pos > size) {
            throw new ArrayIndexOutOfBoundsException(pos + ":" + size);
        }
        ensureCapacity();
        for (int i = size; i > pos; i--) {
            array[i] = array[i - 1];
        }
        array[pos] = data;
        size++;
    }

    // 确保可以插入一个数据
    public void ensureCapacity() {
        if (size < array.length) {
            return;
        }
        // 在满时进行扩容
        int newlength = 2 * array.length;
        int[] newArray = Arrays.copyOf(array, newlength);
        Arrays.fill(newArray, array.length, newlength, Integer.MIN_VALUE);
        array = newArray;
    }

    // 打印顺序表
    public void disPlay() {
        System.out.printf("[");
        for (int i = 0; i < size - 1; i++) {
            System.out.printf("%d, ", array[i]);
        }
        if (size != 0) {
            System.out.printf("%d", array[size - 1]);
        }
        System.out.printf("]\n");
    }

    // 查找元素
    public int search(int elem) {
        if (elem > Integer.MAX_VALUE || elem < Integer.MIN_VALUE) {
            throw new RuntimeException();
        }
        for (int i = 0; i < size; i++) {
            if (array[i] == elem) {
                return i;
            }
        }
        return -1;
    }

    // 判定是否包含某个元素
    public boolean isContain(int elem) {
        if (search(elem) == -1) {
            return false;
        }
        return true;
    }

    // 获取pos位置的元素数据
    public int getElem(int pos) {
        if (pos < 0 || pos > size) {
            throw new RuntimeException();
        }
        return array[pos];
    }

    // 将pos位置的值改变
    public void setNum(int pos, int elem) {
        if (pos < 0 || pos > size) {
            throw new RuntimeException();
        }
        if (elem < Integer.MIN_VALUE || elem > Integer.MAX_VALUE) {
            throw new RuntimeException();
        }
        array[pos] = elem;
    }

    // 删除pos位置的元素
    public void delete(int pos) {
        if (pos < 0 || pos > size) {
            throw new RuntimeException();
        }
        for (int i = pos; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        array[size] = Integer.MIN_VALUE;
    }

    // 删除所有指定元素
    public void removeAll(int elem) {
        if (elem < Integer.MIN_VALUE || elem > Integer.MAX_VALUE) {
            throw new RuntimeException();
        }
        while (true) {
            if (search(elem) == -1) {
                return;
            }
            delete(search(elem));
        }
    }

    // O(n)
    // 空间复杂度O(n)
    public void removeAllPlus(int elem) {
        if (elem < Integer.MIN_VALUE || elem > Integer.MAX_VALUE) {
            throw new RuntimeException();
        }
        int[] newArray = new int[array.length];
        Arrays.fill(newArray, Integer.MIN_VALUE);
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (array[i] != elem) {
                newArray[j] = array[i];
                j++;
            }
        }
        array = newArray;
        size = j;
    }

    public void removeAllPlusPlus(int elem) {
        int dest = 0;
        for (int src = 0; src < size; src++) {
            if (array[src] != elem) {
                array[dest] = array[src];
                dest++;
            }
        }
        size = dest;
    }
    // 获取顺序表的长度
    public int getSize() {
        return size;
    }

    // 清空顺序表
    public void clear() {
        size = 0;
        Arrays.fill(array, Integer.MIN_VALUE);
    }
}
