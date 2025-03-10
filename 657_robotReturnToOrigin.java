class Solution {
    public boolean judgeCircle(String moves) {
        if(moves == null || moves.length() == 0) {
            return true;
        }
        int x = 0, y = 0;
        for(char a:moves.toCharArray()) {
            if(a == 'U') {
                y++;
            } else if(a == 'D') {
                y--;
            } else if(a == 'L') {
                x--;
            } else if(a == 'R') {
                x++;
            }
        }
        return x == 0 && y == 0;
    }
}