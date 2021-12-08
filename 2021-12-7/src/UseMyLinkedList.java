public class UseMyLinkedList {
    private static void assertTrue(boolean condition) {
        if (!condition) {
            throw new RuntimeException();
        }
    }
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.check();
        list.add(1);
        list.check();
    }
}
