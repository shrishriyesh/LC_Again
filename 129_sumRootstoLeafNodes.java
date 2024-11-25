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
    public int sumNumbers(TreeNode root) {
        return helper(root,0);
    }
    public int helper(TreeNode h,int num)
    {
        if(h==null)
        return 0;
        if(h.left==null&&h.right==null)
        {
            return num*10+h.val;
        }
        return helper(h.left,num*10+h.val)+helper(h.right,num*10+h.val);
    }

}