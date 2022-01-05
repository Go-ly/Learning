public class MyLinkedList {
    public Node head;
    public Node tail;
    public MyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // 头插
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (this.head == null) {    // 链表为空时
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }
    }

    // 尾插
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (this.head == null) {   // 链表为空的情况
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.prev = tail;
            this.tail.next = newNode;
            this.tail = newNode;
        }
    }

    // 得到单链表的长度
    public int size() {
        int count = 0;
        Node cur = this.head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    // 任意位置插入
    public void addIndex(int index,int data) {
        if (index < 0 || index > this.size()) {
            throw new RuntimeException("index : "  + index);
        }
        Node newNode = new Node(data);
        if (index == 0) {
            if (this.head == null) {   // 头插
                this.head = newNode;
                this.tail = newNode;
            } else {
                newNode.next = this.head;
                this.head.prev = newNode;
                this.head = newNode;
            }
        } else if (index == this.size()) {   // 尾插
            newNode.prev = this.tail;
            this.tail.next = newNode;
            this.tail = newNode;
        } else {
            Node cur = this.head;
            while (index != 0) {
                cur = cur.next;
                index--;
            }
            Node prevNode = cur.prev;
            newNode.next = cur;
            newNode.prev = prevNode;
            prevNode.next = newNode;
            cur.prev = newNode;
        }
    }

    // 查找是否包含关键字key
    public boolean contains(int key) {
        Node cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                return true;
            }
        }
        return false;
    }

    // 删除第一次出现关键字为key的节点
    public void remove(int key) {
        if (this.head == null) {
            return;
        }
        Node cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                break;
            }
            cur = cur.next;
        }
        if (cur == null) {
            return;
        }
        if (cur == this.head) {
            this.head = head.next;
            this.head.prev = null;
            return;
        }
        if (cur == this.tail) {
            cur.prev.next = null;
            this.tail = cur.prev;
            return;
        }
        Node prevNode = cur.prev;
        Node nextNode = cur.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    // 删除所有值为key的节点
    public void removeAllKey(int key) {
        if (this.head == null) {
            return;
        }
        Node prevNode = this.head;
        Node cur = this.head.next;
        while (cur != null) {
            if (cur.data == key) {
                prevNode.next = cur.next;
                cur = cur.next;
                if (cur == null) {
                    this.tail = prevNode;
                } else {
                    cur.prev = prevNode;
                }
            } else {
                cur = cur.next;
                prevNode = prevNode.next;
            }
        }
        if (this.head.data == key) {
            this.head = this.head.next;
            if (this.head == null) {
                this.tail = null;
                return;
            }
            this.head.prev = null;
        }
    }

    // 打印链表
    public void display() {
        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + "->");
            cur = cur.next;
        }
        System.out.print("null");
    }

    // 清空链表，释放内存
    public void clear() {
        if (this.head == null) {
            return;
        }
        Node cur = this.head;
        Node nextNode;
        while (cur != null) {
            nextNode = cur.next;
            cur.prev = null;
            cur.next = null;
            cur = nextNode;
        }
        this.tail = null;
    }
}































