class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;
        int dp[][] = new int[n][n];
        
        // Single character substrings are palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
            count++;
        }
        
        // Check for two-character palindromes
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = 1;
                count++;
            }
        }
        
        // Check for palindromes of length >= 3
        for (int len = 2; len < s.length(); len++) {
            for (int i = 0; i + len < s.length(); i++) {
                int j = i + len;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == 1) {
                    dp[i][j] = 1;
                    count++;
                }
            }
        }
        
        return count;
    }
}
