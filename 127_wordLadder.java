class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();
        Queue<String> q = new LinkedList<>();
        //Set<String> set = new HashSet<>();
        Set<String> dict = new HashSet<>(wordList);
        q.add(beginWord);
        int level = 1;
        while(!q.isEmpty())
        {
            if(q.contains(endWord))
                return level;
            int size = q.size();
            //char[ ] ch = beginWord.toCharArray();
            for(int i = 0; i < size; i++)
            {
                String word = q.poll();
                for(int j = 0; j < word.length(); j++)
                {
                    char[] ch = word.toCharArray();
                    for(char c = 'a'; c <= 'z'; c++)
                    {
                        ch[j] = c;
                        String newWord = new String(ch);
                        if(dict.contains(newWord))
                        {
                            q.add(newWord);
                            dict.remove(newWord);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}