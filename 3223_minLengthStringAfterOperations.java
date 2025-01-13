class Solution {
    public int minimumLength(String s) {
        int alpha[][] = new int[26][2];
        ArrayList<Integer> postToRemove = new ArrayList<>();
        for(int i=0;i<26;i++)
        {
            alpha[i][0]=-1;
            alpha[i][1]=-1;
        }
        for(int i=0;i<s.length();i++){
            int c = s.charAt(i)-'a';
            if(alpha[c][0]==-1) alpha[c][0] = i;
            else if(alpha[c][1]==-1)
            alpha[c][1] = i;
            else
            {
                postToRemove.add(alpha[c][0]);
                alpha[c][0] = alpha[c][1];
                alpha[c][1] = -1;
                postToRemove.add(i);
            }
        }
        Collections.sort(postToRemove);
        StringBuilder sb = new StringBuilder();
        int x=0;
        for(int i=0;i<s.length();i++)
        {
            if(postToRemove.size()>x && postToRemove.get(x)==i)
            {
                x++;
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.length();

    }
}