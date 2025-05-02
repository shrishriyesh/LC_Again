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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null)
        return head;
        ListNode temp=head;
        int c=0;
        while(temp!=null)
        {
            temp=temp.next;
            c++;
        }
        k=k%c;
        if(k==0)
        return head;
        ListNode curr=head;
        ListNode dummy=head;
        while(k>0)
        {
            curr=curr.next;
            k--;
        }
        while(curr.next!=null)
        {
            dummy=dummy.next;
            curr=curr.next;
        }
        ListNode x=dummy.next;
        dummy.next=null;
        curr.next=head;
        return x;
    }
}