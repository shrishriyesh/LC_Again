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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        int maxSum=Integer.MIN_VALUE;
        int minLev=Integer.MAX_VALUE;
        int lev=0;
        q.add(root);
        while(q.isEmpty()==false){
            lev++;
            int size=q.size();
            int sum=0;
            for(int i=0;i<size;i++)
            {
                TreeNode temp=q.poll();
                sum+=temp.val;
                if(temp.left!=null)
                q.add(temp.left);
                if(temp.right!=null)
                q.add(temp.right);
            }
            if(sum>maxSum)
            {
                minLev=lev;
                maxSum=sum;
            }
        }
        return minLev;
    }
}