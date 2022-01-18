class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution {
    public static int getLen(ListNode cur) {
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }
    public static ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode low = head;
        ListNode high = head;
        while (high != null) {
            low = low.next;
            high = high.next;
            if (high != null) {
                high = high.next;
            } else {
                return null;
            }
            if (low == high) {
                break;
            }
        }
        if (high == null) {
            return null;
        }
        ListNode list2 = low.next;
        low.next = null;
        // 求head和list2的相交结点
        int lenH = getLen(head);
        int lenL = getLen(list2);
        int len = lenH > lenL ? lenH - lenL : lenL - lenH;
        while (len > 0) {
            if (lenH > lenL) {
                head = head.next;
            }
            if (lenH < lenL) {
                list2 = list2.next;
            }
            len--;
        }
        while (head != list2 && head != null && list2 != null) {
            head = head.next;
            list2 = list2.next;
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode head = null;
        head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        System.out.println(detectCycle(head).val);
    }
}
