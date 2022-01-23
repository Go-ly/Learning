public class MyArrayList {
    private int[] array;
    private int size;    // 有效数据个数
    public MyArrayList() {
        this.array = new int[10];
        this.size = 0;
    }
    public void add(int x) {    // 暂不考虑扩容
        this.array[size] = x;
        this.size++;
    }
}
