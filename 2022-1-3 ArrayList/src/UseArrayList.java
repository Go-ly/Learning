import java.util.Arrays;

public class UseArrayList {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(0, 0);
        myArrayList.add(1, 3);
        myArrayList.add(2, 2);
        myArrayList.add(3, 3);
        myArrayList.add(4, 666);
        myArrayList.add(5, 3);
        myArrayList.removeAllPlusPlus(0);
        System.out.println(myArrayList.printMyArrayList());
    }
}
