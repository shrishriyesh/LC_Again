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
    public void reorderList(ListNode head) {
        if(head==null)
        return;
        ListNode mid = getmid(head);

        // Step 2: Reverse the second half of the list
        ListNode secondHalf = revList(mid.next);
        mid.next = null; // Split the list into two halves

        // Step 3: Merge the two halves
        ListNode firstHalf = head;
        while (secondHalf != null) {
            ListNode temp1 = firstHalf.next;
            ListNode temp2 = secondHalf.next;

            firstHalf.next = secondHalf;
            secondHalf.next = temp1;

            firstHalf = temp1;
            secondHalf = temp2;
        }
    }
    public ListNode getmid(ListNode h)
    {
        ListNode slow=h;
        ListNode fast=h;
        while(fast!=null&&fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode revList(ListNode h)
    {
        ListNode prev=null;
        ListNode curr=null;
        while(h!=null)
        {
            curr=h;
            h=h.next;
            curr.next=prev;
            prev=curr;
        }
        return curr;
    }



}