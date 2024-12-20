/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root==null)
        return root;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        Queue<TreeNode> q1=new LinkedList<>();
        q1.add(root);
        int level=0;
        while(!q.isEmpty())
        {
            int size=q.size();
            if(level%2!=0)
            {
                Stack<Integer> s=new Stack<>();
                for(int i=0;i<size;i++)
                {
                    TreeNode temp=q.poll();
                    s.push(temp.val);
                    if(temp.left!=null)
                    q.add(temp.left);
                    if(temp.right!=null)
                    q.add(temp.right);
                }
                for(int i=0;i<size;i++)
                {
                    TreeNode temp=q1.poll();
                    temp.val=s.pop();
                    if(temp.left!=null)
                    q1.add(temp.left);
                    if(temp.right!=null)
                    q1.add(temp.right);
                }
            }
            else
            {
                for(int i=0;i<size;i++)
                {
                    TreeNode temp=q.poll();
                    q1.poll();
                    if(temp.left!=null)
                    {q.add(temp.left);
                    q1.add(temp.left);}
                    if(temp.right!=null)
                    {
                        q.add(temp.right);
                        q1.add(temp.right);
                    }   
                }
            }
            level++;
        }
        return root;
    }
}