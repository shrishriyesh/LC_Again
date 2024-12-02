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
    int freq=0;
    int max_freq=0;
    ArrayList<Integer> list=new ArrayList<>();
    public int[] findMode(TreeNode root) {
        helper(root);
        int[] res=new int[list.size()];
        for(int num:list)
            res[list.indexOf(num)]=num;
        return res;
    }
    helper(TreeNode root){
        if(root==null){
            return;
        }
        helper(root.left);
        if(root.val==prev){
            freq++;
        }
        else{
            freq=1;
        }
        if(freq>max_freq){
            max_freq=freq;
            list.clear();
            list.add(root.val);
        }
        else if(freq==max_freq){
            list.add(root.val);
        }
        prev=root.val;
        helper(root.right);
    }
}