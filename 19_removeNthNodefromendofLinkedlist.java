/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // ListNode temp=h;
        // int c=0;
        // while(temp!=null)
        // {
        //     c++;
        //     temp=temp.next;
        // }
        // int x=c-n;
        // if(x==0)
        // return h.next;
        // temp=h;
        // while(x>1)
        // {
        //     temp=temp.next;
        //     x--;
        // }

        // if(temp.next!=null)
        // temp.next=temp.next.next;
        // return h;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}