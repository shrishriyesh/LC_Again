/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        //stores node, its parent
       HashMap<TreeNode,TreeNode> graph=new HashMap<>();
        bfsBuild(root, graph);
        //stores visited nodes
        HashSet<TreeNode> visited=new HashSet<>();
        //stores answer
        List<Integer> answer=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(target);
        int level=0;
        visited.add(target);
        while(!queue.isEmpty())
        {
            int size=queue.size();
            if(level==k)
            break;
            level++;
            for(int i=0;i<size;i++)
            {
                TreeNode node=queue.poll();
                
               if(node.left!=null&&visited.contains(node.left)==false)
               {
                   queue.add(node.left);
                   visited.add(node.left);
               }
                if(node.right!=null&&visited.contains(node.right)==false)
                {
                    queue.add(node.right);
                    visited.add(node.right);
                }
                if(graph.containsKey(node)&&visited.contains(graph.get(node))==false)
                {
                    queue.add(graph.get(node));
                    visited.add(graph.get(node));
                }
                
            }
        }
        int size=queue.size();
        for(int i=0;i<size;i++)
        {
            answer.add(queue.poll().val);
        }
        return answer;
    }
    
    public void bfsBuild(TreeNode root, Map<TreeNode,TreeNode> graph){ 
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            TreeNode node=queue.poll();
            if(node.left!=null)
            {
                graph.put(node.left,node);
                queue.add(node.left);
            }
            if(node.right!=null)
            {
                graph.put(node.right,node);
                queue.add(node.right);
        }

        }
    }
}