public class MyLinkedList {
    private Node head;
    private Node last;
    private int size;

    public MyLinkedList() {
        head = null;
        last = null;
        size = 0;
    }

    // 检查一个对象是否正确
    public void check() {
        if (size == 0) {
            if (head != null) {
                throw new RuntimeException();
            }
            if (last != null) {
                throw new RuntimeException();
            }
        } else if (size == 1) {
            if (head != last) {
                throw new RuntimeException();
            }

            if (head == null) {
                throw new RuntimeException();
            }
        } else {
            // 1. 检查 size 是否正确
            int actualSize = calcSize(head);
            if (size != actualSize) {
                throw new RuntimeException();
            }

            // 2. 检查头结点
            if (head == null) {
                throw new RuntimeException();
            }
            if (head.prev != null) {
                throw new RuntimeException();
            }
            if (head.next.prev != head) {
                throw new RuntimeException();
            }
            // 3. 检查尾结点
            if (last == null) {
                throw new RuntimeException();
            }
            if (last.next != null) {
                throw new RuntimeException();
            }
            if (last.prev.next != last) {
                throw new RuntimeException();
            }
            // 4. 检查剩余结点
            Node cur = head.next;
            while (cur != last) {
                if (cur.next.prev != cur) {
                    throw new RuntimeException();
                }
                if (cur.prev.next != cur) {
                    throw new RuntimeException();
                }

                cur = cur.next;
            }
        }
    }

    private int calcSize(Node head) {
        int s = 0;
        for (Node cur = head; cur != null; cur = cur.next) {
            s++;
        }
        return s;
    }

    public void add(int elem) {
        Node newNode = new Node(elem);
        if (size == 0) {
            head = newNode;
            last = newNode;
            size++;
            return;
        }
        newNode.prev = last;
        last.next = newNode;
        last = newNode;
        size++;
    }

    public void add(int index, int elem) {
        // 结点个数 > 1 && 不是头插 && 不是尾插

        Node newNode = new Node(elem);
        Node indexNode = head;
        for (int i = 0; i < index; i++) {
            indexNode = indexNode.next;
        }
        Node prevNode = indexNode.prev;
        newNode.next = indexNode;
        newNode.prev = prevNode;
        indexNode.prev = newNode;
        prevNode.next = newNode;
        size++;
    }

    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index + ":" + size);
        }
        int val;
        // 1) 空链表（不需要处理）
        // 2) 只有一个元素的链表
        // 3) 有两个元素的链表 + 头删
        // 4) 有两个元素的链表 + 尾删
        // 5) 超过两个元素的链表 + 头删
        // 6) 超过两个元素的链表 + 尾删
        // 7) 超过两个元素的链表 + 中间删除
        if (size == 1) {
            val = head.val;
            head = null;
            last = null;
        } else if (size == 2 && index == 0) {
            val = head.val;
            head = head.next;
            head.prev = null;
        } else if (size == 2 && index == size - 1) {
            val = last.val;
            last = last.prev;
            last.next = null;
        } else if (size > 2 && index  == 0) {
            val = head.val;
            head = head.next;
            head.prev = null;
        } else if (size > 2 && index == size - 1) {
            val = last.val;
            last = last.prev;
            last.next = null;
        } else {
            // 中间插
            Node indexNode = head;
            for (int i = 0; i < index; i++) {
                indexNode = indexNode.next;
            }
            val = indexNode.val;
            Node prevNode = indexNode.prev;
            Node nextNode = indexNode.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }
        size--;
        return val;
    }
}
