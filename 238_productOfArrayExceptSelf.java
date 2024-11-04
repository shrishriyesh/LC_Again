class Solution {
    public int[] productExceptSelf(int[] nums) {
        int arrp[]=new int[nums.length];
        int arrs[]=new int[nums.length];
        int prod1=1;
        int j=nums.length-1;
        int prod2=1;
        for(int i=0;i<nums.length;i++)
        {
            arrp[i]=prod1*nums[i];
            prod1*=nums[i];
            arrs[j]=prod2*nums[j];
            prod2*=nums[j];
            j--;
        }
        for(int i=1;i<nums.length-1;i++)
        {
            nums[i]=arrp[i-1]*arrs[i+1];
        }
        nums[0]=arrs[1];
        nums[nums.length-1]=arrp[nums.length-2];
        return nums;
    }
}