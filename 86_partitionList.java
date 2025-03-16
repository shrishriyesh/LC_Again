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
    public ListNode partition(ListNode head, int x) {
        ListNode firstPart=new ListNode(0);
        ListNode secPart=new ListNode(0);
        ListNode firstPartHead=firstPart;
        ListNode secPartHead=secPart;
        while(head!=null){
            if(head.val<x){
                firstPart.next=head;
                firstPart=firstPart.next;
            }else{
                secPart.next=head;
                secPart=secPart.next;
            }
            head=head.next;
        }
        secPart.next=null;
        firstPart.next=secPartHead.next;
        return firstPartHead.next;
    }
}