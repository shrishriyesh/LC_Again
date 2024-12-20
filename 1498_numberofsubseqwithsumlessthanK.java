class Solution {
    public int numSubseq(int[] nums, int target) 
    {
        Arrays.sort(nums);
        int mod=1_000_000_007;
        long res=0;
        int left=0;int right=nums.length-1;
        int power[]=new int[nums.length];
        power[0]=1;
        for(int i=1;i<nums.length;i++)
        {
            power[i]=(power[i-1]*2)%mod;
        }
        while(left<=right)
        {
            if(nums[left]+nums[right]<=target)
            {
                res=(res+power[right-left])%mod;
                left++;
            }
            else
            {
                right--;
            }
        }
        return (int)res%mod;
    }
}