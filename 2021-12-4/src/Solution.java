public class Solution {
    private int length(ListNode head) {
        int len = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            len++;
        }
        return len;
    }
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode cur1 = head;
        ListNode cur2 = head;

        for (int i = 0; i < k; i++) {
            if (cur2 == null) {
                return null;
            }
            cur2 = cur2.next;
        }
        if (cur2 == null) {
            return head;
        }
        while (cur2 != null) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }
}

