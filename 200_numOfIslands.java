class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int count=0;
        int [][] visited=new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(visited[i][j]==0&&grid[i][j]=='1')
                {
                    DFS(i,j,grid,visited,m,n);
                    count++;
                }
            }
        }
        return count;
    }

    public void DFS(int i,int j,char[][] grid,int[][]visited,int m,int n)
    {
        if(grid[i][j]=='0'||visited[i][j]==1)
        {
            return;
        }
        visited[i][j]=1;
        if(i+1<m)
        {
            DFS(i+1,j,grid,visited,m,n);
        }
        if(i-1>=0)
        {
            DFS(i-1,j,grid,visited,m,n);
        }
        if(j+1<n)
        {
            DFS(i,j+1,grid,visited,m,n);
        }
        if(j-1>=0)
        {
            DFS(i,j-1,grid,visited,m,n);
        }
    }
}