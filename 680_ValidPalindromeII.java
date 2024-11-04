class Solution {
    public boolean validPalindrome(String s) {
      Stack<Character> st=new Stack<>();
      int left=0;
      int right=s.length()-1;
      boolean fres=true;
      boolean sres=true;
      int skip=1;
      while(left<right)
      {
        if(s.charAt(left)!=s.charAt(right))
        {
            if(skip>0)
            {
                skip--;
                left++;
                continue;
            }
            else
            {
                fres=false;
                break;
            }
        }
        left++;
        right--;
      }


      left=0;
      right=s.length()-1;
      skip=1;
      while(left<right)
      {
        if(s.charAt(left)!=s.charAt(right))
        {
            if(skip>0)
            {
                skip--;
                right--;
                continue;
            }
            else
            {
                sres=false;
                break;
            }
        }
        left++;
        right--;
      }

      return(fres||sres);

    }
}