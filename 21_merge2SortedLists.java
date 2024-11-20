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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // if(list1==null)
        // return list2;
        // if(list2==null)
        // return list1;
        // ListNode rethead=(list1.val>=list2.val)?list2:list1;
        // ListNode temp=rethead;
        // while(list1!=null&&list2!=null)
        // {
        //     if(list1.val<list2.val)
        //     {
        //         temp.next=list1;
        //         list1=list1.next;
        //     }
        //     else
        //     {
        //         temp.next=list2;
        //         list2=list2.next;
        //     }
        //     temp=temp.next;
        // }
        // return rethead;

        ListNode Dummy=new ListNode(-1);
        ListNode head=Dummy;
        while(list1!=null&&list2!=null)
        {
            if(list1.val<list2.val)
            {
                Dummy.next=list1;
                list1=list1.next;
            }
            else
            {
                Dummy.next=list2;
                list2=list2.next;
            }
            Dummy=Dummy.next;
        }
        if(list1==null)
        Dummy.next=list2;
        else
        Dummy.next=list1;
        return head.next;
    }
}