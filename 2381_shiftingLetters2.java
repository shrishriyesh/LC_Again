class Solution {
    private void shiftCharacter(StringBuilder s, int start, int end, int direction) {
        for (int i = start; i <= end; i++) {
            char currentChar = s.charAt(i);
            int currentPos = currentChar - 'a';
            int newPos;
            
            if (direction == 1) {
                newPos = (currentPos + 1) % 26;
            } else {
                newPos = (currentPos - 1 + 26) % 26;
            }
            
            s.setCharAt(i, (char) ('a' + newPos));
        }
    }

    public String shiftingLetters(String s, int[][] shifts) {
        StringBuilder result = new StringBuilder(s);
        
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];
            shiftCharacter(result, start, end, direction);
        }
        
        return result.toString();
    }
}