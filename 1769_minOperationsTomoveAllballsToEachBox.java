class Solution {
    public int[] minOperations(String boxes) {
        int res[]=new int[boxes.length()];
        for(int i=0;i<boxes.length();i++)
        {
            for(int j=0;j<boxes.length();j++)
            {
                if(i==j)
                continue;
                else
                {
                    if(boxes.charAt(j)=='1')
                    res[i]+=Math.abs(i-j);
                }
            }
        }
        return res;
    }
}