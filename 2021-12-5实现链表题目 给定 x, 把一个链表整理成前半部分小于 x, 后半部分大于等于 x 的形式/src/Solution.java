public class Solution {
        private static ListNode revLinkedList(ListNode head) {
            ListNode prev = null;
            ListNode cur = head;
            ListNode next;
            while (cur != null) {
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            return prev;
        }
    public static boolean isPalindrome(ListNode head) {
        // 将链表复制一份，然后逆置，与原链表进行比较
        ListNode newHead = null;
        ListNode cur1 = head;
        ListNode cur2;
        ListNode newLast = newHead;
        while (cur1 != null) {
            cur2 = new ListNode();
            cur2.val = cur1.val;
            cur1 = cur1.next;
            if (newHead == null) {
                newHead = cur2;
            } else {
                newLast.next = cur2;
            }
            newLast = cur2;
        }
        newHead = revLinkedList(newHead);
        cur2 = newHead;
        cur1 = head;
        while (cur1 != null && cur2 != null) {
            if (cur1.val == cur2.val) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            } else {
                return false;
            }
        }
        if (cur1 == cur2) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(1);
        
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        System.out.println(isPalindrome(head));
    }
}
