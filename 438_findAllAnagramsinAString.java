class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int l=p.length();
        List<Integer> res=new ArrayList<>();
        if(s.length()<l) return res;
        int[] pCount=new int[26];
        for(char c:p.toCharArray()){
            pCount[c-'a']++;
        }
        for(int i=0;i<l;i++){
            pCount[s.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++){
            if(pCount[i]!=0) break;
            if(i==25) res.add(0);
        }
        for(int i=l;i<s.length();i++){
            pCount[s.charAt(i)-'a']--;
            pCount[s.charAt(i-l)-'a']++;
            for(int j=0;j<26;j++){
                if(pCount[j]!=0) break;
                if(j==25) 
                res.add(i-l+1);
            }
        }
        return res;
    }
}