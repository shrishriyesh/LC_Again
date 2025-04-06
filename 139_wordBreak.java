class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] seen = new boolean[s.length() + 1];
        queue.add(0);

        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (start == s.length()) {
                return true;
            }

            for (int end = start + 1; end <= s.length(); end++) {
                if (seen[end]) {
                    continue;
                }

                if (words.contains(s.substring(start, end))) {
                    queue.add(end);
                    seen[end] = true;
                }
            }
        }

        return false;
    }
}



//Using memoization

class Solution
{
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet <String> words = new HashSet<>(wordDict);
        boolean[] memo = new boolean[s.length() + 1];
        memo[0] = true;
        int maxLength = 0;
        for (String word : wordDict) {
            maxLength = Math.max(maxLength, word.length());
        }
        for(int i=1;i<memo.length;i++)
        {
            for(int j=i-1;j>=Math.max(0,i-maxLength);j--)
            {
                if(memo[j] && words.contains(s.substring(j,i)))
                {
                    memo[i]=true;
                    break;
                }
            }
        }
        return memo[s.length()];
    }
}