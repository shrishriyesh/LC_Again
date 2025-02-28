class Solution {
    public boolean isValidSudoku(char[][] board) {
        int row[][]= new int[9][9];
        int col[][]= new int[9][9];
        int grid[][]= new int[9][9];
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]!='.')
                {
                int num=board[i][j]-'0';
                if(row[i][num-1]==1 || col[j][num-1]==1 || grid[((i/3)*3)+j/3][num-1]==1)
                {
                    return false;
                }
                if(num!='.')
                {
                    row[i][num-1]=1;
                    col[j][num-1]=1;
                    grid[((i/3)*3)+j/3][num-1]=1;
                }
                }
            }
            
        }
        return true;
    }
}