class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l=nums.length;
        int[] ans=new int[2];
        if(l==0){
            ans[0]=-1;
            ans[1]=-1;
            return ans;
        }
        int index=binsearch(nums,target,0,l-1);
        if(index==-1){
            ans[0]=-1;
            ans[1]=-1;
            return ans;
        }
        int i=index;
        while(i>=0&&nums[i]==target){
            i--;
        }
        ans[0]=i+1;
        i=index;
        while(i<l&&nums[i]==target){
            i++;
        }
        ans[1]=i-1;
        return ans;

    }
    public int binsearch(int[] nums,int target,int l,int r){
        int mid=(l+r)/2;
        if(l>r){
            return -1;
        }
        if(nums[mid]==target){
            return mid;
        }
        if(nums[mid]>target){
            return binsearch(nums,target,l,mid-1);
        }
        else{
            return binsearch(nums,target,mid+1,r);
        }
    }
}