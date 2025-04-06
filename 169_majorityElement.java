class Solution {
    public int majorityElement(int[] nums) {
        int c=1;
        int x=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(c==0)
            x=nums[i];
            c+=(nums[i]==x)?1:-1;
        }
        return x;
    }
}