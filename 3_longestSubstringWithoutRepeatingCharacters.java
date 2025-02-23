class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int ans=0;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            if(map.containsKey(s.charAt(i)))
            {
                ans=Math.max(ans,map.size());
                i=map.get(s.charAt(i))+1;
                map.clear();
            }
            else
            {
                map.put(s.charAt(i),i);
            }
        }
        ans=Math.max(ans,map.size());
        return ans;

    }
}