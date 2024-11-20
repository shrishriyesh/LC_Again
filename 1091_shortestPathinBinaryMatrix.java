class Solution {
    int dir[][]={{-1,-1},{-1,1},{1,-1},{1,1},{1,0},{0,1},{-1,0},{0,-1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if (grid[0][0] == 1) return -1;
		if (grid[m-1][n-1] == 1) return -1;
        if (m - 1 == 0 && n - 1 == 0) return 1;
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{0,0});
        grid[0][0]=1;
        while(!q.isEmpty())
        {
            int size=q.size();
            int arr[]=q.poll();
            int x=arr[0];
            int y=arr[1];
            if(x==m-1&&y==n-1)
            return grid[x][y];
                int score=grid[x][y];
                for(int i=0;i<8;i++)
                {
                    int nx=x+dir[i][0];
                    int ny=y+dir[i][1];
                    if(nx>=0&&ny>=0&&nx<m&&ny<n&&grid[nx][ny]==0)
                    {
                        grid[nx][ny]=score+1;
                        q.add(new int[]{nx,ny});
                    }
        }
        }
        return -1;
    }
}