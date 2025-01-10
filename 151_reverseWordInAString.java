class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ");
        for(int i=words.length-1;i>=0;i--)
        {
            String word = words[i].trim();
            if(word.length() > 0)
            {
                sb.append(word);
            }
            if(i > 0 && word.length() > 0)
            {
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }
}