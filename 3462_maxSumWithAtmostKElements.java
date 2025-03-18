class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {
        int n=grid.length;
        int m=grid[0].length;
        long maxSum = 0;
        for(int i=0;i<n;i++)
        {
            Arrays.sort(grid[i]);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            int limit = limits[i];
            for(int j=grid[i].length-1;j>=grid[i].length-k;j--)
            {
                if(limit>0)
                {
                    list.add(grid[i][j]);
                    limit--;
                }
                else
                {
                    break;
                }
            }
        }
        Collections.sort(list);
        for(int i=list.size()-1;i>=0;i--)
        {
            if(k-->0)
            maxSum += (long)list.get(i);
            else
            break;
        }
        return maxSum;
    }
}