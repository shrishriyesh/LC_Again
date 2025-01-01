class Solution {
    public int maxScore(String s) {
        int os=0;
        int zs=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                zs++;
            }
            if(s.charAt(i)=='1'){
                os++;
            }
        }
        int max=0;
        int left=0;
        int right=os;
        for(int i=0;i<s.length()-1;i++)
        {
            if(s.charAt(i)=='0'){
                left++;
            }
            if(s.charAt(i)=='1'){
                right--;
            }
            max=Math.max(max,left+right);
        }
        return max;
    }
}