class Solution {
    public boolean hasSameDigits(String s) {
        StringBuilder sb = new StringBuilder(s);
        while(sb.length()>2)
        {
            int num[]=sb.chars().map(c->c-'0').toArray();
            StringBuilder next=new StringBuilder();
            for(int i=0;i<num.length-1;i++)
            {
                next.append((num[i]+num[i+1])%10);
            }
            sb=next;
        }
        return sb.charAt(0)==sb.charAt(1);
    }
}