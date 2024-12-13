class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs[0].equals("")) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        
        int c = 0; // To track the common prefix length
        while (c < strs[0].length()) {
            char x = strs[0].charAt(c); // Character to compare
            
            for (int i = 1; i < strs.length; i++) {
                if (c >= strs[i].length() || strs[i].charAt(c) != x) {
                    return strs[0].substring(0, c);
                }
            }
            c++; // Increment the length of the common prefix
        }
        return strs[0].substring(0, c);
    }
}
