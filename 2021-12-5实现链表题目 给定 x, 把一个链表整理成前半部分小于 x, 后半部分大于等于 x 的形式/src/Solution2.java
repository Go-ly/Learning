import java.util.List;

public class Solution2 {
    // 实现链表题目: 给定 x, 把一个链表整理成前半部分小于 x, 后半部分大于等于 x 的形式
    public static ListNode changeOfX(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode bigList = null;
        ListNode smallList = null;
        ListNode bigListLast = null;
        ListNode smallListLast = null;
        ListNode cur = head;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            if (cur.val < x) {
                if (smallListLast == null) {
                    smallListLast = cur;
                    smallListLast.next = null;
                    smallList = smallListLast;
                } else {
                    smallListLast.next = cur;
                    smallListLast = smallListLast.next;
                }
                cur.next = null;
            } else {
                if (bigListLast == null) {
                    bigListLast = cur;
                    bigListLast.next = null;
                    bigList = bigListLast;
                } else {
                    bigListLast.next = cur;
                    bigListLast = bigListLast.next;
                }
                cur.next = null;
            }
            cur = next;
        }
        // 将smallList与bigList合并
        smallListLast.next = bigList;
        return smallList;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(7);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(7);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(9);
        ListNode n6 = new ListNode(6);
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        ListNode newNode = changeOfX(head, 6);
    }
}
