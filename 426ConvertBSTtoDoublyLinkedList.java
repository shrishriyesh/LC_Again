/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
     private Node prev = null; // Make prev a class-level variable
    private Node head = null; // Add head to keep track of the smallest node

    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;
        
        treetoDll(root);
        
        // Make the list circular by connecting head and tail
        head.left = prev;
        prev.right = head;

        return head;
    }

    public void treetoDll(Node root) {
        if (root == null)
            return;

        // Traverse left subtree
        treetoDll(root.left);

        // Process current node
        if (prev == null) {
            head = root; // Set head to the smallest node (first node in in-order)
        } else {
            root.left = prev;
            prev.right = root;
        }

        // Move prev to current node
        prev = root;

        // Traverse right subtree
        treetoDll(root.right);
    }
}