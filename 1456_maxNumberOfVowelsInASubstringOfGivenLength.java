class Solution {
    public int maxVowels(String s, int k) {
        int alpha[] = new int[26];
        int res=0;
        for(int i=0;i<k;i++)
        {
            int c=s.charAt(i)-'a';
            alpha[s.charAt(i)-'a']++;
            if(c==0 || c==4 || c==8 || c==14 || c==20)
                res++;
        }
        int max=res;
        for(int i=k;i<s.length();i++)
        {
            int c=s.charAt(i)-'a';
            alpha[s.charAt(i)-'a']++;
            if(c==0 || c==4 || c==8 || c==14 || c==20)
                res++;
            c=s.charAt(i-k)-'a';
            alpha[s.charAt(i-k)-'a']--;
            if(c==0 || c==4 || c==8 || c==14 || c==20)
                res--;
            max=Math.max(max,res);
        }
        return max;
    }
}