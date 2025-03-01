class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (left > 1) {
            pre = pre.next;
            left--;
            right--;
        }
        ListNode cur = pre.next;
        while (right > 1) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
            right--;
        }
        return dummy.next;
        
    }
}