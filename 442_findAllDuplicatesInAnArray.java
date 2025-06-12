class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n=nums.length;
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            nums[Math.abs(nums[i])-1]=-nums[Math.abs(nums[i])-1];
        }
        for(int i=0;i<n;i++)
        {
            if(nums[Math.abs(nums[i])-1]>0)
            {
                ans.add(Math.abs(nums[i]));
                nums[Math.abs(nums[i]) - 1]*=-1;
            }
        }
        return ans;
    }
}