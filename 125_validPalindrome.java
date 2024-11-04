class Solution {
    public boolean isPalindrome(String s) {
        if(s.length()==1)
        {
            return true;
        }
      boolean flag=true;
      int l=0;
      int r=s.length()-1;
      while(l<r)
      {
        char lc=s.charAt(l);
        char rc=s.charAt(r);
        if(!Character.isLetterOrDigit(lc))
        {
            l++;
            continue;
        }
        if(!Character.isLetterOrDigit(rc))
        {
            r--;
            continue;
        }
        if(Character.toLowerCase(lc)!=Character.toLowerCase(rc))
        {
            return false;
        }
        l++;
        r--;
      }
      return true;  
    }
}