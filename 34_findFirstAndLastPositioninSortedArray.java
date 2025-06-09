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


/// Aproach 2
class Solution{
    public int[] searchRange(int[] nums, int target) {
        int[] ans=new int[2];
        ans[0]=firstocc(nums,target);
        if(ans[0]==-1){
            ans[1]=-1;
            return ans;
        }
        ans[1]=lastocc(nums,target,ans[0]);
        return ans;
    }
    public int firstocc(int nums[],int target)
    {
        int l=0;
        int r=nums.length-1;
        int ans=-1;
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(nums[mid]>=target)
            {
                if(nums[mid]==target)
                    ans=mid;
                r=mid-1;
            }
            else
                l=mid+1;
        }
        return ans;
    }
    public int lastocc(int nums[],int target,int start)
    {
        int l=start;
        int r=nums.length-1;
        int ans=start;
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(nums[mid]<=target)
            {
                if(nums[mid]==target)
                    ans=mid;
                l=mid+1;
            }
            else
                r=mid-1;
        }
        return ans;
    }
}