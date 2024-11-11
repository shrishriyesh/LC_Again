class Solution {
    public TreeNode str2tree(String s) {
        if (s == null || s.isEmpty()) return null;

        // Find root value, including negative sign if present
        int i = 0;
        while (i < s.length() && (Character.isDigit(s.charAt(i)) || s.charAt(i) == '-')) {
            i++;
        }
        String l="";
        String r="";
        int rootVal = Integer.parseInt(s.substring(0, i));
        TreeNode root = new TreeNode(rootVal);

        // Find left and right subtrees by tracking parentheses
        int start = i;
        if (start < s.length() && s.charAt(start) == '(') {
            int count = 0;
            for (i = start; i < s.length(); i++) {
                if (s.charAt(i) == '(') count++;
                if (s.charAt(i) == ')') count--;
                if (count == 0) break;
            }

            l=s.substring(start + 1, i);
        start = i + 1;
            
        }
        
        if (start < s.length() && s.charAt(start) == '(') {

            r=s.substring(start + 1, s.length() - 1);
        }
        root.left=str2tree(l);

        root.right=str2tree(r);
        return root;
    }
}
