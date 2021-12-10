public class MyLinkedList {
    private Node head;
    private Node last;
    private int size;

    public MyLinkedList() {
        head = null;
        last = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void deleteAll(int elem) {
        Node cur = head;
        int flag = 0;
        for (int i = 0; i < size; i++) {
            delete(elem);
        }
    }

    public void delete(int elem) {
        int index = indexOf(elem);
        if (index != -1) {
            remove(index);
        }
    }

    public boolean contains(int elem) {
        return indexOf(elem) != -1;
    }

    // 找第一个elem的下标  O(n)
    public int indexOf(int elem) {
        Node cur = head;
        for (int i = 0; i < size; i++) {
            if (cur.val == elem) {
                return i;
            }
            cur = cur.next;
        }
        return -1;
    }

    public int set(int index, int elem) {
        if (index > 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Node indexNode = head;
        for(int i = 0; i < index; i++) {
            indexNode = indexNode.next;
        }
        int val = indexNode.val;
        indexNode.val = elem;
        return val;
    }

    // O(n)
    public int get(int index) {
        if (index < 0 || index >=size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Node indexNode = head;
        for (int i = 0; i < index; i++) {
            indexNode = indexNode.next;
        }
        return indexNode.val;
    }

    //  删除指定下标位置的元素并且返回val
    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index + ":" + size);
        }
        int val;
        if (size == 1) {
            val = head.val;
            head = null;
            last = null;
        } else {
            if (index == 0) {
                val = head.val;
                head = head.next;
                head.prev = null;
            } else if (index == size - 1) {
                val = last.val;
                last = last.prev;
                last.next = null;
            } else {
                Node indexNode = head;
                for (int i = 0; i < index; i++) {
                    indexNode = indexNode.next;
                }
                val = indexNode.val;
                Node prevNode = indexNode.prev;
                Node nextNode = indexNode.next;
                nextNode.prev = prevNode;
                prevNode.next = nextNode;
            }
        }
        size--;
        return val;
    }

    // 尾插
    public void add(int elem) {
        // 空表   1个结点  多个结点
        Node newNode = new Node(elem);
        if (size == 0) {
            head = newNode;
        } else {
            newNode.prev = last;
            last.next = newNode;
        }
        last = newNode;
        size++;
    }



    // 任意位置插    O(n)
    public void add(int index, int elem) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException(index + ":" + size);
        }
        Node newNode = new Node(elem);
        // 头插，   尾插，   中间插
        // size == 0;
        // size == 1  size >= 2
        if (size == 0) {
            // 此时只有一种情况
            head = newNode;
            last = newNode;
        } else if (size == 1) {
            if (index == 0) {
                // 头插
                newNode.next = head;
                head = newNode;
                last.prev = newNode;
            } else {
                // 尾插
                newNode.prev = last;
                last.next = newNode;
                last = newNode;
            }
        } else {
            // size >= 2
            if (index == 0) {
                // 头插
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            } else if (index == size) {
                // 尾插
                newNode.prev = last;
                last.next = newNode;
                last = newNode;
            }
            else {
                Node indexNode = head;
                for (int i = 0; i < index; i++) {
                    indexNode = indexNode.next;
                }
                Node prevNode = indexNode.prev;
                newNode.prev = prevNode;
                newNode.next = indexNode;
                prevNode.next = newNode;
                indexNode.prev = newNode;
            }
        }
        size++;
    }

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
            int actualSize = calcSize(head);
            if (size != actualSize) {
                throw new RuntimeException();
            }
            if (head == null) {
                throw new RuntimeException();
            }
            if (head.prev != null) {
                throw new RuntimeException();
            }
            if (head.next.prev != head) {
                throw new RuntimeException();
            }
            if (last == null) {
                throw new RuntimeException();
            }
            if (last.prev.next != last) {
                throw new RuntimeException();
            }
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
        int size = 0;
        for (Node cur = head; cur != null; cur = cur.next) {
            size++;
        }
        return size;
    }
}
