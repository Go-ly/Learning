public class MyLinkedList {
    public Node head;
    public MyLinkedList() {
        this.head = null;
    }

    // 头插
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (this.head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // 尾插
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = newNode;
    }

    // 得到单链表的长度
    public int size() {
        int count = 0;
        Node cur = this.head;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }

    // 任意位置插入
    public void addIndex(int index, int data) {
        if (index < 0 || index > this.size()) {
            throw new RuntimeException("index" + ":" + index);
        }
        Node newNode = new Node(data);
        if (index == 0) {    // 头插
            this.addFirst(data);
            return;
        }
        if (index == this.size()) {   // 尾插
            this.addLast(data);
            return;
        }
        Node cur = this.head;
        while (index - 1 != 0) {
            cur = cur.next;
            index--;
        }
        newNode.next = cur.next;
        cur.next = newNode;
    }

    // 查找是否包含关键字key
    public boolean contains(int key) {
        Node cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    // 删除第一次出现的关键字
    public void remove(int key) {
        if (this.head == null) {
            return;
        }
        if (this.head.data == key) {   // 头删
            head = head.next;
            return;
        }
        Node cur = this.head;
        while (cur.next != null) {
            if (cur.next.data == key) {
                break;
            }
            cur = cur.next;
        }
        if (cur.next != null) {
            cur.next = cur.next.next;
        }
    }

    // 删除所有值为key的节点
    public void removeAll(int key) {
        if (this.head == null) {
            return;
        }
        Node prev = this.head;
        Node cur = this.head.next;
        while (cur != null) {
            if (cur.data == key) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        if (this.head.data == key) {
            this.head = this.head.next;
        }
    }

    public void display() {
        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + "->");
            cur = cur.next;
        }
        System.out.print("null");
    }

    // 清空链表
    public void clear() {
        head = null;
    }
}






























