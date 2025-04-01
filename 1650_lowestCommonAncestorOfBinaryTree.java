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

/*
Another method,
Time complexity: O(h) where h is the height of the tree
Space complexity: O(1) as we are using constant space
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        int hp=height(p);
        int hq= height(q);
        Node temp=null;
        if(hp<hq)
        {
           while(hq!=hp)
           {
            q=q.parent;
            hq--;
           }
        }
        else
        {
           while(hq!=hp)
           {
            p=p.parent;
            hp--;
           }
        }
        while(p!=q)
        {
            p=p.parent;
            q=q.parent;
        }
        return p;
        

    }
    public int height(Node x)
    {
        int h=1;
        while(x.parent!=null)
        {
            x=x.parent;
            h++;
        }
        return h;
    }
}