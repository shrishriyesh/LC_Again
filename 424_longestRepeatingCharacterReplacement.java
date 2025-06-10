class Solution {
    public int characterReplacement(String s, int k) {
       int[] freq = new int[26];  // frequency of characters in current window
        int left = 0, maxFreq = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            // Update frequency of current character
            freq[s.charAt(right) - 'A']++;

            // Update the max frequency character in current window
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            // If more than k characters need to be changed, shrink window
            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            // Update the max length of a valid window
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen; 
    }
}