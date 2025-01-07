class Solution {
    public List<String> stringMatching(String[] words) {
        ArrayList<String> res= new ArrayList<>();
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        for(int i=0;i<words.length;i++)
        {
            int len=words[i].length();
            for(int j=i+1;j<words.length;j++)
            {
                if(words[j].contains(words[i]))
                {
                    res.add(words[i]);
                    break;
                }
            }
        }
        return res;
    }
}