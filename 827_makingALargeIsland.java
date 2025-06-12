class Solution {
    int dirs[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    public int largestIsland(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        boolean visited[][] = new boolean[m][n];
        int max=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==0)
                {
                    grid[i][j]=1;
                    max=Math.max(max,DFS(grid,visited,i,j,m,n));
                    grid[i][j]=0;
                    visited=new boolean[m][n];
                }
            }
        }
        return max==0?m*n:max;
    }
    public int DFS(int grid[][], boolean visited[][], int i, int j, int m, int n)
    {
      if(i<0 || j<0 || i>=m || j>=n || visited[i][j] || grid[i][j]==0)
          return 0;
        visited[i][j]=true;
      int left= DFS(grid,visited,i-1,j,m,n);
        int right= DFS(grid,visited,i+1,j,m,n);
        int up= DFS(grid,visited,i,j-1,m,n);
        int down= DFS(grid,visited,i,j+1,m,n);
        return left+right+up+down+1;
}
}

////
/// [0,0,0,0,0,0,0]
/// [0,1,1,1,1,0,0]
/// [0,1,0,0,1,0,0]
/// [1,0,1,0,1,0,0]
/// [0,1,0,0,1,0,0]
/// [0,1,0,0,1,0,0]
/// [0,1,1,1,1,0,0]