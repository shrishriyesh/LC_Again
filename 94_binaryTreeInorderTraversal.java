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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();

        while (root != null || !st.isEmpty()) {
            // Reach the leftmost node of the current node
            while (root != null) {
                st.push(root);
                root = root.left;
            }
            
            // Current node is null at this point, so pop from the stack
            TreeNode r = st.pop();
            res.add(r.val);  // Visit the node
            
            // We have visited the node and its left subtree. Now, move to the right subtree.
            root = r.right;
        }

        return res;
    }
}
