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
 import java.util.*;
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null)
        {
            return res;
        }
        Queue<TreeNode> val=new LinkedList<>();
        Queue<Integer> pos=new LinkedList<>();
        HashMap<Integer, List<Integer>> hm=new HashMap<>();
        val.add(root);
        pos.add(0);
        int min=0;
        int max=0;
        while(!val.isEmpty())
        {
            TreeNode t=val.remove();
            int p= pos.remove();
            min=Math.min(p,min);
            max=Math.max(p,max);
            if(hm.containsKey(p))
            {
                hm.get(p).add(t.val);
            }
            else
            {
                List<Integer> arr=new ArrayList<>();
                arr.add(t.val);
                hm.put(p,arr);
            }
            if(t.left!=null)
            {
                val.add(t.left);
                pos.add(p-1);
            }
            if(t.right!=null)
            {
                val.add(t.right);
                pos.add(p+1);
            }
        }
        // Collection<List<Integer>> values = hm.values();
        // List<List<Integer>> listOfValues 
        //     = new ArrayList<>(values);
        //     return listOfValues;
        
        for(int i=min;i<=max;i++)
        {
            if(hm.containsKey(i))
            {
                res.add(hm.get(i));
            }
        }
        return res;
    }
}