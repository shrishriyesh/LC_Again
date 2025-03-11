class Solution {
    public void sortColors(int[] nums) {
        int p0=0;
        int p1=0;
        int p2=nums.length-1;
        while(p1<=p2)
        {
            if(nums[p1]==0)
            {
                swap(nums,p0,p1);
                p0++;
                p1++;
            }
            else if(nums[p1]==2)
            {
                swap(nums,p1,p2);
                //p1++;
                p2--;
            }
            else
            {
                p1++;
            }
        }
    }
    public void swap(int[] nums,int x,int y)
    {
        int temp=nums[x];
        nums[x]=nums[y];
        nums[y]=temp;
    }
}