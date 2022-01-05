import java.util.Arrays;

public class MyArrayList {
    public int[] data;
    public int size;
    public MyArrayList() {
        this.data = new int[10];   // 后面不够再增容
        this.size = 0;    // 初始无有效数据，size 为0
    }

    public String printMyArrayList() {
        String str = "[";
        for (int i = 0; i < this.size - 1; i++) {
            str += this.data[i] + ", ";
        }
        str += this.data[this.size - 1];
        str += "]";
        return str;
    }

    // 确保容量够用
    private void ensureCapacity() {
        if (this.size == this.data.length) {
            // 说明满了，该扩容了
            this.data = Arrays.copyOf(this.data, 2 * this.data.length);
        }
    }

    public void add(int pos, int num) {
        if (pos < 0 || pos > this.size) {
            throw new RuntimeException("ArrayIndexOutOfBoundsException : " + pos);
        }
        ensureCapacity();
        for (int i = this.size; i > pos; i--) {
            this.data[i] = this.data[i - 1];
        }
        this.data[pos] = num;
        this.size++;
    }

    public boolean contains(int num) {
        for (int i = 0; i < this.size; i++) {
            if (this.data[i] == num) {
                return true;
            }
        }
        return false;
    }

    public int search(int key) {
        for (int i = 0; i < this.size; i++) {
            if (this.data[i] == key) {
                return i;
            }
        }
        return -1;
    }
    public int getPos(int pos) {
        if (pos < 0 || pos >= this.size) {
            throw new RuntimeException("ArrayIndexOfBoundsException : " + pos);
        }
        return this.data[pos];
    }

    // 将 pos 位置的元素值设为 value
    public void setPos(int pos, int value) {
        if (pos < 0 || pos >= this.size) {
            throw new RuntimeException("ArrayIndexOfBoundsException : " + pos);
        }
        this.data[pos] = value;
    }

    // 删除第一次出现的关键字key
    public void remove(int key) {
        int pos = search(key);
        if (pos == -1) {
            return;        // 若是这个数字不存在，则返回
        }
        for (int i = pos; i < this.size - 1; i++) {
            this.data[i] = this.data[i + 1];      // 从后往前挪，直接将要删除的数字覆盖掉
        }
        this.size--;
    }

    // 删除所有的key
    public void removeAll(int key) {
        for (int i = 0; i < this.size; i++) {
            if (this.search(key) != -1) {
                remove(key);
            } else {
                return;
            }
        }
    }

    public void removeAllPlus(int key) {
        int[] newData = new int[this.data.length];
        int j = 0;
        for (int i = 0; i < this.size; i++) {
            if (this.data[i] != key) {
                newData[j] = this.data[i];
                j++;
            }
        }
        this.data = newData;
        this.size = j;
    }

    public void removeAllPlusPlus(int key) {
        int dest = 0;
        for (int src = 0; src < this.size; src++) {
            if (this.data[src] != key) {
                this.data[dest] = this.data[src];
                dest++;
            }
        }
        this.size = dest;
    }

    // 获取顺序表长度
    public int size() {
        return this.size;
    }

    // 清空顺序表
    public void clear() {
        this.size = 0;
    }
}


