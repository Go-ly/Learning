import java.util.Arrays;

public class MyArrayList {
    private int[] array;
    private int size;
    public int getSize() {
        return size;
    }
    public MyArrayList() {
        array = new int[2];
        size = 0;
        Arrays.fill(array, Integer.MIN_VALUE);
    }
    public void add(int e) {
        ensureCapacity();
        array[size] = e;
        size++;
    }

    private void ensureCapacity() {
        if (size < array.length) {
            return;
        }
        array = Arrays.copyOf(array, 2 * array.length);
        Arrays.fill(array, size, array.length, Integer.MIN_VALUE);
    }

    public void add(int pos, int e) {
        if (pos < 0 || pos > size) {
            throw new ArrayIndexOutOfBoundsException(pos + ":" + size);
        }
        ensureCapacity();
        for (int i = size; i > pos; i--) {
            array[i] = array[i - 1];
        }
        array[pos] = e;
        size++;
    }

    public int getElem(int pos) {
        if (pos < 0 || pos > size) {
            throw new ArrayIndexOutOfBoundsException(pos + ":" + size);
        }
        return array[pos];
    }

    public void delete(int pos) {
        if (pos < 0 || pos > size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        for (int i = pos; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        array[size] = Integer.MIN_VALUE;
    }

    // 删除第一个出现的elem
    public void removeFromHead(int elem) {
        for (int i = 0; i < size; i++) {
            if (array[i] == elem) {
                delete(i);
                break;
            }
        }
    }

    public void removeFromLast(int elem) {
        for (int i = size - 1; i > 0; i--) {
            if (array[i] == elem) {
                delete(i);
                break;
            }
        }
    }

    public int indexOf(int elem) {
        for (int i = 0; i < size; i++) {
            if (array[i] == elem) {
                return i;
            }
        }
        return -1;
    }

    public void removeAll(int elem) {
        int index;
        while (true) {
            index = indexOf(elem);
            if (index != -1) {
                delete(index);
            } else {
                return;
            }
        }
    }

    public void removeAllPlus(int elem) {
        // 创建一个新的数组
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
            if (src != elem) {
                array[dest] = array[src];
                dest++;
            }
        }
        size = dest;
    }

    public boolean isContain(int elem) {
        if (indexOf(elem) == -1) {
            return false;
        }
        return true;
    }

    public int setElem(int index, int e) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index + ":" + size);
        }
        int old = array[index];
        array[index] = e;
        return old;
    }











}
