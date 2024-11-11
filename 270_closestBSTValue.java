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
    int small=Integer.MIN_VALUE;
    public int closestValue(TreeNode root, double target) {
        helper(root,target);
        return small;
    }
    public void helper(TreeNode root,double target)
    {
        if(root==null)
        return;
        helper(root.left,target);
        small=(Math.abs(root.val-target)<Math.abs(small-target))?root.val:small;
        helper(root.right,target);
    }
}