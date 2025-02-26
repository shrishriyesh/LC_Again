class Solution {
    public String longestPalindrome(String s) {
       if (s == null || s.length() < 1) return "";

        String longest = "";

        for (int i = 0; i < s.length(); i++) {
            // Odd length palindrome (centered at s[i])
            String oddPalindrome = expandAroundCenter(s, i, i);
            // Even length palindrome (centered between s[i] and s[i+1])
            String evenPalindrome = expandAroundCenter(s, i, i + 1);

            // Update longest palindrome
            if (oddPalindrome.length() > longest.length()) {
                longest = oddPalindrome;
            }
            if (evenPalindrome.length() > longest.length()) {
                longest = evenPalindrome;
            }
        }

        return longest; 
    }
     public static String expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right); // Extract the palindromic substring
    }

}