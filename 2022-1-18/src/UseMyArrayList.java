public class UseMyArrayList {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(2);

        MyArrayList2<String> stringMyArrayList2 = new MyArrayList2<String>();
        stringMyArrayList2.add("1");
        stringMyArrayList2.add("2");
    }
}
