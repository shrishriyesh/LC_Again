class Solution {
    public String tictactoe(int[][] moves) {
        int arr[][] = new int[3][3];
        
        for(int i=0;i<moves.length;i++){
            int[] move=moves[i];
            if(i<4)
            {
            arr[move[0]][move[1]] = (i%2==0?1:2);
            continue;
            }
            arr[move[0]][move[1]] = (i%2==0?1:2);
            if(check(arr)){
                return i%2==0?"A":"B";
            }
            
        }
        return moves.length>=9?"Draw":"Pending";
    }
    public boolean check(int[][] moves){
        for(int i=0;i<3;i++){
            if(moves[i][0]==moves[i][1]&&moves[i][1]==moves[i][2]&&moves[i][0]!=0){
                return true;
            }
            if(moves[0][i]==moves[1][i]&&moves[1][i]==moves[2][i]&&moves[0][i]!=0){
                return true;
            }
        }
        if(moves[0][0]==moves[1][1]&&moves[1][1]==moves[2][2]&&moves[0][0]!=0){
            return true;
        }
        if(moves[0][2]==moves[1][1]&&moves[1][1]==moves[2][0]&&moves[0][2]!=0){
            return true;
        }
        return false;
    }
}