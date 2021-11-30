import java.util.ArrayList;

public class UseMyArrayList {
    private void assertTrue(boolean condition) {
        if (!condition) {
            throw new RuntimeException();
        }
    }
    public static void main(String[] args) {

        MyArrayList arrayList = new MyArrayList();
        arrayList.add(0, 1);
        arrayList.add(1, 2);
        arrayList.add(2, 3);
        arrayList.add(3, 3);
        arrayList.add(4, 5);
        arrayList.add(5, 2);
        arrayList.add(6, 2);
        arrayList.disPlay();
        arrayList.removeAllPlusPlus(3);
        arrayList.disPlay();
    }
}
