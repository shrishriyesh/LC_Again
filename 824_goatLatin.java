class Solution {
    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder toAdd = new StringBuilder("maa");
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<words.length;i++)
        {
            String word = words[i];
            if(word.charAt(0)=='A'||word.charAt(0)=='a'||word.charAt(0)=='E'||word.charAt(0)=='e'||word.charAt(0)=='I'||word.charAt(0)=='i'||word.charAt(0)=='O'||word.charAt(0)=='o'||word.charAt(0)=='U'||word.charAt(0)=='u') {
                sb.append(word);
                //sb.append(toAdd.toString());
            } else {
                sb.append(word.substring(1)).append(word.charAt(0));
                //sb.append(toAdd.toString());
            }
            sb.append(toAdd).append(" ");
            toAdd.append("a");
        }
        return sb.toString().trim();
    }
}