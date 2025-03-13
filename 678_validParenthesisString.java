class Solution {
    public boolean checkValidString(String s) {
        int l=0;
        int r=s.length()-1;
        if(r==0)
        return s.charAt(0)=='*';
        int lc=0;int rc=0;
        while(l<s.length())
        {
            char ll=s.charAt(l++);
            char rl=s.charAt(r--);
            if(ll=='('||ll=='*')
            lc++;
            else
            lc--;
            if(rl==')'||rl=='*')
            rc++;
            else
            rc--;
            if(lc<0||rc<0)
            return false;
        }

        return true;
    }
}