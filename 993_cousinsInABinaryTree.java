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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        boolean isfirstinlevel=false;
        boolean issecondinlevel=false;
        q.add(root);
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode temp=q.poll();
                if(temp.val==x)
                isfirstinlevel=true;
                if(temp.val==y)
                issecondinlevel=true;
                if(temp.left!=null)
                {
                    q.add(temp.left);
                }
                if(temp.right!=null)
                {
                    q.add(temp.right);
                }
                if(temp.right!=null&&temp.left!=null)
                if(temp.right.val==x&&temp.left.val==y||temp.right.val==y&&temp.left.val==x)
                return false;
            }
            if(isfirstinlevel && issecondinlevel)
            {
                return true;
            }
            if(isfirstinlevel || issecondinlevel)
            {
                return false;
            }
        }
        return false;
          }
}