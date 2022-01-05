public class UseLinkedList {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addFirst(1);
        myLinkedList.addFirst(2);
        myLinkedList.addFirst(3);
        myLinkedList.addFirst(4);
        myLinkedList.addFirst(666);
        myLinkedList.addFirst(666);
        myLinkedList.addFirst(666);
        myLinkedList.addLast(666);
        myLinkedList.addLast(666);
        myLinkedList.addLast(666);
        myLinkedList.addIndex(2, 666);
        myLinkedList.removeAll(666);
        myLinkedList.display();
    }
}
