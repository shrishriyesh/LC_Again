class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int i=0;
        int j=0;
        for(; i<name.length() && j<typed.length();) {
            char c1 = name.charAt(i);
            char c2 = typed.charAt(j);
            if(c1 != c2) return false;
            int count1 = 0, count2 = 0;
            while(i < name.length() && name.charAt(i) == c1) {
                count1++;
                i++;
            }
            while(j < typed.length() && typed.charAt(j) == c2) {
                count2++;
                j++;
            }
            if(count2 < count1) return false;
        }
        if(j<typed.length()||i<name.length())
        return false;
        return true;
        
    }
}