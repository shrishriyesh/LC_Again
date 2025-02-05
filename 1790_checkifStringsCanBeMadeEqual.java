class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        boolean flag = false;
        int firstdiff=-1;
        int seconddiff=-1;

        for(int  i=0;i<s1.length();i++)
        {
            if(s1.charAt(i)==s2.charAt(i))
                continue;
            if(firstdiff==-1)
                firstdiff=i;
            else if(seconddiff==-1)
                seconddiff=i;
            else
                return false;
        }
        if(firstdiff==-1 && seconddiff==-1)
            return true;
        if(firstdiff==-1 || seconddiff==-1)
            return false;
        if(s1.charAt(firstdiff)==s2.charAt(seconddiff) && s1.charAt(seconddiff)==s2.charAt(firstdiff))
            return true;
        return false;    
    }
}