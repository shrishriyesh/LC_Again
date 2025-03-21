class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==1)
        return (nums[0]==target?0:-1);
        int minpos=findMin(nums);
        if(target>nums[nums.length-1])
        return binsearch(nums,target,0,minpos-1);
        else
        return binsearch(nums,target,minpos,nums.length-1);
    }

    public int findMin(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while(left<right)
        {
            int mid = left + (right - left) / 2;
            if(nums[mid]<nums[right])
            {
                right=mid;
            }
            else
            {
                left=mid+1;
            }
        }
        return left;
    }

    public int binsearch(int nums[], int t, int l, int r)
    {
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(nums[mid]==t)
            return mid;
            else if(nums[mid]<t)
            l=mid+1;
            else
            r=mid-1;
        }
        return -1;
    }
}


///
/// 
// /// class Solution {
// public int search(int[] nums, int target) {
//     int l=0, r=nums.length-1;
//     while(l<r)
//     {
//         int mid = l + (r-l)/2;
//         if(nums[mid]==target)
//         return mid;
//         if(nums[mid]>nums[r])
//             l=mid+1;
//         else
//             r=mid;
//     }
//     int pivot=l;
//     if(nums[l]==target)
//         return l;
//     l = 0;
//     r = nums.length - 1;
//     if (target >= nums[pivot] && target <= nums[r]) {
//         l = pivot;
//     } else {
//         r = pivot - 1;
//     }
//     while(l<=r)
//     {
//         int mid = l + (r-l)/2;
//         if(nums[mid]==target)
//             return mid;
//         else if(nums[mid]<target)
//             l=mid+1;
//         else
//             r=mid-1;
//     }
    
//     return -1;
// }
// }