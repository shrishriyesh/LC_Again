class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l=0;
        int r=nums.length-1;
        return binarySearch(nums,l,r);
    }
    public int binarySearch(int[] nums,int l,int r){
        if(l==r){
            return nums[l];
        }
        int mid=l+(r-l)/2;
        if(mid%2==0){
            if(nums[mid]==nums[mid+1]){
                return binarySearch(nums,mid+2,r);
            }else{
                return binarySearch(nums,l,mid);
            }
        }else{
            if(nums[mid]==nums[mid-1]){
                return binarySearch(nums,mid+1,r);
            }else{
                return binarySearch(nums,l,mid-1);
            }
        }
    }
}