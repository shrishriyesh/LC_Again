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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode head=new ListNode(-1);
        ListNode dummy=head;
        while(l1!=null&&l2!=null)
        {
            int sum=l1.val+l2.val+carry;
            l1=l1.next;
            l2=l2.next;
            carry=sum/10;
            sum=sum%10;
            dummy.next=new ListNode(sum);
            dummy=dummy.next;
        }
        while(l1!=null)
        {
            int sum=l1.val+carry;
            l1=l1.next;
            carry=sum/10;
            sum=sum%10;
            dummy.next=new ListNode(sum);
            dummy=dummy.next;
        }
        while(l2!=null)
        {
            int sum=l2.val+carry;
            l2=l2.next;
            carry=sum/10;
            sum=sum%10;
            dummy.next=new ListNode(sum);
            dummy=dummy.next;
        }
        if(carry!=0)
        {
            dummy.next=new ListNode(carry);
        }
        return head.next;
    }
}


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode temp=l1;
        ListNode prev=null;
        while(l1!=null&&l2!=null)
        {
            int sum=l1.val+l2.val+carry;
            l1.val=sum%10;
            carry=sum/10;
            prev=l1;
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null)
        {
            int sum=l1.val+carry;
            l1.val=sum%10;
            prev=l1;
            carry=sum/10;
            l1=l1.next;
        }
        prev.next=l2;
        while(l2!=null)
        {
            int sum=l2.val+carry;
            l2.val=sum%10;
            prev=l2;
            carry=sum/10;
            l2=l2.next;
        }
        if(carry!=0)
        {
            l1.next=new ListNode(carry);
        }
        return temp;
    }
}