/**
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
class BSTIterator
{
    public int reverse=0;
    public Stack<TreeNode> stack = new Stack<TreeNode>();
    public BSTIterator(TreeNode root,boolean isReverse) {
        // Constructor implementation
        reverse=isReverse?1:0;
        // Push the root node onto the stack
        push(root);
    }
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    public int next() {
        // Pop the top node from the stack
        TreeNode node = stack.pop();
        int result = node.val;
        // Push the next node onto the stack
        if(reverse==1) {
            push(node.left);
        } else {
            push(node.right);
        }
        return result;
    }
    public void push(TreeNode node) {
        // Push a node onto the stack
        if(node!=null) {
            stack.push(node);
            if(reverse==1) {
                push(node.right);
            } else {
                push(node.left);
            }
        }
    }
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null)
        return false;
        BSTIterator left = new BSTIterator(root, false);
        BSTIterator right = new BSTIterator(root, true);

        int l=left.next();
        int r=right.next();
        while(l<r) {
            if(l+r==k) {
                return true;
            } else if(l+r<k) {
                if(left.hasNext()) {
                    l=left.next();
                } else {
                    return false;
                }
            } else {
                if(right.hasNext()) {
                    r=right.next();
                } else {
                    return false;
                }
            }
        }
        return false;
        
    }
}


// VERY VERY IMPORTANT, gives an understanding of how Objects can be used properly. Use a BST Iterator for left or right movement based on reverse flag
// The reverse flag is used to determine the direction of traversal in the binary search tree (BST).
// When reverse is set to 1, the BSTIterator traverses the tree in reverse order (right to left).
// When reverse is set to 0, the BSTIterator traverses the tree in the normal order (left to right).
// This allows the iterator to efficiently traverse the tree in both directions, depending on the value of the reverse flag.