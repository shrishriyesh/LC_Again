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
    public List<List<Integer>> levelOrder(TreeNode root) {
      Queue<TreeNode> q=new LinkedList<>();
      ArrayList<List<Integer>> out= new ArrayList<>();
      if(root==null)
      return out;
      q.add(root);
      while(!q.isEmpty())
      {
        int s=q.size();
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=0;i<s;i++)
        {
            TreeNode x=q.poll();
            if(x.left!=null)
            q.add(x.left);
            if(x.right!=null)
            q.add(x.right);
            res.add(x.val);
        }
        out.add(res);
      }
        return out;
    }
}