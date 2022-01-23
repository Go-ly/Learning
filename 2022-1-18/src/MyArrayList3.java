public class MyArrayList3 {
    private Object[] array;
    private int size;
    public MyArrayList3() {
        this.array = new Object[10];
        this.size = 0;
    }
    public void add(Object e) {
        this.array[size] = e;
        size++;
    }
}
