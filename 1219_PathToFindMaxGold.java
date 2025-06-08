class Solution {
    public int getMaximumGold(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int maxGold = 0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]!=0)
                {
                int gold=DFS(grid,i,j,m,n,visited);
                maxGold=Math.max(maxGold,gold);
                }
            }
        }
        return maxGold;
    }
    public int DFS(int[][] grid,int i,int j, int m,int n,boolean[][] visited)
    {
        if(i<0||j<0||i>=m||j>=n||visited[i][j]||grid[i][j]==0) return 0;
        visited[i][j]=true;
        int left=DFS(grid,i-1,j,m,n,visited);
        int right=DFS(grid,i+1,j,m,n,visited);
        int up=DFS(grid,i,j-1,m,n,visited);
        int down=DFS(grid,i,j+1,m,n,visited);
        visited[i][j]=false;
        return grid[i][j]+Math.max(Math.max(left,right),Math.max(up,down));
    }
}