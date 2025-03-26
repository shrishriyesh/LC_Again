class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        if (n == 1)
            return 1;

        int i = 0; // write index
        int j = 0; // read index

        while (j < n) {
            char current = chars[j];
            int count = 0;

            // Count frequency of current character
            while (j < n && chars[j] == current) {
                j++;
                count++;
            }

            chars[i++] = current; // write the character

            if (count > 1) {
                // convert count to string and write each digit
                String cnt = String.valueOf(count);
                for (char c : cnt.toCharArray()) {
                    chars[i++] = c;
                }
            }
        }

        return i;
    }
}