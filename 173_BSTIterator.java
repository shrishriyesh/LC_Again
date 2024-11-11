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
class BSTIterator {
    List<Integer> BST=new ArrayList<>();
    int c=0;
    public BSTIterator(TreeNode root) {
        //BST=new ArrayList<>(helper(root));
        helper(root);
    }
    public void helper(TreeNode root)
    {
        if(root==null)
        return; 
        helper(root.left);
        BST.add(root.val);
        helper(root.right);
    }
    public int next() {
        int ans= BST.get(c);
        c++;
        return ans;
    }
    
    public boolean hasNext() {
        if(c>=BST.size())
        return false;
        else
        return true;
        
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */