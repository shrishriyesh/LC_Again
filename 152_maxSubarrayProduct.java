class Solution {
    public int maxProduct(int[] nums) {
        int pre=1;
        int suff=1;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            int num=nums[i];
            int pnum=nums[nums.length-i-1];
            if(suff==0)
            {
                suff=1;
            }
            suff*=num;
            if(pre==0)
            {
                pre=1;
            }
            pre*=pnum;
            max=Math.max(max,Math.max(pre,suff));
        }
        return max;
    }
}