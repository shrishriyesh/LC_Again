class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] count = new int[26];
        for(int i=0;i<words2.length;i++)
        {
            int[] temp = new int[26];
            for(int j=0;j<words2[i].length;j++)
            {
                temp[words2[i].charAt(j)-'a']++;
            }
            for(int j=0;j<26;j++)
            {
                count[j] = Math.max(count[j],temp[j]);
            }
        }
        List<String> res = new ArrayList<>();
        for(int i=0;i<words1.length;i++)
        {
            int temp[]=new int[26];
            for(int j=0;j<words1[i].length;j++)
            {
                temp[words1[i].charAt(j)-'a']++;
            }
            boolean flag = true;
            for(int j=0;j<26;j++)
            {
                if(temp[j]<count[j])
                {
                    flag = false;
                    break;
                }
            }
            if(flag)
            {
                res.add(words1[i]);
            }
        }
        return res;

    }
}