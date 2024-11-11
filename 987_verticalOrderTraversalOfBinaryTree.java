import java.util.*;

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> val = new LinkedList<>();
        Queue<int[]> pos = new LinkedList<>(); // Use int[] to store {row, col}
        HashMap<Integer, List<int[]>> hm = new HashMap<>(); // Change List<Integer> to List<int[]> to store {row, value}

        val.add(root);
        pos.add(new int[]{0, 0}); // Add {row, col} as {0, 0}

        int min = 0;
        int max = 0;

        while (!val.isEmpty()) {
            TreeNode t = val.remove();
            int[] p = pos.remove();
            int row = p[0], col = p[1];

            // Add node to the hashmap with row info
            // Check if the column already has a list, if not, create a new list
        if (!hm.containsKey(col)) {
        hm.put(col, new ArrayList<>());
        }

        // Add the {row, value} pair to the list for this column
        hm.get(col).add(new int[]{row, t.val});


            // Track min and max column indices
            min = Math.min(col, min);
            max = Math.max(col, max);

            // Add children to the queue with updated row and column
            if (t.left != null) {
                val.add(t.left);
                pos.add(new int[]{row + 1, col - 1});
            }
            if (t.right != null) {
                val.add(t.right);
                pos.add(new int[]{row + 1, col + 1});
            }
        }

        // Process the columns in order from min to max
        for (int i = min; i <= max; i++) {
            if (hm.containsKey(i)) {
                List<int[]> nodes = hm.get(i);
                // Sort by row, and if rows are the same, by value
                Collections.sort(nodes, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
                List<Integer> sortedColumn = new ArrayList<>();
                for (int[] node : nodes) {
                    sortedColumn.add(node[1]);
                }
                res.add(sortedColumn);
            }
        }

        return res;
    }
}
