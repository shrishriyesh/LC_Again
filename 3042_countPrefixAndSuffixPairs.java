class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                // Check if the length of `words[i]` is less than or equal to `words[j]`
                if (words[i].length() <= words[j].length()) {
                    String prefix = words[j].substring(0, words[i].length());
                    String suffix = words[j].substring(words[j].length() - words[i].length());
                    
                    if (words[i].equals(prefix) && words[i].equals(suffix)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
