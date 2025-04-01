class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        int[] last = new int[26];
        for(int i=0;i<n;i++)
        {
            last[s.charAt(i)-'a']=i;
        }

        int start=0;
        int end=0;
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            end=Math.max(end,last[s.charAt(i)-'a']);
            if(i==end)
            {
                ans.add(-start+end+1);
                start=i+1;
            }
        }
        return ans;
    }
}