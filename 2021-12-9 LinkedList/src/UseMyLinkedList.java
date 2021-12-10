public class UseMyLinkedList {
    public static void assertTrue(boolean condition) {
        if (!condition) {
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        MyLinkedList list1 = new MyLinkedList();
        list1.check();
        assertTrue(list1.getSize() == 0);

        list1.add(0, 5);
        list1.check();
        assertTrue(list1.getSize() == 1);
        list1.add(1, 3);
        list1.check();
        assertTrue(list1.getSize() == 2);
        list1.add(2, 8);
        list1.check();
        assertTrue(list1.getSize() == 3);
        list1.add(2);
        list1.check();
        assertTrue(list1.getSize() == 4);
        list1.add(2);
        list1.check();
        assertTrue(list1.getSize() == 5);
        list1.add(10);
        list1.check();
        assertTrue(list1.getSize() == 6);
        list1.add(2);
        list1.check();
        assertTrue(list1.getSize() == 7);
        list1.deleteAll(2);
        list1.add(0, 2);
        list1.add(list1.getSize(), 200);
    }
}
