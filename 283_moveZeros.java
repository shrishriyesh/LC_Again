class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length<2)
        return;
        int l=0;
        for(int r=0;r<nums.length;r++)
        {
            if(nums[r]!=0)
            nums[l++]=nums[r];
        }

    while(l<nums.length)
    {
        nums[l++]=0;
    }
        
    }
}