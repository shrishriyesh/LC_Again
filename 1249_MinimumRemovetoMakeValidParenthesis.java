class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder res = new StringBuilder();
        int bal = 0;
        
        // First pass: remove extra ')'
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                bal--;
                if (bal < 0) {
                    bal = 0;
                    continue;
                } else {
                    res.append(c);
                }
            } else if (c == '(') {
                bal++;
                res.append(c);
            } else {
                res.append(c);
            }
        }
        
        // Second pass: remove extra '(' from the end
        StringBuilder res2 = new StringBuilder();
        bal = 0;
        for (int i = res.length() - 1; i >= 0; i--) {
            char c = res.charAt(i);
            if (c == '(') {
                bal--;
                if (bal < 0) {
                    bal = 0;
                    continue;
                } else {
                    res2.append(c);
                }
            } else if (c == ')') {
                bal++;
                res2.append(c);
            } else {
                res2.append(c);
            }
        }
        
        // Reverse res2 to get the final result
        return res2.reverse().toString();
    }
}
