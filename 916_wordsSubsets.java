class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        ArrayList<String> res = new ArrayList<>();
        int[] maxFreq = new int[26];
        for (String word : words2) {
            int[] freq = new int[26];
            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
                maxFreq[c - 'a'] = Math.max(maxFreq[c - 'a'], freq[c - 'a']);
            }
        }
        for (String word : words1) {
            int[] freq = new int[26];
            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
            }
            boolean isUniversal = true;
            for (int i = 0; i < 26; i++) {
                if (freq[i] < maxFreq[i]) {
                    isUniversal = false;
                    break;
                }
            }
            if (isUniversal) {
                res.add(word);
            }
        }
        return res;
    }
}