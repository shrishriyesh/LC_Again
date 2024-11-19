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
    PriorityQueue<ListNode> queue=new PriorityQueue<>(
        new Comparator<ListNode>(){
            @Override
            public int compare(ListNode a, ListNode b)
            {return ((a.val-b.val)>=0?1:-1);}}
    );
    public ListNode mergeKLists(ListNode[] lists) {
     ListNode headprev=new ListNode(-1);
     ListNode head=headprev;
     for(ListNode x:lists)
     {
        if(x!=null)
        queue.add(x);
     }
     while(!queue.isEmpty())
     {
        ListNode temp=queue.poll();
        headprev.next=temp;
        headprev=headprev.next;
        if(headprev.next!=null)
        queue.add(temp.next);
     }
     return head.next;   
    }
}