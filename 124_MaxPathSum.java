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
    int sum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null)
        return 0;
        int res=maxPathS(root);
        return sum;
    }
    public int maxPathS(TreeNode root)
    {
         if(root==null)
        return 0;
        int left=Math.max(0,maxPathS(root.left));
        int right=Math.max(0,maxPathS(root.right));
        sum=Math.max(sum,(left+right+root.val));
        return Math.max(root.val+left,root.val+right);
    }

}