class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
       int l=word.length();
       int num=0;
       int charsum=0;
        boolean consflag=false;
       for(int i=0;i<abbr.length();i++)
       {
        char c=abbr.charAt(i);
        if(Character.isLetter(c))
        {
            charsum++;
            consflag=false;
            charsum+=num;
            if(charsum>l||c!=word.charAt(charsum-1))
            return false;
            num=0;
        }
        else
        {  
            if(consflag)
            {
               num=(num*10)+Character.getNumericValue(c); 
            }
            else
            {if(c=='0')
            return false;
                num=Character.getNumericValue(c);
            consflag=true;}
        }
       } 
       charsum+=num;
       return (charsum==l&&abbr.length()<=l);
    }

}