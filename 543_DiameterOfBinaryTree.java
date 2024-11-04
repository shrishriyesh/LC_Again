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
    int h=0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)
        return 0;
        
        helper(root);
        return h;
    }
    public int helper(TreeNode root)
    {
        if(root==null)
        return 0;
        int lh=helper(root.left);
        int rh=helper(root.right);
        h=Math.max(lh+rh,h);
        return 1+Math.max(lh,rh);
    }
}