/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null)
        return null;
        HashMap<Node, Node> hm=new HashMap<>();
        Queue<Node> q=new LinkedList<>();
        q.add(node);
        hm.put(node,new Node(node.val,new ArrayList<Node>()));
        while(!q.isEmpty())
        {
            Node n=q.poll();
            List<Node> ar=n.neighbors;
            for(int i=0;i<ar.size();i++)
            {
                if(!hm.containsKey(ar.get(i)))
                {
                    hm.put(ar.get(i),new Node(ar.get(i).val,new ArrayList<Node>()));
                    q.add(ar.get(i));
                }
                hm.get(n).neighbors.add(hm.get(ar.get(i)));
            }
        }
        return hm.get(node);
    }
}