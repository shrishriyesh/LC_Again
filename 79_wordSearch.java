class Solution {
    public boolean exist(char[][] board, String word) {
      int arr[][]=new int[board.length][board[0].length];
        boolean res=false;
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]==word.charAt(0))
                res = DFS(board,word,arr,i,j,0);
                if(res)
                return true;
                else
                {
                    // Arrays.fill(arr,0);
                    // for (int[] row: arr)
                    // Arrays.fill(row, 0);
                    continue;
                }
            }
        }
        return res;  
    }
    public boolean DFS(char[][] board,String word,int visited[][],int i,int j,int c)
    {
        if(c==word.length())
        return true;
        if(i<0||j<0||i>=board.length||j>=board[0].length||board[i][j]!=word.charAt(c)||visited[i][j]==1)
        return false;
        visited[i][j]=1;
        if(DFS(board,word,visited,i+1,j,c+1)||DFS(board,word,visited,i,j+1,c+1)||DFS(board,word,visited,i-1,j,c+1)||DFS(board,word,visited,i,j-1,c+1))
        return true;
        visited[i][j]=0;
        return false;
    }
}