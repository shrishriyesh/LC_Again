    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int n=s.length();
            int ans=0;
            HashMap<Character,Integer> map=new HashMap<>();
            int i=0,j=0;
            while(j<n){
                if(map.containsKey(s.charAt(j))){
                    i=Math.max(i,map.get(s.charAt(j))+1);
                }
                map.put(s.charAt(j),j);
                j++;
                ans=Math.max(ans,j-i);
            }
            //ans=Math.max(ans,map.size());
            return ans;
        }
    }