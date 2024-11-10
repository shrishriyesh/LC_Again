/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        HashSet<Integer> hs=new HashSet<>();
        while(p!=null)
        {
            if(hs.contains(q.val))
            return q;
            else
            hs.add(p.val);
            p=p.parent;
        }
        while(q!=null)
        {
            if(hs.contains(q.val))
            return q;
            else
            hs.add(q.val);
            q=q.parent;
        }
        return q;
    }
}