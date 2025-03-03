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


// public ListNode removeNthFromEnd(ListNode head, int n) {
//         int l=0;
//         ListNode temp=head;
//         while(temp!=null)
//         {
//             l++;
//             temp=temp.next;
//         }
//         int del=l-n;
//         ListNode prev=null;
//         temp=head;
//         if(l==1)
//         return prev;
//         if(del<=0)
//         return temp.next;
//         for(int i=0;i<del;i++)
//         {
//             prev=temp;
//             temp=temp.next;
//         }
//         prev.next=temp.next;
//         return head;
//     }