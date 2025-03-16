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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root==p||root==q)
        return root;
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left!=null&&right!=null)
        return root;
        else if(left==null)
        return right;
        else
        return left;
    }
}

// Simple traversal using BST

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//  class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         if(root==null)
//         return root;
//         int first;
//         int sec;
//         if(p.val<q.val)
//         {
//             first=p.val;
//             sec=q.val;
//         }
//         else
//         {
//             first=q.val;
//             sec=p.val;
//         }
//         while(true)
//         {
//             if(first==root.val||sec==root.val|| (first<root.val && sec>root.val))
//             return root;
//             if(first<root.val && sec<root.val)
//             root=root.left;
//             else
//             root=root.right;
//         }
//     }
// }