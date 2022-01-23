import org.omg.CORBA.Object;

public class MyArrayList2<E> {
    private E[] array;
    private int size;   // 有效数据个数
    public MyArrayList2() {
        this.array = (E[])new Object[10];   // 注意：Java中泛型不允许定义数组
        this.size = 0;
    }
    public void add(E e) {
        this.array[size] = e;
        this.size++;
    }
}
