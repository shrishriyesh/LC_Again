class Solution {
    public int[][] intervalIntersection(int[][] a, int[][] b) {
        if (a.length == 0)
            return new int[0][];
        if (b.length == 0)
            return new int[0][];
        
        ArrayList<int[]> res = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < a.length && j < b.length) {
            int a0 = a[i][0];
            int a1 = a[i][1];
            int b0 = b[j][0];
            int b1 = b[j][1];
            
            if (a1 < b0) { // No overlap, move i
                i++;
                continue;
            }
            if (b1 < a0) { // No overlap, move j
                j++;
                continue;
            }
            
            // Calculate intersection
            int start = Math.max(a0, b0);
            int end = Math.min(a1, b1);
            
            //ArrayList<Integer> arr = new ArrayList<>();
            int arr[]={start,end};
            res.add(arr);

            // Move the pointer of the interval that ends first
            if (a1 < b1) {
                i++;
            } else {
                j++;
            }
        }
        
        // Convert ArrayList<int[]> to int[][]
        return res.toArray(new int[res.size()][]);
    }
}
