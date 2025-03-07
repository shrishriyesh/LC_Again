class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums.length==1)
        return (nums[0]==1?1:0);
        if(nums.length==2)
        return(nums[0]==0&&nums[1]==0?0:nums[0]==1&&nums[1]==1?2:1);

        int max=0;
        int curSum=0;
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i]==1 && nums[i]==nums[i+1])
            {
                curSum++;
                max=Math.max(max,curSum);
                continue;
            }
            curSum=0;
        }
        return max+1;
    }
}