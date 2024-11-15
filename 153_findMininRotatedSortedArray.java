class Solution {
    public int findMin(int[] nums) {
        int left=0;
        int right=nums.length-1;
        //int mid=left+right/2;
        while(left<right)
        {
            int mid = left + (right - left) / 2;
            // if(nums[mid]<nums[left]&&nums[mid]<nums[right])
            // return nums[mid];
            // else 
            if(nums[mid]<nums[right])
            {
                right=mid;
            }
            else
            {
                left=mid+1;
            }
        }
        return nums[left];
    }
}