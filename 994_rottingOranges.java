class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();
        int visited[][] = new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==2)
                {
                    int arr[]=new int[2];
                    arr[0]=i;
                    arr[1]=j;
                    queue.add(arr);
                    visited[i][j]=2;
                }
                else if(grid[i][j]==1)
                {
                    fresh++;
                }
            }
        }
        int time=0;
        while(!queue.isEmpty())
        {
            int size=queue.size();
            boolean flag=false;
            for(int i=0;i<size;i++)
            {
                int arr[]=queue.poll();
                int x=arr[0];
                int y=arr[1];
                if(x-1>=0 && visited[x-1][y]==0 && grid[x-1][y]==1)
                {
                    queue.add(new int[]{x-1,y});
                    visited[x-1][y]=2;
                    fresh--;
                    flag=true;
                }
                if(x+1<m && visited[x+1][y]==0 && grid[x+1][y]==1)
                {
                    queue.add(new int[]{x+1,y});
                    visited[x+1][y]=2;
                    fresh--;
                    flag=true;
                }
                if(y-1>=0 && visited[x][y-1]==0 && grid[x][y-1]==1)
                {
                    queue.add(new int[]{x,y-1});
                    visited[x][y-1]=2;
                    fresh--;
                    flag=true;
                }
                if(y+1<n && visited[x][y+1]==0 && grid[x][y+1]==1)
                {
                    queue.add(new int[]{x,y+1});
                    visited[x][y+1]=2;
                    fresh--;
                    flag=true;
                }
            }
            if(flag)
            {
                time++;
            }
        }
        if(fresh==0)
        {
            return time;
        }
        return -1;
    }
}